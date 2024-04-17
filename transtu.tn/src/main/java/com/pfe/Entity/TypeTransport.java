
package com.pfe.Entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TypeTransport {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String label;
    @OneToMany(mappedBy = "typeTransport", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference 
    private List<MoyenTransport> moyensTransport;
    
    public TypeTransport() {
    }



	public List<MoyenTransport> getMoyensTransport() {
		return moyensTransport;
	}








	public void setMoyensTransport(List<MoyenTransport> moyensTransport) {
		this.moyensTransport = moyensTransport;
	}



	public TypeTransport(Long id, String label, List<MoyenTransport> moyensTransport) {
		super();
		this.id = id;
		this.label = label;
		this.moyensTransport = moyensTransport;
	}




	public TypeTransport(String label) {
	    this.label = label;
	}
	
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









	@Override
	public String toString() {
		return "TypeTransport [id=" + id + ", label=" + label + ", moyensTransport=" + moyensTransport + "]";
	}

   
}