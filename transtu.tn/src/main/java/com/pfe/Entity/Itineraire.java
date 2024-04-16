package com.pfe.Entity;

import java.util.HashSet;
import java.util.Set;
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

    @ManyToMany(mappedBy = "itineraires")
    private Set<Ligne> lignes = new HashSet<>();

    @ManyToMany
    private Set<PointGPS> pointsGPS = new HashSet<>();

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

    public Set<Ligne> getLignes() {
        return lignes;
    }

    public void setLignes(Set<Ligne> lignes) {
        this.lignes = lignes;
    }

    public Set<PointGPS> getPointsGPS() {
        return pointsGPS;
    }

    public void setPointsGPS(Set<PointGPS> pointsGPS) {
        this.pointsGPS = pointsGPS;
    }

	@Override
	public String toString() {
		return "Itineraire [id=" + id + ", code=" + code + ", description=" + description + ", lignes=" + lignes
				+ ", pointsGPS=" + pointsGPS + "]";
	}

	public Itineraire(Long id, String code, String description, Set<Ligne> lignes, Set<PointGPS> pointsGPS) {
	
		this.id = id;
		this.code = code;
		this.description = description;
		this.lignes = lignes;
		this.pointsGPS = pointsGPS;
	}
	
	 public Itineraire() {
	    }

	 public Set<MoyenTransport> getMoyensTransport() {
		    Set<MoyenTransport> moyensTransport = new HashSet<>();
		    for (Ligne ligne : lignes) {
		        moyensTransport.addAll(ligne.getMoyensTransport());
		    }
		    return moyensTransport;
		}

}