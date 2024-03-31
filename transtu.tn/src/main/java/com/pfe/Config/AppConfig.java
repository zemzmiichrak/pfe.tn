package com.pfe.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pfe.Repository.TypeTransportRepository;
import com.pfe.Service.TypeService;

@Configuration
public class AppConfig {

    @Autowired
    private TypeService typeService;

    @Bean
    public CommandLineRunner commandLineRunner(TypeTransportRepository typeTransportRepository) {
        return args -> {
            if (typeTransportRepository.count() == 0) {
                typeService.createTypeTransports();
            }
        };
    }
}