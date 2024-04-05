package com.pfe.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PointGPS {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double latitude;
    private double longitude;

  
    public PointGPS(Long id, double latitude, double longitude) {
		
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public PointGPS() {
		
	}

	@Override
	public String toString() {
		return "PointGPS [id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}