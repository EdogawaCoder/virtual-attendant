package services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class OpenIAService {


    private final String apiKey = System.getenv("OPENAI_API_KEY");

    private static String quoteJson(String s) {
        return new ObjectMapper().valueToTree(s).toString();
    }


    public String toSendQuestion(String question) throws IOException, InterruptedException {

        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalStateException("The OPENAI_API_KEY environment variable must be set.");
        }

        String endpoint = "https://api.openai.com/v1/responses";

        String jsonBody = """
                {
                  "model": "gpt-5",
                  "input": %s
                }
                """.formatted(quoteJson(question));

        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(30))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .timeout(Duration.ofSeconds(60))
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();


        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() < 200 || response.statusCode() >= 300) {
            throw new IOException("Error HTTP " + response.statusCode() + ": " + response.body());
        }


        if (response.statusCode() < 200 || response.statusCode() >= 300) {
            throw new IOException("Erro HTTP " + response.statusCode() + ": " + response.body());
        }


        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.body());

        var answer = root
                .path("output").get(1)
                .path("content").get(0)
                .path("text")
                .asText();

        return answer;
    }
}
