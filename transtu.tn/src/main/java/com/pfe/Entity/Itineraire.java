package com.pfe.Entity;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToMany;

@Entity
public class Itineraire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String description;
    @ManyToMany
    private List<Ligne> lignes; 

    @ManyToMany
    private List<PointGPS> pointsGPS; 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	
	 public List<Ligne> getLignes() {
		return lignes;
	}

	public void setLignes(List<Ligne> lignes) {
		this.lignes = lignes;
	}

	public List<PointGPS> getPointsGPS() {
		return pointsGPS;
	}

	public void setPointsGPS(List<PointGPS> pointsGPS) {
		this.pointsGPS = pointsGPS;
	}

	public Itineraire() {
	    }

	@Override
	public String toString() {
		return "Itineraire [id=" + id + ", code=" + code + ", description=" + description + ", lignes=" + lignes
				+ ", pointsGPS=" + pointsGPS + "]";
	}

	public Itineraire(Long id, String code, String description, List<Ligne> lignes, List<PointGPS> pointsGPS) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
		this.lignes = lignes;
		this.pointsGPS = pointsGPS;
	}


}