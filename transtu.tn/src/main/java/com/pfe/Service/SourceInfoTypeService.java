package com.pfe.Service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pfe.Entity.SourceInfoType;
import com.pfe.Repository.SourceInfoTypeRepository;

import jakarta.annotation.PostConstruct;

@Service
public class SourceInfoTypeService {

    private final SourceInfoTypeRepository sourceInfoTypeRepository;

    
    public SourceInfoTypeService(SourceInfoTypeRepository sourceInfoTypeRepository) {
        this.sourceInfoTypeRepository = sourceInfoTypeRepository;
    }

    @PostConstruct
    public void createInitialTypes() {
        if (sourceInfoTypeRepository.findByLabel("Citoyen") == null) {
            SourceInfoType citoyen = new SourceInfoType("Citoyen");
            sourceInfoTypeRepository.save(citoyen);
        }

        if (sourceInfoTypeRepository.findByLabel("Police") == null) {
            SourceInfoType police = new SourceInfoType("Police");
            sourceInfoTypeRepository.save(police);
        }

        if (sourceInfoTypeRepository.findByLabel("Chauffeur/receveur") == null) {
            SourceInfoType chauffeurReceveur = new SourceInfoType("Chauffeur/receveur");
            sourceInfoTypeRepository.save(chauffeurReceveur);
        }
    }


    public List<SourceInfoType> getAllSourceInfoTypes() {
        return sourceInfoTypeRepository.findAll();
    }
}