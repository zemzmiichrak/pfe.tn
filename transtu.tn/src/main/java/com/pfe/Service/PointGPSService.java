package com.pfe.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.Entity.PointGPS;
import com.pfe.Repository.PointGPSRepository;
import com.pfe.Request.PointGPSRequest;

@Service
public class PointGPSService {

    @Autowired
    private PointGPSRepository pointGPSRepository;

    public PointGPS createPointGPS(PointGPSRequest request) {
        PointGPS pointGPS = new PointGPS();
        pointGPS.setLatitude(request.getLatitude());
        pointGPS.setLongitude(request.getLongitude());
        return pointGPSRepository.save(pointGPS);
    }

    public Optional<PointGPS> getPointGPSById(Long id) {
        return pointGPSRepository.findById(id);
    }

    public PointGPS updatePointGPS(Long id, PointGPSRequest request) {
        Optional<PointGPS> existingPointGPS = pointGPSRepository.findById(id);
        if (existingPointGPS.isPresent()) {
            PointGPS pointGPS = existingPointGPS.get();
            pointGPS.setLatitude(request.getLatitude());
            pointGPS.setLongitude(request.getLongitude());
            return pointGPSRepository.save(pointGPS);
        } else {
            throw new RuntimeException("Point GPS not found with ID: " + id);
        }
    }

    public void deletePointGPS(Long id) {
        pointGPSRepository.deleteById(id);
    }
}