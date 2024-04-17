package com.pfe.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.DTO.TypeTransportDTO;
import com.pfe.Entity.TypeTransport;
import com.pfe.Repository.TypeTransportRepository;

@RestController
@RequestMapping("/api/v1/type")
public class TypeController {

    private final TypeTransportRepository typeTransportRepository;

   
    public TypeController(TypeTransportRepository typeTransportRepository) {
        this.typeTransportRepository = typeTransportRepository;
    }
    @GetMapping(path= "/getAll")
    public ResponseEntity<List<TypeTransportDTO>> listerTypes() {
        List<TypeTransport> typeTransports = typeTransportRepository.findAll();
        List<TypeTransportDTO> typeTransportDTOs = typeTransports.stream()
            .map(typeTransport -> new TypeTransportDTO(typeTransport.getId(), typeTransport.getLabel()))
            .collect(Collectors.toList());
        return ResponseEntity.ok(typeTransportDTOs);
    }
}
