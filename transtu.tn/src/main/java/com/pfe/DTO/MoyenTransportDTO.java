package com.pfe.DTO;

import java.util.List;

public class MoyenTransportDTO {
    private Long id;
    private String code;
    private String typeTransportLabel; 
    private List<LigneDTO> lignes;

	
	public MoyenTransportDTO(Long id, String code, String typeTransportLabel, List<LigneDTO> lignes
			) {
		this.id = id;
		this.code = code;
		this.typeTransportLabel = typeTransportLabel;
		this.lignes = lignes;

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
	public String getTypeTransportLabel() {
		return typeTransportLabel;
	}
	public void setTypeTransportLabel(String typeTransportLabel) {
		this.typeTransportLabel = typeTransportLabel;
	}
	public List<LigneDTO> getLignes() {
		return lignes;
	}
	public void setLignes(List<LigneDTO> lignes) {
		this.lignes = lignes;
	}

	
	public MoyenTransportDTO() {
	    }
	 
	 public void setTypeTransport(TypeTransportDTO typeTransportDTO) {
		    this.typeTransportLabel = typeTransportDTO.getLabel();
		}

    
}
