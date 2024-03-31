package com.pfe.Request;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.pfe.Entity.TypeTransport;
import com.pfe.Service.LigneService;
import com.pfe.Service.TypeService;

public class MoyenTransportRequest {

	 private String code;
	    private Long typeTransportId;
	    private Set<Long> ligneIds;

    
    @Autowired
    private  TypeService typeTransportService;
    @Autowired
    private  LigneService   ligneService ;
    
    public MoyenTransportRequest() {
    }

    public MoyenTransportRequest(String code, Long typeTransportId, Set<Long> ligneIds,
			TypeService typeTransportService, LigneService ligneService) {
	
		this.code = code;
		this.typeTransportId = typeTransportId;
		this.ligneIds = ligneIds;
		this.typeTransportService = typeTransportService;
		this.ligneService = ligneService;
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

   

	@Override
	public String toString() {
		return "MoyenTransportRequest [code=" + code + ", typeTransportId=" + typeTransportId + ", ligneIds=" + ligneIds
				+ ", typeTransportService=" + typeTransportService + ", ligneService=" + ligneService + "]";
	}

	public TypeTransport getTypeTransport() {
		
		return   typeTransportService.getTypeTransportById(typeTransportId);
	}

	

	public Set<Long> getLigneIds() {
		return ligneIds;
	}

	public void setLigneIds(Set<Long> ligneIds) {
		this.ligneIds = ligneIds;
	}





}