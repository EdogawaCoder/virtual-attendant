package repositories;


import com.fasterxml.jackson.databind.ObjectMapper;
import entities.CustomerService;
import interfaces.CustomerServiceRepository;

import java.io.File;

public class CustomServiceRepositoryJson implements CustomerServiceRepository {


    @Override
    public void exportCustomerService(CustomerService customService) throws Exception {


        // Definindo o arquivo que será criado
        var file = new File("c:\\temp\\customerservice_" + customService.getId() + ".json");

        // Exportar os dados para um arquivo JSON
        var objectMapper = new ObjectMapper();
        objectMapper.writeValue(file, customService);

    }
}
