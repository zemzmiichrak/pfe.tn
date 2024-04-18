
package com.pfe.Request;

import java.util.List;

import com.pfe.Entity.District;

public class RoleRequest {
    private String label;
    private String description;
    private List<District> districts;
    
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	  public RoleRequest() {
		
	}
	public List<District> getDistricts() {
		return districts;
	}
	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}


}