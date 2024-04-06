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

        Optional<Itineraire> existingItineraire = itineraireRepository.findByCode(request.getCode());
        if (existingItineraire.isPresent()) {
            throw new RuntimeException("Un itinéraire avec le même code existe déjà");
        }

        Itineraire itineraire = convertRequestToItineraire(request);
        return itineraireRepository.save(itineraire);
    }
    public Itineraire updateItineraire(Long id, ItineraireRequest request) {
        Optional<Itineraire> existingItineraire = itineraireRepository.findById(id);
        if (existingItineraire.isPresent()) {
            Itineraire itineraire = existingItineraire.get();

            boolean isUpdated = false;
            if (!itineraire.getCode().equals(request.getCode())) {
                itineraire.setCode(request.getCode());
                isUpdated = true;
            }
            if (!itineraire.getDescription().equals(request.getDescription())) {
                itineraire.setDescription(request.getDescription());
                isUpdated = true;
            }

            if (isUpdated) {
                return itineraireRepository.save(itineraire);
            } else {
                return itineraire;
            }
        } else {
            throw new IllegalArgumentException("Itinéraire non trouvé avec l'ID : " + id);
        }
    }
    public void deleteItineraire(Long id) {
   
        Optional<Itineraire> existingItineraire = itineraireRepository.findById(id);
        if (existingItineraire.isPresent()) {
            itineraireRepository.deleteById(id);
        } else {
            throw new RuntimeException("Itinéraire non trouvé avec l'ID : " + id);
        }
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
    
    public Itineraire addPointsToItineraire(Long itineraireId, Set<Long> pointsGPSIds) {
        Optional<Itineraire> existingItineraire = itineraireRepository.findById(itineraireId);
        if (existingItineraire.isPresent()) {
            Itineraire itineraire = existingItineraire.get();

            Set<PointGPS> pointsGPS = pointGPSRepository.findAllByIdIn(pointsGPSIds);
            itineraire.getPointsGPS().addAll(pointsGPS);

            return itineraireRepository.save(itineraire);
        } else {
            throw new IllegalArgumentException("Itinéraire non trouvé avec l'ID : " + itineraireId);
        }
    }
    public Itineraire deletePointFromItineraire(Long itineraireId, Long pointGPSId) {
        Optional<Itineraire> existingItineraire = itineraireRepository.findById(itineraireId);
        if (existingItineraire.isPresent()) {
            Itineraire itineraire = existingItineraire.get();

            Set<PointGPS> pointsGPS = itineraire.getPointsGPS();
            pointsGPS.removeIf(pointGPS -> pointGPS.getId().equals(pointGPSId));

            itineraire.setPointsGPS(pointsGPS);

            return itineraireRepository.save(itineraire);
        } else {
            throw new IllegalArgumentException("Itinéraire non trouvé avec l'ID : " + itineraireId);
        }
    }
    
    }