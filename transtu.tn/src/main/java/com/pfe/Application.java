package com.pfe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.pfe.Service.DistrictService;
import com.pfe.Service.TypeService;

import jakarta.annotation.PostConstruct;
@ComponentScan(basePackages={"com.pfe.Controller","com.pfe.Service"})
@SpringBootApplication

public class Application {
	 @Autowired
	    private TypeService typeService;

	    @Autowired
	    private DistrictService districtService;
	   
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@PostConstruct
    public void initializeData() {
        if (!typeService.hasAnyTypeTransport()) {
            typeService.createTypeTransports();
        } else {
            System.out.println("Types of transport already exist, skipping creation.");
        }

        if (!districtService.hasAnyDistrict()) {
            districtService.createDistricts();
        } else {
            System.out.println("Districts already exist, skipping creation.");
        }
    }
}
