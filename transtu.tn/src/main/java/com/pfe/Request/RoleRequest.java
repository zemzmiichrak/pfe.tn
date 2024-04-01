package com.pfe.Request;

import java.util.Set;

public class RoleRequest {
    private String label;
    private String description;
    private Set<String> districtLabels;
	
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
	
	
	@Override
	public String toString() {
		return "RoleRequest [label=" + label + ", description=" + description + ", districtLabels=" + districtLabels
				+ "]";
	}
	public RoleRequest(String label, String description, Set<String> districtLabels) {
		super();
		this.label = label;
		this.description = description;
		this.districtLabels = districtLabels;
	}
	public void setDistrictLabels(Set<String> districtLabels) {
		this.districtLabels = districtLabels;
	}
	public RoleRequest() {
	}
	public Set<String> getDistrictLabels() {
	    return districtLabels;
	}
	
	
}