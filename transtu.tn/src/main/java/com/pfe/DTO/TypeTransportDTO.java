package com.pfe.DTO;

public class TypeTransportDTO {
	  private Long id;
	  private String label;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public TypeTransportDTO(Long id, String label) {
		
		this.id = id;
		this.label = label;
	}
	public TypeTransportDTO() {
	
	}
	  
}
