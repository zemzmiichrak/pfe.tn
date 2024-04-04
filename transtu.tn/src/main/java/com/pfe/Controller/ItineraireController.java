package com.pfe.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pfe.Entity.Itineraire;
import com.pfe.Request.ItineraireRequest;
import com.pfe.Service.ItineraireService;

@RestController
@RequestMapping("/api/v1/itineraire")
public class ItineraireController {

    @Autowired
    private ItineraireService itineraireService;

    @PostMapping("/create")
    public ResponseEntity<Itineraire> createItineraire(@RequestBody ItineraireRequest request) {
        Itineraire itineraire = itineraireService.createItineraire(request);
        return new ResponseEntity<>(itineraire, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Itineraire> updateItineraire(@PathVariable Long id, @RequestBody ItineraireRequest request) {
        Itineraire itineraire = itineraireService.updateItineraire(id, request);
        if (itineraire != null) {
            return new ResponseEntity<>(itineraire, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteItineraire(@PathVariable Long id) {
        itineraireService.deleteItineraire(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Itineraire> getItineraireById(@PathVariable Long id) {
        Itineraire itineraire = itineraireService.getItineraireById(id);
        if (itineraire != null) {
            return new ResponseEntity<>(itineraire, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}