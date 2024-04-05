package com.pfe.Entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long districtId;
    private String label;
    private String address;


    
    @ManyToMany(mappedBy = "districts")
    @JsonIgnore
    private Set<Role> roles = new HashSet<>();

    
    public District() {
       
    }

    public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	
    public District(Long districtId, String label, String address,  Set<Role> roles) {
		super();
		this.districtId = districtId;
		this.label = label;
		this.address = address;
		this.roles = roles;
	}

	
	

	@Override
	public String toString() {
		return "District [districtId=" + districtId + ", label=" + label + ", address=" + address + ", roles=" + roles
				+ "]";
	}

	public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

 
   
}