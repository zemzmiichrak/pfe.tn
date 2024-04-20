package com.pfe.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.Entity.District;
import com.pfe.Entity.Ligne;
import com.pfe.Repository.LigneRepository;

import jakarta.transaction.Transactional;

@Service
public class LigneService {

    @Autowired
    private LigneRepository ligneRepository;
    
    @Autowired
    DistrictService districtService;

    public List<Ligne> getAllLignes() {
        return ligneRepository.findAll();
    }
    public Ligne addLigne(String code, String label, List<District> districts) {
        if (ligneRepository.existsByCodeOrLabel(code, label)) {
            throw new IllegalArgumentException("Ligne with the same code or label already exists.");
        }

        Ligne ligne = new Ligne();
        ligne.setCode(code);
        ligne.setLabel(label);

        List<District> savedDistricts = new ArrayList<>();
        for (District district : districts) {
            if (district.getId() != null) {
        
                District existingDistrict = districtService.getDistrictById(district.getId());
                if (existingDistrict != null) {
                    savedDistricts.add(existingDistrict);
                } else {
                    throw new IllegalArgumentException("District not found with ID: " + district.getId());
                }
            } else {
       
                District savedDistrict = districtService.saveDistrict(district);
                savedDistricts.add(savedDistrict);
            }
        }

        ligne.setDistricts(savedDistricts);
        return ligneRepository.save(ligne);
    }

    @Transactional
    public void deleteLigne(Long id) {
        Optional<Ligne> ligneOptional = ligneRepository.findById(id);
        if (ligneOptional.isPresent()) {
            ligneRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Ligne not found with ID: " + id);
        }
    }

    public Ligne updateLigne(Long id, String newCode, String newLabel, List<District> newDistricts) {
        Optional<Ligne> existingLigneOptional = ligneRepository.findById(id);
        if (existingLigneOptional.isPresent()) {
            Ligne existingLigne = existingLigneOptional.get();
            existingLigne.setCode(newCode);
            existingLigne.setLabel(newLabel);

      
            existingLigne.getDistricts().clear();

       
            List<District> savedDistricts = newDistricts.stream()
                    .map(districtService::saveDistrict)
                    .collect(Collectors.toList());
            existingLigne.getDistricts().addAll(savedDistricts);

            return ligneRepository.save(existingLigne);
        } else {
            throw new IllegalArgumentException("Ligne not found with ID: " + id);
        }
    }


    public List<Ligne> getLignesByLabels(List<String> ligneLabels) {
        return ligneRepository.findAllByLabelIn(ligneLabels);
    }

    public List<Ligne> getLignesByIds(List<Long> ligneIds) {
        return ligneRepository.findAllById(ligneIds);
    }
}
