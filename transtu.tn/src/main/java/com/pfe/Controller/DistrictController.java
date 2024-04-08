package com.pfe.Controller;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.pfe.Entity.District;
import com.pfe.Service.DistrictService;
@RestController
@RequestMapping("/api/v1/districts")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @GetMapping(path="/getAll")
    public ResponseEntity<List<District>> getAllDistricts() {
        List<District> districts = districtService.getAllDistricts();
        return ResponseEntity.ok(districts);
    }
    @GetMapping("/getByIds")
    public ResponseEntity<Set<District>> getDistrictsByIds(@RequestParam Set<Long> districtIds) {
        Set<District> districts = districtService.getDistrictsByIds(districtIds);
        return ResponseEntity.ok(districts);
    }

}