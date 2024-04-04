package com.pfe.Request;

import java.util.Set;



public class MoyenTransportRequest {
	   private String code;
	    private Long typeTransportId; 
	    private Set<Long> ligneIds; 
    public MoyenTransportRequest() {
    }

    
    public MoyenTransportRequest(String code, Long typeTransportId, Set<Long> ligneIds) {
		super();
		this.code = code;
		this.typeTransportId = typeTransportId;
		this.ligneIds = ligneIds;
	}


	@Override
	public String toString() {
		return "MoyenTransportRequest [code=" + code + ", typeTransportId=" + typeTransportId + ", ligneIds=" + ligneIds
				+ "]";
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


	public Set<Long> getLigneIds() {
		return ligneIds;
	}


	public void setLigneIds(Set<Long> ligneIds) {
		this.ligneIds = ligneIds;
	}



}