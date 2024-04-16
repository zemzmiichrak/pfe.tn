package com.pfe.Entity;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pfe.DTO.TypeTransportDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity

public class MoyenTransport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_transport_id")
    @JsonManagedReference 
    private TypeTransport typeTransport;
    
    @ManyToMany(cascade = CascadeType.REMOVE) 
    @JoinTable(
            name = "moyen_transport_ligne",
            joinColumns = @JoinColumn(name = "moyen_transport_id"),
            inverseJoinColumns = @JoinColumn(name = "ligne_id")
    )
    private Set<Ligne> lignes = new HashSet<>();


	public Set<Ligne> getLignes() {
		return lignes;
	}

	public void setLignes(Set<Ligne> lignes) {
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

    public TypeTransport getTypeTransport() {
        return typeTransport;
    }

    public void setTypeTransport(TypeTransport typeTransport) {
        this.typeTransport = typeTransport;
    }

	@Override
	public String toString() {
		return "MoyenTransport [id=" + id + ", code=" + code + ", typeTransport=" + typeTransport + ", lignes=" + lignes
				+ "]";
	}

	public MoyenTransport(Long id, String code, TypeTransport typeTransport, Set<Ligne> lignes) {
	
		this.id = id;
		this.code = code;
		this.typeTransport = typeTransport;
		this.lignes = lignes;
	}

	public MoyenTransport() {
		
	}

	public void setTypeTransports(Set<TypeTransport> typeTransports) {
		
		
	}

	public void setTypeTransport(TypeTransportDTO typeTransportDTO) {
	    TypeTransport typeTransport = new TypeTransport();
	    typeTransport.setId(typeTransportDTO.getId());
	    typeTransport.setLabel(typeTransportDTO.getLabel());
	    this.typeTransport = typeTransport;
	}

	

}