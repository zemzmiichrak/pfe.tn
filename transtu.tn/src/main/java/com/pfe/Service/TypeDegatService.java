package com.pfe.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.Entity.TypeDegat;
import com.pfe.Repository.TypeDegatRepository;

import jakarta.annotation.PostConstruct;

@Service
public class TypeDegatService {

    private final TypeDegatRepository typeDegatRepository;

    @Autowired
    public TypeDegatService(TypeDegatRepository typeDegatRepository) {
        this.typeDegatRepository = typeDegatRepository;
    }

    @PostConstruct
    public void createInitialTypes() {
        if (typeDegatRepository.findByLabel("Humaine") == null) {
            TypeDegat humaine = new TypeDegat("Humaine");
            typeDegatRepository.save(humaine);
        }

        if (typeDegatRepository.findByLabel("Materiel") == null) {
            TypeDegat materiel = new TypeDegat("Materiel");
            typeDegatRepository.save(materiel);
        }
    }
}
