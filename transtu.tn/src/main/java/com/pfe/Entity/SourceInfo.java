package com.pfe.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class SourceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String phoneNumber;
    
    @ManyToOne
    private SourceInfoType type;
    
    @OneToOne 
    @JoinColumn(name = "reclamation_id") 
    private Reclamation reclamation;
    @Override
	public String toString() {
		return "SourceInfo [id=" + id + ", firstName=" + firstName + ", phoneNumber=" + phoneNumber + ", type=" + type
				+ "]";
	}

	public SourceInfoType getType() {
		return type;
	}

	public void setType(SourceInfoType type) {
		this.type = type;
	}

	public SourceInfo(Long id, String firstName, String phoneNumber, SourceInfoType type) {
	
		this.id = id;
		this.firstName = firstName;
		this.phoneNumber = phoneNumber;
		this.type = type;
	}

	public SourceInfo() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

  
}