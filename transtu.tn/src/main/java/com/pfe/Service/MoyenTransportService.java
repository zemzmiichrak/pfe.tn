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
    private TypeService typeService;

    @Autowired
    private LigneService ligneService;


    @Transactional
    public MoyenTransport addMoyenTransport(String code, Long typeTransportId, List<Long> ligneIds) {
        TypeTransport typeTransport = typeService.getTypeTransportById(typeTransportId);
        List<Ligne> lignes = ligneService.getLignesByIds(ligneIds);

        MoyenTransport moyenTransport = new MoyenTransport();
        moyenTransport.setCode(code);
        moyenTransport.setTypeTransport(typeTransport);
        moyenTransport.setLignes(new HashSet<>(lignes));

        return moyenTransportRepository.save(moyenTransport);
    }

    @Transactional
    public void deleteMoyenTransport(Long id) {
        Optional<MoyenTransport> moyenTransportOptional = moyenTransportRepository.findById(id);
        moyenTransportOptional.ifPresent(moyenTransport -> {
            moyenTransport.getLignes().clear();
            moyenTransportRepository.deleteById(id);
        });
    }

    @Transactional
    public MoyenTransport updateMoyenTransport(Long id, String newCode, Long newTypeTransportId, List<Long> newLigneIds) {
        TypeTransport newTypeTransport = typeService.getTypeTransportById(newTypeTransportId);
        List<Ligne> newLignes = ligneService.getLignesByIds(newLigneIds);

        MoyenTransport existingMoyenTransport = moyenTransportRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Moyen de transport non trouvé avec l'ID: " + id));

        existingMoyenTransport.setCode(newCode);
        existingMoyenTransport.setTypeTransport(newTypeTransport);
        existingMoyenTransport.setLignes(new HashSet<>(newLignes));

        return moyenTransportRepository.save(existingMoyenTransport);
    }

    @Transactional
    public MoyenTransport createMoyenTransport(String code, Long typeTransportId, List<Long> ligneIds) {
        TypeTransport typeTransport = typeService.getTypeTransportById(typeTransportId);
        List<Ligne> lignes = ligneService.getLignesByIds(ligneIds);

        MoyenTransport moyenTransport = new MoyenTransport();
        moyenTransport.setCode(code);
        moyenTransport.setTypeTransport(typeTransport);
        moyenTransport.setLignes(new HashSet<>(lignes));

        return moyenTransportRepository.save(moyenTransport);
    }
    @Transactional
    public List<MoyenTransport> getAllMoyensTransportWithDetails() {
        List<MoyenTransport> moyensTransport = moyenTransportRepository.findAll();
        for (MoyenTransport moyenTransport : moyensTransport) {
            moyenTransport.getTypeTransport().getLabel(); 
            moyenTransport.getLignes().forEach(ligne -> ligne.getLabel()); 
        }
        return moyensTransport;
    }
}
