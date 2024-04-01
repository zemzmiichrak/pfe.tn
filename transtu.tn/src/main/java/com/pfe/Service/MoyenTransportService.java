package com.pfe.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pfe.Entity.Ligne;
import com.pfe.Entity.MoyenTransport;
import com.pfe.Entity.TypeTransport;
import com.pfe.Repository.MoyenTransportRepository;
import jakarta.transaction.Transactional;

@Service
public class MoyenTransportService {

    @Autowired
    private MoyenTransportRepository moyenTransportRepository;
 
    @Autowired
    private TypeService  typeService; 
    @Autowired
    private LigneService ligneService; 

    @Transactional
    public MoyenTransport addMoyenTransport(String code, String typeTransportLabel, List<String> ligneLabels) {
        TypeTransport typeTransport = typeService.getTypeTransportByLabel(typeTransportLabel);
        List<Ligne> lignes = ligneService.getLignesByLabels(ligneLabels);

        MoyenTransport moyenTransport = new MoyenTransport();
        moyenTransport.setCode(code);
        moyenTransport.setTypeTransport(typeTransport);
        moyenTransport.setLignes(new HashSet<>(lignes));

        return moyenTransportRepository.save(moyenTransport);
    }

    @Transactional
    public void deleteMoyenTransport(Long id) {
        Optional<MoyenTransport> moyenTransportOptional = moyenTransportRepository.findById(id);
        if (moyenTransportOptional.isPresent()) {
            MoyenTransport moyenTransport = moyenTransportOptional.get();
            
           
            moyenTransport.getLignes().clear();

          
            moyenTransportRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Moyen de transport non trouvé avec l'ID: " + id);
        }
    }
    @Transactional
    public MoyenTransport updateMoyenTransport(Long id, String newCode, String newTypeTransportLabel, List<String> newLigneLabels) {
        TypeTransport newTypeTransport = typeService.getTypeTransportByLabel(newTypeTransportLabel);
        List<Ligne> newLignes = ligneService.getLignesByLabels(newLigneLabels);

        MoyenTransport existingMoyenTransport = moyenTransportRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Moyen de transport non trouvé avec l'ID: " + id));

        existingMoyenTransport.setCode(newCode);
        existingMoyenTransport.setTypeTransport(newTypeTransport);
        existingMoyenTransport.setLignes(new HashSet<>(newLignes));

        return moyenTransportRepository.save(existingMoyenTransport);
    }

    @Transactional
    public MoyenTransport createMoyenTransport(String code, String typeTransportLabel, List<String> ligneLabels) {
        TypeTransport typeTransport = typeService.getTypeTransportByLabel(typeTransportLabel);
        List<Ligne> lignes = ligneService.getLignesByLabels(ligneLabels);

        MoyenTransport moyenTransport = new MoyenTransport();
        moyenTransport.setCode(code);
        moyenTransport.setTypeTransport(typeTransport);
        moyenTransport.setLignes(new HashSet<>(lignes));

        return moyenTransportRepository.save(moyenTransport);
    }

    public List<MoyenTransport> getAllMoyensTransport() {
        return moyenTransportRepository.findAll();
    }
}