package com.pfe.Service;

import java.util.HashSet;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.Entity.Itineraire;
import com.pfe.Entity.Ligne;
import com.pfe.Repository.ItineraireRepository;
import com.pfe.Repository.LigneRepository;
import com.pfe.Request.ItineraireRequest;

@Service
public class ItineraireService {

    @Autowired
    private ItineraireRepository itineraireRepository;

    @Autowired
    private LigneRepository ligneRepository;


    public Itineraire createItineraire(ItineraireRequest request) {
        Optional<Itineraire> optionalItineraire = itineraireRepository.findByCode(request.getCode());
        if (optionalItineraire.isPresent()) {
            return optionalItineraire.get();
        }

        Itineraire itineraire = new Itineraire();
        itineraire.setCode(request.getCode());
        itineraire.setDescription(request.getDescription());
        itineraire.setLongitude(request.getLongitude());
        itineraire.setLatitude(request.getLatitude());
        
        Set<Ligne> lignes = new HashSet<>();
        for (String label : request.getLigneLabels()) {
            Optional<Ligne> optionalLigne = ligneRepository.findByLabel(label);
            optionalLigne.ifPresent(lignes::add);
        }
        itineraire.setLignes(lignes);

        return itineraireRepository.save(itineraire);
    }

    public Itineraire updateItineraire(Long id, ItineraireRequest request) {
        Optional<Itineraire> optionalItineraire = itineraireRepository.findById(id);
        if (optionalItineraire.isPresent()) {
            Itineraire itineraire = optionalItineraire.get();
            itineraire.setCode(request.getCode());
            itineraire.setDescription(request.getDescription());
            itineraire.setLongitude(request.getLongitude());
            itineraire.setLatitude(request.getLatitude());

            Set<Ligne> lignes = new HashSet<>();
            for (String label : request.getLigneLabels()) {
                Optional<Ligne> optionalLigne = ligneRepository.findByLabel(label);
                optionalLigne.ifPresent(lignes::add);
            }
            itineraire.setLignes(lignes);

            return itineraireRepository.save(itineraire);
        } else {

            return null;
        }
    }

    public void deleteItineraire(Long id) {
        Optional<Itineraire> optionalItineraire = itineraireRepository.findById(id);
        optionalItineraire.ifPresent(itineraireRepository::delete);
    }

    public Itineraire getItineraireById(Long id) {
        return itineraireRepository.findById(id).orElse(null);
    }
}