package com.pfe.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<TypeTransport> listerTypes() {
        return typeTransportRepository.findAll();
    }
}