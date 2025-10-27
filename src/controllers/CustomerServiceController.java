package controllers;

import interfaces.CustomerServiceRepository;
import repositories.CustomServiceRepositoryJson;
import services.OpenIAService;

import java.util.Scanner;
import java.util.UUID;

public class CustomerServiceController {

    private CustomerServiceRepository repository;

    public void executeCustomerService() throws Exception {
        var scanner = new Scanner(System.in);

        System.out.println("\nBe welcome at the virtual Customer Service\n");

        var customService = new entities.CustomerService();
        customService.setId(UUID.randomUUID());
        customService.setDateHour(new java.util.Date());

        System.out.println("Enter the name of the user...: ");
        customService.setNameUser(scanner.nextLine());

        System.out.println("Write the question...........: ");
        customService.setQuestion(scanner.nextLine());

        System.out.println("How you wish to save the service? (1) JSON or (2)XML? ");
        var option = scanner.nextInt();
        scanner.nextLine(); // limpa o buffer

        switch (option) {
            case 1 -> repository = new CustomServiceRepositoryJson();
            case 2 -> repository = new repositories.CustomServiceServiceRepositoryXml();
            default -> System.out.println("Invalid option");
        }

        System.out.println("Your question is being processed...");

        var openIAService = new OpenIAService();

        var answer = openIAService.toSendQuestion(customService.getQuestion());

        customService.setAnswer(answer);

        System.out.println("Your answer is: " + answer);


        repository.exportCustomerService(customService);


        scanner.close();
    }

}

