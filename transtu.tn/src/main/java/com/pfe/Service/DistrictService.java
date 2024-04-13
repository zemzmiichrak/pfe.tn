package com.pfe.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.Entity.District;
import com.pfe.Repository.DistrictRepository;

@Service
public class DistrictService{

    @Autowired
    private DistrictRepository districtRepository;

    public void createDistricts() {
      
        District district1 = new District();
        district1.setLabel("Bab Saadoun");
        district1.setAddress("Adresse de Bab Saadoun");
        districtRepository.save(district1);

        District district2 = new District();
        district2.setLabel("Charguia 1");
        district2.setAddress("Adresse de Charguia 1");
        districtRepository.save(district2);

        District district3 = new District();
        district3.setLabel("Charguia 2");
        district3.setAddress("Adresse de Charguia 2");
        districtRepository.save(district3);

        District district4 = new District();
        district4.setLabel("Zahrouni");
        district4.setAddress("Adresse de Zahrouni");
        districtRepository.save(district4);

        District district5 = new District();
        district5.setLabel("Bir Kasaa");
        district5.setAddress("Adresse de Bir Kasaa");
        districtRepository.save(district5);

        District district6 = new District();
        district6.setLabel("Bokri");
        district6.setAddress("Adresse de Bokri");
        districtRepository.save(district6);
    }
  
    public List<District> getAllDistricts() {
        return districtRepository.findAll();
    }

 
    public Set<District> getDistrictsByIds(Set<Long> districtIds) {
        return districtRepository.findAllById(districtIds).stream().collect(Collectors.toSet());
    }

    public Set<District> getDistrictsByLabels(Set<String> districtLabels) {
        List<District> districtsList = districtRepository.findByLabelIn(districtLabels);
        return districtsList.stream().collect(Collectors.toSet());
    }

    public boolean hasAnyDistrict() {
        return districtRepository.count() > 0;
    }

	
}