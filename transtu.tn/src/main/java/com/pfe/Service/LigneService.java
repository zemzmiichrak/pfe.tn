package com.pfe.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.Entity.District;
import com.pfe.Entity.Ligne;
import com.pfe.Entity.MoyenTransport;
import com.pfe.Repository.LigneRepository;
import com.pfe.Repository.MoyenTransportRepository;

import jakarta.transaction.Transactional;

@Service
public class LigneService {

    @Autowired
    private LigneRepository ligneRepository;
    @Autowired
    MoyenTransportRepository  moyenTransportRepository;
    @Autowired
    private DistrictService districtService;

    public List<Ligne> getAllLignes() {
        return ligneRepository.findAll();
    }

    public Ligne addLigne(String code, String label, Set<Long> districtIds) {
        if (ligneRepository.existsByCodeOrLabel(code, label)) {
            throw new IllegalArgumentException("Ligne with the same code or label already exists.");
        }

        Ligne ligne = new Ligne();
        ligne.setCode(code);
        ligne.setLabel(label);

        Set<District> districts = districtService.getDistrictsByIds(districtIds); 
        ligne.setDistricts(districts);

        return ligneRepository.save(ligne);
    }
    @Transactional
    public void deleteLigne(Long id) {
        Optional<Ligne> ligneOptional = ligneRepository.findById(id);
        if (ligneOptional.isPresent()) {
            Ligne ligne = ligneOptional.get();

      
            Set<MoyenTransport> moyensTransport = ligne.getMoyensTransport();
            for (MoyenTransport moyenTransport : moyensTransport) {
                moyenTransport.getLignes().remove(ligne);
            }

          
            moyenTransportRepository.deleteAllByLignesContains(ligne);

            ligneRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Ligne not found with ID: " + id);
        }
    }
    public Ligne updateLigne(Long id, String newCode, String newLabel, Set<Long> newDistrictIds) {
        Optional<Ligne> existingLigneOptional = ligneRepository.findById(id);
        if (existingLigneOptional.isPresent()) {
            Ligne existingLigne = existingLigneOptional.get();

            existingLigne.setCode(newCode);
            existingLigne.setLabel(newLabel);

            Set<District> newDistricts = districtService.getDistrictsByIds(newDistrictIds); 
            existingLigne.setDistricts(newDistricts);

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