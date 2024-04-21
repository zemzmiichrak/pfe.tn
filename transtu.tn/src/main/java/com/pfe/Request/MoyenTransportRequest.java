package com.pfe.Request;

import java.util.List;


import com.pfe.Entity.Ligne;



public class MoyenTransportRequest {
	   private String code;
	    private Long typeTransportId; 
	    private List<Ligne> lignes; 
    public MoyenTransportRequest() {
    }

  


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public Long getTypeTransportId() {
		return typeTransportId;
	}


	public void setTypeTransportId(Long typeTransportId) {
		this.typeTransportId = typeTransportId;
	}





	public List<Ligne> getLignes() {
		return lignes;
	}




	public void setLignes(List<Ligne> lignes) {
		this.lignes = lignes;
	}




	@Override
	public String toString() {
		return "MoyenTransportRequest [code=" + code + ", typeTransportId=" + typeTransportId + ", lignes=" + lignes
				+ "]";
	}




	public MoyenTransportRequest(String code, Long typeTransportId, List<Ligne> lignes) {
		super();
		this.code = code;
		this.typeTransportId = typeTransportId;
		this.lignes = lignes;
	}




	





}