package com.pfe.Entity;

import java.util.HashSet;
import java.util.Set;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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

    @OneToMany(mappedBy = "typeTransport", cascade = CascadeType.ALL)

    private Set<MoyenTransport> moyensTransport = new HashSet<>();
    
    public TypeTransport() {
    }

 

    public Set<MoyenTransport> getMoyensTransport() {
		return moyensTransport;
	}



	public void setMoyensTransport(Set<MoyenTransport> moyensTransport) {
		this.moyensTransport = moyensTransport;
	}



	public TypeTransport(Long id, String label, Set<MoyenTransport> moyensTransport) {
		this.id = id;
		this.label = label;
		this.moyensTransport = moyensTransport;
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
        return "TypeTransport{" +
                "id=" + id +
                ", label='" + label + '\'' +
                '}';
    }
}