package com.pfe.Controller;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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

    @GetMapping(path="/get/{id}")
    public ResponseEntity<Itineraire> getItineraireById(@PathVariable Long id) {
        Optional<Itineraire> itineraire = itineraireService.getItineraireById(id);
        return itineraire.map(ResponseEntity::ok)
                         .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path="/create")
    public ResponseEntity<Itineraire> createItineraire(@RequestBody ItineraireRequest request) {
        Itineraire itineraire = itineraireService.createItineraire(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(itineraire);
    }

    @PutMapping(path="/update/{id}")
    public ResponseEntity<Itineraire> updateItineraire(
            @PathVariable Long id, @RequestBody ItineraireRequest request) {
        Itineraire itineraire = itineraireService.updateItineraire(id, request);
        return ResponseEntity.ok(itineraire);
    }

    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<Void> deleteItineraire(@PathVariable Long id) {
        itineraireService.deleteItineraire(id);
        return ResponseEntity.noContent()
                             .build();
    }

    @GetMapping(path="/getAll")
    public ResponseEntity<List<Itineraire>> getAllItinerairesWithLignes() {
        List<Itineraire> itineraires = itineraireService.getAllItineraires();
        return ResponseEntity.ok(itineraires);
    }
    
    @PutMapping(path="/addPoints/{itineraireId}")
    public ResponseEntity<Itineraire> addPointsToItineraire(
            @PathVariable Long itineraireId, @RequestBody Set<Long> pointsGPSIds) {
        Itineraire updatedItineraire = itineraireService.addPointsToItineraire(itineraireId, pointsGPSIds);
        return ResponseEntity.ok(updatedItineraire);
    }
    @DeleteMapping(path="/deletePoint/{itineraireId}/{pointGPSId}")
    public ResponseEntity<Itineraire> deletePointFromItineraire(
            @PathVariable Long itineraireId, @PathVariable Long pointGPSId) {
        Itineraire updatedItineraire = itineraireService.deletePointFromItineraire(itineraireId, pointGPSId);
        return ResponseEntity.ok(updatedItineraire);
    }
    
    }