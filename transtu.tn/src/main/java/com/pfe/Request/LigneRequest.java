package com.pfe.Request;

import java.util.List;
import com.pfe.Entity.District;

public class LigneRequest {
	 private Long districtId;
    private String code;
    private String label;
    private List<District> districts;

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

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

  
    public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	public LigneRequest(Long districtId, String code, String label, List<District> districts) {
	
		this.districtId = districtId;
		this.code = code;
		this.label = label;
		this.districts = districts;
	}

	public LigneRequest() {
        
    }
}
