package com.pfe.DTO;

import java.util.List;

import com.pfe.Entity.District;

public class RoleWithDistrictsDTO {
    private String label;
    private String description;
    private List<District> districts;

    public RoleWithDistrictsDTO(String label, String description, List<District> districts) {
        this.label = label;
        this.description = description;
        this.districts = districts;
    }

    public RoleWithDistrictsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	

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

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }
}