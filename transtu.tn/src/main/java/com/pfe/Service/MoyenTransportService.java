package com.pfe.Service;

import java.util.List;

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
    
    public MoyenTransport addMoyenTransport(String code, Long typeTransportId, Long ligneId) {
        TypeTransport typeTransport = typeService.getTypeTransportById(typeTransportId);
        Ligne ligne = ligneService.getLigneById(ligneId);

        MoyenTransport moyenTransport = new MoyenTransport();
        moyenTransport.setCode(code);
        moyenTransport.setTypeTransport(typeTransport);
        moyenTransport.getLignes().add(ligne);

        return moyenTransportRepository.save(moyenTransport);
    }

    @Transactional
    public void deleteMoyenTransport(Long id) {
        moyenTransportRepository.deleteById(id);
    }
    @Transactional
    public MoyenTransport updateMoyenTransport(Long id, String newCode, Long newTypeTransportId, Long newLigneId) {
        TypeTransport newTypeTransport = typeService.getTypeTransportById(newTypeTransportId);
        Ligne newLigne = ligneService.getLigneById(newLigneId);

        MoyenTransport existingMoyenTransport = moyenTransportRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Moyen de transport non trouvé avec l'ID: " + id));

        existingMoyenTransport.setCode(newCode);
        existingMoyenTransport.setTypeTransport(newTypeTransport);
        existingMoyenTransport.getLignes().clear();
        existingMoyenTransport.getLignes().add(newLigne);

        return moyenTransportRepository.save(existingMoyenTransport);
    }

    @Transactional
    public MoyenTransport createMoyenTransport(String code, Long typeTransportId, Long ligneId) {
        TypeTransport typeTransport = typeService.getTypeTransportById(typeTransportId);
        Ligne ligne = ligneService.getLigneById(ligneId);

        MoyenTransport moyenTransport = new MoyenTransport();
        moyenTransport.setCode(code);
        moyenTransport.setTypeTransport(typeTransport);
        moyenTransport.getLignes().add(ligne);

        return moyenTransportRepository.save(moyenTransport);
    }

    public List<MoyenTransport> getAllMoyensTransport() {
        return moyenTransportRepository.findAll();
    }
}