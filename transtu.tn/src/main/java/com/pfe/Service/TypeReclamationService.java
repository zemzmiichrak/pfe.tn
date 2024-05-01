package com.pfe.Service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pfe.Entity.TypeReclamation;
import com.pfe.Repository.TypeReclamationRepository;

import jakarta.annotation.PostConstruct;

@Service
public class TypeReclamationService {

    private final TypeReclamationRepository typeReclamationRepository;


    public TypeReclamationService(TypeReclamationRepository typeReclamationRepository) {
        this.typeReclamationRepository = typeReclamationRepository;
    }

    @PostConstruct
    public void createInitialTypes() {
        if (typeReclamationRepository.findByLabel("Accident") == null) {
            TypeReclamation accident = new TypeReclamation("Accident");
            typeReclamationRepository.save(accident);
        }

        if (typeReclamationRepository.findByLabel("Incident") == null) {
            TypeReclamation incident = new TypeReclamation("Incident");
            typeReclamationRepository.save(incident);
        }
    }

    public List<TypeReclamation> getAllTypesReclamation() {
        return typeReclamationRepository.findAll();
    }
}