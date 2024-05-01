package com.pfe.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.Entity.TypeDegat;
import com.pfe.Repository.TypeDegatRepository;

@RestController
@RequestMapping("/api/v1/typesdegat")
public class TypeDegatController {

    private final TypeDegatRepository typeDegatRepository;

    public TypeDegatController(TypeDegatRepository typeDegatRepository) {
        this.typeDegatRepository = typeDegatRepository;
    }

    @GetMapping(path="/getAll")
    public List<TypeDegat> getAllTypesDegat() {
        return typeDegatRepository.findAll();
    }
}