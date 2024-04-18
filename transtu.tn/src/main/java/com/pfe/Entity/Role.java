package com.pfe.Entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;
    private String description;

    @ManyToMany
    @JoinTable(
        name = "role_district", 
        joinColumns = @JoinColumn(name = "role_id"), 
        inverseJoinColumns = @JoinColumn(name = "district_id") 
    )
    private List<District> districts;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private Set<User> users = new HashSet<>();

    @ManyToMany(mappedBy = "roles")
    private Set<UserCredentials> userCredentials = new HashSet<>();


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<UserCredentials> getUserCredentials() {
        return userCredentials;
    }

    public void setUserCredentials(Set<UserCredentials> userCredentials) {
        this.userCredentials = userCredentials;
    }

    // Constructors, toString, and other methods
    public Role() {
    }

    public Role(Long id, String label, String description, List<District> districts, Set<User> users,
            Set<UserCredentials> userCredentials) {
        this.id = id;
        this.label = label;
        this.description = description;
        this.districts = districts;
        this.users = users;
        this.userCredentials = userCredentials;
    }

    @Override
    public String toString() {
        return "Role [id=" + id + ", label=" + label + ", description=" + description + ", districts=" + districts
                + ", users=" + users + ", userCredentials=" + userCredentials + "]";
    }

    public void setDistricts(Set<District> districtsSet) {
        this.districts = new ArrayList<>(districtsSet);
    }
    
    

}
