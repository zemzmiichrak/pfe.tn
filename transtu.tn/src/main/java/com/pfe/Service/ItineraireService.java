package com.pfe.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pfe.Entity.Itineraire;
import com.pfe.Entity.Ligne;
import com.pfe.Entity.PointGPS;
import com.pfe.Repository.ItineraireRepository;
import com.pfe.Repository.LigneRepository;
import com.pfe.Repository.PointGPSRepository;
import com.pfe.Request.ItineraireRequest;

@Service
public class ItineraireService {

    @Autowired
    private ItineraireRepository itineraireRepository;

    @Autowired
    private LigneRepository ligneRepository;

    @Autowired
    private PointGPSRepository pointGPSRepository;

    public Itineraire createItineraire(ItineraireRequest request) {
        Itineraire itineraire = convertRequestToItineraire(request);
        return itineraireRepository.save(itineraire);
    }

    public Itineraire updateItineraire(Long id, ItineraireRequest request) {
        Optional<Itineraire> existingItineraire = itineraireRepository.findById(id);
        if (existingItineraire.isPresent()) {
            Itineraire itineraire = convertRequestToItineraire(request);
            itineraire.setId(id);
            return itineraireRepository.save(itineraire);
        } else {
            throw new RuntimeException("Itinéraire non trouvé avec l'ID : " + id);
        }
    }

    public void deleteItineraire(Long id) {
        itineraireRepository.deleteById(id);
    }

    private Itineraire convertRequestToItineraire(ItineraireRequest request) {
        Itineraire itineraire = new Itineraire();
        itineraire.setCode(request.getCode());
        itineraire.setDescription(request.getDescription());

    
        Set<Ligne> lignes = ligneRepository.findAllByIdIn(request.getLignesIds());
        itineraire.setLignes(lignes);

     
        Set<PointGPS> pointsGPS = pointGPSRepository.findAllByIdIn(request.getPointsGPSIds());
        itineraire.setPointsGPS(pointsGPS);

        return itineraire;
    }

    public Optional<Itineraire> getItineraireById(Long id) {
        return itineraireRepository.findById(id);
    }
    
    public List<Itineraire> getAllItineraires() {
        return itineraireRepository.findAll();
    }
    }