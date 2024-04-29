
package com.pfe.Request;

import java.util.List;


import com.pfe.Entity.Role;
import com.pfe.Entity.UserCredentials;



      public class UserUpdating {
	  private UserUpdate userUpdate;
	    private UserCredentials credentials;
	    private List<Role> roles;
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
		public List<Role> getRoles() {
			return roles;
		}
		public void setRoles(List<Role> roles) {
			this.roles = roles;
		}

	
		
}
