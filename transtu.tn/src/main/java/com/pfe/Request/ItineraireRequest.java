package com.pfe.Request;

import java.util.Set;

public class ItineraireRequest {

    private String code;
    private String description;
    private Set<Long> lignesIds; 
    private Set<Long> pointsGPSIds; 

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

    public Set<Long> getLignesIds() {
        return lignesIds;
    }

    public void setLignesIds(Set<Long> lignesIds) {
        this.lignesIds = lignesIds;
    }

    public Set<Long> getPointsGPSIds() {
        return pointsGPSIds;
    }

    public void setPointsGPSIds(Set<Long> pointsGPSIds) {
        this.pointsGPSIds = pointsGPSIds;
    }

	public ItineraireRequest(String code, String description, Set<Long> lignesIds, Set<Long> pointsGPSIds) {
		
		this.code = code;
		this.description = description;
		this.lignesIds = lignesIds;
		this.pointsGPSIds = pointsGPSIds;
	}
}