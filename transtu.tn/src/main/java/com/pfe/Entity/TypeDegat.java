package com.pfe.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TypeDegat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;
   
    public TypeDegat() {
     
    }
   
	@Override
	public String toString() {
		return "TypeDegat [id=" + id + ", label=" + label + "]";
	}

	public TypeDegat( String label) {
	
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

   
}