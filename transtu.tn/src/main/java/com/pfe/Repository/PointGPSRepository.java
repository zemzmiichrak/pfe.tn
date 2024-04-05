package com.pfe.Repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.Entity.PointGPS;

@Repository
public interface PointGPSRepository extends JpaRepository<PointGPS, Long> {
    List<PointGPS> findByLatitudeAndLongitude(double latitude, double longitude);

	Set<PointGPS> findAllByIdIn(Set<Long> pointsGPSIds);
}