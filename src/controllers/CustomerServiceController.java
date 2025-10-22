package controllers;

import interfaces.CustomerServiceRepository;
import repositories.CustomServiceRepositoryJson;

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
        var option = Integer.parseInt(String.valueOf(scanner.nextInt()));

        switch (option) {
            case 1:
                repository = new CustomServiceRepositoryJson();
                break;
            case 2:
                repository = new repositories.CustomServiceServiceRepositoryXml();
                break;
            default:
                System.out.println("Invalid option");
                break;
        }

        if (repository != null) {
            repository.exportCustomerService(customService);
        }


    }
}
