package com.pfe.Request;
import java.util.List;
import com.pfe.Entity.Ligne;
import com.pfe.Entity.PointGPS;

public class ItineraireRequest {

    private String code;
    private String description;
    private List<Ligne> lignes; 
    private List<PointGPS> pointsGPS; 


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

	public ItineraireRequest(String code, String description, List<Ligne> lignes, List<PointGPS> pointsGPS) {
		super();
		this.code = code;
		this.description = description;
		this.lignes = lignes;
		this.pointsGPS = pointsGPS;
	}

   
}