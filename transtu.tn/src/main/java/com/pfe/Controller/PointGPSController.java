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

import com.pfe.Entity.PointGPS;
import com.pfe.Request.PointGPSRequest;
import com.pfe.Service.PointGPSService;

@RestController
@RequestMapping("/api/v1/pointgps")
public class PointGPSController {

    @Autowired
    private PointGPSService pointGPSService;

    @PostMapping(path="/addPoint")
    public ResponseEntity<PointGPS> createPointGPS(@RequestBody PointGPSRequest request) {
        PointGPS pointGPS = pointGPSService.createPointGPS(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(pointGPS);
    }

    @GetMapping(path="/get/{id}")
    public ResponseEntity<PointGPS> getPointGPSById(@PathVariable Long id) {
        return pointGPSService.getPointGPSById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(path="/updatePoint/{id}")
    public ResponseEntity<PointGPS> updatePointGPS(
            @PathVariable Long id, @RequestBody PointGPSRequest request) {
        PointGPS updatedPointGPS = pointGPSService.updatePointGPS(id, request);
        return ResponseEntity.ok(updatedPointGPS);
    }

    @DeleteMapping(path="/deletePoint/{id}")
    public ResponseEntity<Void> deletePointGPS(@PathVariable Long id) {
        pointGPSService.deletePointGPS(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping(path="/getAll")
    public ResponseEntity<List<PointGPS>> getAllPointsGPS() {
        List<PointGPS> pointsGPS = pointGPSService.getAllPointsGPS();
        return ResponseEntity.ok(pointsGPS);
    }
}