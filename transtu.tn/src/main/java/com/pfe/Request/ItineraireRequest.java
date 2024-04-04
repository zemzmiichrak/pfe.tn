package com.pfe.Request;

import java.util.Set;

public class ItineraireRequest {
	
	private Long id;
    private String code;
    private String description;
    private double longitude;
    private double latitude;
    private Set<String> ligneLabels;
	

	
	    public ItineraireRequest() {
	
	}
		public ItineraireRequest(Long id, String code, String description, double longitude, double latitude,
			Set<String> ligneLabels) {
	
		this.id = id;
		this.code = code;
		this.description = description;
		this.longitude = longitude;
		this.latitude = latitude;
		this.ligneLabels = ligneLabels;
	}
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
		public double getLongitude() {
			return longitude;
		}
		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}
		public double getLatitude() {
			return latitude;
		}
		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}
		public Set<String> getLigneLabels() {
			return ligneLabels;
		}
		public void setLigneLabels(Set<String> ligneLabels) {
			this.ligneLabels = ligneLabels;
		}
		@Override
	public String toString() {
		return "ItineraireRequest [id=" + id + ", code=" + code + ", description=" + description + ", longitude="
				+ longitude + ", latitude=" + latitude + ", ligneLabels=" + ligneLabels + "]";
	}
	
}
