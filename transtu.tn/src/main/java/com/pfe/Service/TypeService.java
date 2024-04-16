package com.pfe.Service;
import org.springframework.stereotype.Service;
import com.pfe.Entity.TypeTransport;
import com.pfe.Repository.TypeTransportRepository;
import jakarta.transaction.Transactional;

@Service
public class TypeService {
    
    private final TypeTransportRepository typeTransportRepository;
    
    public TypeService(TypeTransportRepository typeTransportRepository) {
        this.typeTransportRepository = typeTransportRepository;
    }

    @Transactional
    public void createTypeTransports() {
        TypeTransport tgm = new TypeTransport("TGM");
        TypeTransport metro = new TypeTransport("Metro");
        TypeTransport bus = new TypeTransport("Bus");

        typeTransportRepository.save(tgm);
        typeTransportRepository.save(metro);
        typeTransportRepository.save(bus);
    }
    @Transactional
    public TypeTransport getTypeTransportById(Long typeTransportId) {
        return typeTransportRepository.findById(typeTransportId)
                .orElseThrow(() -> new IllegalArgumentException("Type de transport non trouvé avec l'ID: " + typeTransportId));
    }
    @Transactional
    public TypeTransport getTypeTransportByLabel(String newTypeTransportLabel) {
        return typeTransportRepository.findByLabel(newTypeTransportLabel)
                .orElseThrow(() -> new IllegalArgumentException("Type de transport non trouvé avec le label: " + newTypeTransportLabel));
    }
  
}