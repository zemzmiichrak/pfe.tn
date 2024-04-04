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

		private double longitude;
	    private double latitude;
	    

	    @ManyToMany(mappedBy = "itineraires")
	    private Set<Ligne> lignes = new HashSet<>();

	    
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


		public Set<Ligne> getLignes() {
			return lignes;
		}


		public void setLignes(Set<Ligne> lignes) {
			this.lignes = lignes;
		}




	    public Itineraire(Long id, String code, String description, double longitude, double latitude,
				Set<Ligne> lignes) {
			super();
			this.id = id;
			this.code = code;
			this.description = description;
			this.longitude = longitude;
			this.latitude = latitude;
			this.lignes = lignes;
		}


		@Override
		public String toString() {
			return "Itineraire [id=" + id + ", code=" + code + ", description=" + description + ", longitude="
					+ longitude + ", latitude=" + latitude + ", lignes=" + lignes + "]";
		}


		public Itineraire() {
	        
	    }

}
