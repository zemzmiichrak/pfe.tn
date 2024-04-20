package com.pfe.Controller;

import java.util.List;
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
import com.pfe.Entity.Ligne;
import com.pfe.Entity.District;
import com.pfe.Request.LigneRequest;
import com.pfe.Service.LigneService;

@RestController
@RequestMapping("/api/v1/lignes")
public class LigneController {

    @Autowired
    private LigneService ligneService;

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Ligne>> getAllLignes() {
        List<Ligne> lignes = ligneService.getAllLignes();
        return ResponseEntity.ok(lignes);
    }
    @PostMapping(path = "/addLigne")
    public ResponseEntity<Ligne> addLigne(@RequestBody LigneRequest addLigneRequest) {
        String code = addLigneRequest.getCode();
        String label = addLigneRequest.getLabel();
        List<District> districts = addLigneRequest.getDistricts();

        Ligne newLigne = ligneService.addLigne(code, label, districts);
        return ResponseEntity.status(HttpStatus.CREATED).body(newLigne);
    }

    @PutMapping("/updateLigne/{id}")
    public ResponseEntity<Ligne> updateLigne(
            @PathVariable Long id,
            @RequestBody LigneRequest updateLigneRequest
    ) {
        String newCode = updateLigneRequest.getCode();
        String newLabel = updateLigneRequest.getLabel();
        List<District> newDistricts = updateLigneRequest.getDistricts();

        Ligne updatedLigne = ligneService.updateLigne(id, newCode, newLabel, newDistricts);
        return ResponseEntity.ok(updatedLigne);
    }

    @DeleteMapping(path="/deleteLigne/{id}")
    public ResponseEntity<String> deleteLigne(@PathVariable Long id) {
        ligneService.deleteLigne(id);
        return ResponseEntity.ok("Ligne deleted successfully");
    }
}
