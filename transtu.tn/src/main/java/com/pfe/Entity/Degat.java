package com.pfe.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Degat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private int number;
    @ManyToOne
    @JoinColumn(name = "type_degat_id")
    private TypeDegat typeDegat;
    @ManyToOne 
    private Reclamation reclamation; 
    public Degat() {
        
    }

 


	public Degat(Long id, String description, int number, TypeDegat typeDegat, Reclamation reclamation) {
	
		this.id = id;
		this.description = description;
		this.number = number;
		this.typeDegat = typeDegat;
		this.reclamation = reclamation;
	}




	public TypeDegat getTypeDegat() {
		return typeDegat;
	}



	public void setTypeDegat(TypeDegat typeDegat) {
		this.typeDegat = typeDegat;
	}


	


	public Reclamation getReclamation() {
		return reclamation;
	}




	public void setReclamation(Reclamation reclamation) {
		this.reclamation = reclamation;
	}




	@Override
	public String toString() {
		return "Degat [id=" + id + ", description=" + description + ", number=" + number + ", typeDegat=" + typeDegat
				+ ", reclamation=" + reclamation + "]";
	}




	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}