package com.pfe.Request;

import java.util.Set;

import com.pfe.Entity.UserCredentials;



      public class UserUpdating {
	  private UserUpdate userUpdate;
	    private UserCredentials credentials;
	    private Set<Long> roleIds; 
		public UserUpdate getUserUpdate() {
			return userUpdate;
		}
		public void setUserUpdate(UserUpdate userUpdate) {
			this.userUpdate = userUpdate;
		}
		public UserCredentials getCredentials() {
			return credentials;
		}
		public void setCredentials(UserCredentials credentials) {
			this.credentials = credentials;
		}
		public UserCredentials getUpdatedCredentials() {
			// TODO Auto-generated method stub
			return null;
		}
		public Set<Long> getRoleIds() {
			return roleIds;
		}
		public void setRoleIds(Set<Long> roleIds) {
			this.roleIds = roleIds;
		}
	
	
		
}