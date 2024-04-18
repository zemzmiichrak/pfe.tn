package com.pfe.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pfe.DTO.MoyenTransportDTO;
import com.pfe.DTO.TypeTransportDTO;
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
        if (moyenTransportRepository.existsByCodeAndTypeTransportId(code, typeTransportId)) {
            throw new IllegalArgumentException("Moyen de transport avec le même code et type existe déjà");
        }

        TypeTransport typeTransport = typeService.getTypeTransportById(typeTransportId); 

        if (typeTransport == null || typeTransport.getLabel() == null) {
            throw new IllegalArgumentException("Le type de transport spécifié est invalide ou n'a pas de label défini.");
        }

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

    if (moyenTransportRepository.existsByCodeAndTypeTransportId(code, typeTransportId)) {
        throw new IllegalArgumentException("Moyen de transport avec le même code et type existe déjà");
    }

    TypeTransport typeTransport = typeService.getTypeTransportById(typeTransportId);
    List<Ligne> lignes = ligneService.getLignesByIds(ligneIds);

    MoyenTransport moyenTransport = new MoyenTransport();
    moyenTransport.setCode(code);

    TypeTransportDTO typeTransportDTO = new TypeTransportDTO();
    typeTransportDTO.setId(typeTransport.getId());
    typeTransportDTO.setLabel(typeTransport.getLabel());

    moyenTransport.setTypeTransport(typeTransportDTO);
    moyenTransport.setLignes(new HashSet<>(lignes));

    return moyenTransportRepository.save(moyenTransport);
}@Transactional
public List<MoyenTransportDTO> getAllMoyensTransportWithDetails() {
    List<MoyenTransport> moyensTransport = moyenTransportRepository.findAll();
    List<MoyenTransportDTO> transportDTOs = new ArrayList<>();

    for (MoyenTransport moyenTransport : moyensTransport) {
        MoyenTransportDTO transportDTO = new MoyenTransportDTO();
        transportDTO.setId(moyenTransport.getId());
        transportDTO.setCode(moyenTransport.getCode());

        TypeTransportDTO typeTransportDTO = new TypeTransportDTO();
        typeTransportDTO.setId(moyenTransport.getTypeTransport().getId());
        typeTransportDTO.setLabel(moyenTransport.getTypeTransport().getLabel());
        transportDTO.setTypeTransport(typeTransportDTO);

        List<Long> ligneIds = moyenTransport.getLignes().stream()
            .map(Ligne::getId)
            .collect(Collectors.toList());
        transportDTO.setLigneIds(ligneIds);

        transportDTOs.add(transportDTO);
    }

    return transportDTOs;
}
}
