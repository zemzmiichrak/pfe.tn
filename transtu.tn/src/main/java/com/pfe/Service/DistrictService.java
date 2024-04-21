package com.pfe.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.Entity.District;
import com.pfe.Repository.DistrictRepository;
import com.pfe.Request.DistrictRequest;

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
        List<District> districts = districtRepository.findAll();
        if (districts == null || districts.isEmpty()) {
            throw new IllegalStateException("No districts found");
        }
        return districts;
    }
    public Set<District> getDistrictsByLabels(Set<String> districtLabels) {
        List<District> districtsList = districtRepository.findByLabelIn(districtLabels);
        return districtsList.stream().collect(Collectors.toSet());
    }
  
    public List<District> getDistrictsByRole(Long id) {
        List<District> districts = districtRepository.findByRolesId(id);
        return districts;
    }
    
    public Set<District> getDistrictsByIds(Set<Long> ids) {
        if (ids == null) {
            return Collections.emptySet(); 
        }
        List<District> districts = districtRepository.findAllById(ids);
        return new HashSet<>(districts); 
    }
    public District createDistrictFromRequest(DistrictRequest districtRequest) {
        District district = new District();
        district.setLabel(districtRequest.getLabel());
        district.setAddress(districtRequest.getAddress());
        return districtRepository.save(district);
    }

    public District createDistrict(District district) {
        return districtRepository.save(district);
    }
    public District getDistrictById(Long id) {
        Optional<District> optionalDistrict = districtRepository.findById(id);
        if (optionalDistrict.isPresent()) {
            return optionalDistrict.get();
        } else {
            throw new IllegalArgumentException("District not found with ID: " + id);
        }
    }

    public District saveDistrict(District district) {
        Optional<District> existingDistrict = districtRepository.findByLabel(district.getLabel());
        return existingDistrict.orElseGet(() -> districtRepository.save(district));
    }

    
    }