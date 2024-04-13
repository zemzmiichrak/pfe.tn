package com.pfe.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.pfe.Repository.DistrictRepository;
import com.pfe.Service.DistrictService;

import jakarta.transaction.Transactional;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final DistrictService districtService;
    private final DistrictRepository districtRepository;

    @Autowired
    public DataLoader(DistrictService districtService, DistrictRepository districtRepository) {
        this.districtService = districtService;
        this.districtRepository = districtRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (districtRepository.count() == 0) {
            districtService.createDistricts();
        } else {
            System.out.println("Districts already exist, skipping creation.");
        }
    }
}