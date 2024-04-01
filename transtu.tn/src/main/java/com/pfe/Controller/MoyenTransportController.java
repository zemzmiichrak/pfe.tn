package com.pfe.Controller;
import java.util.ArrayList;
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
import com.pfe.Entity.MoyenTransport;
import com.pfe.Request.MoyenTransportRequest;
import com.pfe.Service.MoyenTransportService;
@RestController
@RequestMapping("/api/v1/moyensTransport")
public class MoyenTransportController {

    @Autowired
    private MoyenTransportService moyenTransportService;
    @PostMapping(path="/addMoyenTransport")
    public ResponseEntity<MoyenTransport> addMoyenTransport(@RequestBody MoyenTransportRequest moyenTransportRequest) {
        String code = moyenTransportRequest.getCode();
        String typeTransportLabel = moyenTransportRequest.getTypeTransportLabel();
        List<String> ligneLabels = new ArrayList<>(moyenTransportRequest.getLigneLabels());  

        MoyenTransport newMoyenTransport = moyenTransportService.addMoyenTransport(code, typeTransportLabel, ligneLabels);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMoyenTransport);
    }

    @PutMapping(path="/updateMoyenTransport/{id}")
    public ResponseEntity<MoyenTransport> updateMoyenTransport(
            @PathVariable Long id,
            @RequestBody MoyenTransportRequest updateMoyenTransportRequest
    ) {
        String newCode = updateMoyenTransportRequest.getCode();
        String newTypeTransportLabel = updateMoyenTransportRequest.getTypeTransportLabel();
        List<String> newLigneLabels = new ArrayList<>(updateMoyenTransportRequest.getLigneLabels());  

        MoyenTransport updatedMoyenTransport = moyenTransportService.updateMoyenTransport(id, newCode, newTypeTransportLabel, newLigneLabels);
        return ResponseEntity.ok(updatedMoyenTransport);
    }

    @GetMapping(path="/getAllMoyensTransport")
    public ResponseEntity<List<MoyenTransport>> getAllMoyensTransport() {
        List<MoyenTransport> moyensTransport = moyenTransportService.getAllMoyensTransport();
        return ResponseEntity.ok(moyensTransport);
    }

    @DeleteMapping(path="/deleteMoyenTransport/{id}")
    public ResponseEntity<String> deleteMoyenTransport(@PathVariable Long id) {
        moyenTransportService.deleteMoyenTransport(id);
        return ResponseEntity.ok("Moyen de transport supprimé avec succès");
    }

    @PostMapping(path="/createMoyenTransport")
    public ResponseEntity<MoyenTransport> createMoyenTransport(
            @RequestBody MoyenTransportRequest moyenTransportRequest
    ) {
        String code = moyenTransportRequest.getCode();
        String typeTransportLabel = moyenTransportRequest.getTypeTransportLabel();
        List<String> ligneLabels = new ArrayList<>(moyenTransportRequest.getLigneLabels());  

        MoyenTransport newMoyenTransport = moyenTransportService.createMoyenTransport(code, typeTransportLabel, ligneLabels);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMoyenTransport);
    }
}