package com.pfe.DTO;

import java.util.List;

public class LigneResponseDTO {
    private Long id;
    private String code;
    private String label;
    private List<DistrictDTO> districts;
	public LigneResponseDTO(Long id, String code, String label, List<DistrictDTO> districts) {
		super();
		this.id = id;
		this.code = code;
		this.label = label;
		this.districts = districts;
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
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public List<DistrictDTO> getDistricts() {
		return districts;
	}
	public void setDistricts(List<DistrictDTO> districts) {
		this.districts = districts;
	}
	public LigneResponseDTO() {
		
	}
    
}
