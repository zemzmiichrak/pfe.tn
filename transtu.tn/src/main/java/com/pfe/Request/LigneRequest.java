package com.pfe.Request;

import java.util.Set;

public class LigneRequest {

	  private String code;

	  private String label;


	private Set<String> districtLabels;
	  

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


	public void setDistrictLabels(Set<String> districtLabels) {
		this.districtLabels = districtLabels;
	}


	public LigneRequest(String code, String label, Set<String> districtLabels) {
		super();
		this.code = code;
		this.label = label;
		this.districtLabels = districtLabels;
	}

	public LigneRequest() {
		
	}

	public Set<String> getDistrictLabels() {
	    return districtLabels;
	}
	

}