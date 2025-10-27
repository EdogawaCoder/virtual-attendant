package repositories;

import entities.CustomerService;
import interfaces.CustomerServiceRepository;

import java.io.PrintWriter;

public class CustomServiceServiceRepositoryXml implements CustomerServiceRepository {

    @Override
    public void exportCustomerService(CustomerService customService) throws Exception {

        var printWriter = new PrintWriter("c:\\temp\\customservice" + customService.getId() + ".xml");

        printWriter.write("<?xml version='1.0' encoding='UTF-8'?>");

        printWriter.write("<acustomerService>");
        printWriter.write("<id>" + customService.getId() + "</id>");
        printWriter.write("<userName>" + customService.getNameUser() + "</userName>");
        printWriter.write("<data>" + customService.getDateHour() + "</data>");
        printWriter.write("<question>" + customService.getQuestion() + "</question>");
        printWriter.write("<question>" + customService.getAnswer() + "</answer>");
        printWriter.write("</customerService>");

        printWriter.close();
    }
}
