
package com.pfe.Entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class TypeTransport {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String label;

    
    public TypeTransport() {
    }


	public TypeTransport(Long id, String label) {
		super();
		this.id = id;
		this.label = label;
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
		return "TypeTransport [id=" + id + ", label=" + label + "]";
	}


   
}