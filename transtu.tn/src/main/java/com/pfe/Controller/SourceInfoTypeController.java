package com.pfe.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.Entity.SourceInfoType;
import com.pfe.Service.SourceInfoTypeService;

@RestController
@RequestMapping("/sourceinfotype")
public class SourceInfoTypeController {

    private final SourceInfoTypeService sourceInfoTypeService;

  
    public SourceInfoTypeController(SourceInfoTypeService sourceInfoTypeService) {
        this.sourceInfoTypeService = sourceInfoTypeService;
    }

    @GetMapping("/all")
    public List<SourceInfoType> getAllSourceInfoTypes() {
        return sourceInfoTypeService.getAllSourceInfoTypes();
    }
}