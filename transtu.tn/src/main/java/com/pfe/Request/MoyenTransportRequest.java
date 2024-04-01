package com.pfe.Request;

import java.util.Set;



public class MoyenTransportRequest {

    private String code;
    private String typeTransportLabel;
    private Set<String> ligneLabels;

    public MoyenTransportRequest() {
    }

    public MoyenTransportRequest(String code, String typeTransportLabel, Set<String> ligneLabels) {
        this.code = code;
        this.typeTransportLabel = typeTransportLabel;
        this.ligneLabels = ligneLabels;
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

    public Set<String> getLigneLabels() {
        return ligneLabels;
    }

    public void setLigneLabels(Set<String> ligneLabels) {
        this.ligneLabels = ligneLabels;
    }
}