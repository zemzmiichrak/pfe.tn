package com.pfe.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.Entity.TypeReclamation;
import com.pfe.Service.TypeReclamationService;

@RestController
@RequestMapping("/typereclamation")
public class TypeReclamationController {

    private final TypeReclamationService typeReclamationService;

    @Autowired
    public TypeReclamationController(TypeReclamationService typeReclamationService) {
        this.typeReclamationService = typeReclamationService;
    }

    @GetMapping("/all")
    public List<TypeReclamation> getAllTypesReclamation() {
        return typeReclamationService.getAllTypesReclamation();
    }
}