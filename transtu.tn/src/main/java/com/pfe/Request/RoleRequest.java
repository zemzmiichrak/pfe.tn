package com.pfe.Request;

import java.util.Set;

public class RoleRequest {
    private String label;
    private String description;
    private Set<Long> districtIds; 
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
	
	

	
	public Set<Long> getDistrictIds() {
		return districtIds;
	}
	public void setDistrictIds(Set<Long> districtIds) {
		this.districtIds = districtIds;
	}

	@Override
	public String toString() {
		return "RoleRequest [label=" + label + ", description=" + description + ", districtIds=" + districtIds + "]";
	}
	public RoleRequest(String label, String description, Set<Long> districtIds) {
		super();
		this.label = label;
		this.description = description;
		this.districtIds = districtIds;
	}

	
	
}