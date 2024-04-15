package com.pfe.Request;

import java.util.Set;

public class LigneRequest {

	  private String code;

	  private String label;


      private Set<Long> districtIds; 
	  

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}





	public Set<Long> getDistrictIds() {
		return districtIds;
	}

	public void setDistrictIds(Set<Long> districtIds) {
		this.districtIds = districtIds;
	}

	public LigneRequest(String code, String label, Set<Long> districtIds) {
		super();
		this.code = code;
		this.label = label;
		this.districtIds = districtIds;
	}

	public LigneRequest() {
		
	}

	

}