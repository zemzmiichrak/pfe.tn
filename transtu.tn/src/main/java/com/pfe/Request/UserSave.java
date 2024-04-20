package com.pfe.Request;

import java.util.List;
import java.util.Set;

import com.pfe.Entity.Role;

public class UserSave {
	    private Long id;
	    private String firstName;
	    private String lastName;
	    private String phoneNumber;
	    private String address;
	    private String email;
	    private String password;
	    private String username;
	    private List<Role> roles;

	public UserSave() {
		
	}


	@Override
	public String toString() {
		return "UserSave [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + ", address=" + address + ", email=" + email + ", password=" + password + ", username="
				+ username + ", roles=" + roles + "]";
	}


	public UserSave(Long id, String firstName, String lastName, String phoneNumber, String address, String email,
			String password, String username, List<Role> roles) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
		this.password = password;
		this.username = username;
		this.roles = roles;
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


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


	public Set<Long> getDistrictIds() {
		// TODO Auto-generated method stub
		return null;
	}

}

	

	

	