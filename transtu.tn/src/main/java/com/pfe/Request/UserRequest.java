package com.pfe.Request;

import java.util.Set;

public class UserRequest {
	private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;
    private String username;
    private Set<Long> roleIds;

    public UserRequest() {
        
    }

  
	







	public UserRequest(String firstName, String lastName, String address, String phoneNumber, String email,
			String username, Set<Long> roleIds) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.username = username;
		this.roleIds = roleIds;
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

  

	

	public Set<Long> getRoleIds() {
		return roleIds;
	}


	public void setRoleIds(Set<Long> roleIds) {
		this.roleIds = roleIds;
	}










	@Override
	public String toString() {
		return "UserRequest [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", username=" + username + ", roleIds="
				+ roleIds + "]";
	}










	public String getUsername() {
		return username;
	}










	public void setUsername(String username) {
		this.username = username;
	}





	





   
}