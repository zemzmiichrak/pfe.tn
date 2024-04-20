package com.pfe.Entity;

import java.util.List;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String email;
    private String password;
    private String username;

    
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private UserCredentials credentials;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )

    private List<Role> roles;




	public User(Long id, String firstName, String lastName, String phoneNumber, String address, String email,
			String password, String username, UserCredentials credentials, List<Role> roles) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
		this.password = password;
		this.username = username;
		this.credentials = credentials;
		this.roles = roles;
	}




	public User() {
       
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




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getPhoneNumber() {
		return phoneNumber;
	}




	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public UserCredentials getCredentials() {
		return credentials;
	}




	public void setCredentials(UserCredentials credentials) {
		this.credentials = credentials;
	}




    public List<Role> getRoles() {
		return roles;
	}




	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}



	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + ", email=" + email + ", password=" + password + ", username=" + username
				+ ", credentials=" + credentials + ", roles=" + roles + "]";
	}




	public void setDistricts(Set<District> districts) {
		
		
	}






	
}