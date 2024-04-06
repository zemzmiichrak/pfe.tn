package com.pfe.Request;

import java.util.Set;

public class UserUpdate {
	  private Long id;
	    private String firstName;
	    private String lastName;
	    private String phoneNumber;
	    private String address;
	    private String email;
	    private String password;
	    private Set<Long> roleIds; 
		
	
		@Override
		public String toString() {
			return "UserUpdate [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber="
					+ phoneNumber + ", address=" + address + ", email=" + email + ", password=" + password
					+ ", roleIds=" + roleIds + "]";
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
		public Set<Long> getRoleIds() {
			return roleIds;
		}
		public void setRoleIds(Set<Long> roleIds) {
			this.roleIds = roleIds;
		}
		public UserUpdate(Long id, String firstName, String lastName, String phoneNumber, String address, String email,
				String password, Set<Long> roleIds) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.phoneNumber = phoneNumber;
			this.address = address;
			this.email = email;
			this.password = password;
			this.roleIds = roleIds;
		}
		
	
		
	}