package com.pfe.Request;

import java.util.List;

import com.pfe.Entity.Role;
import com.pfe.Entity.UserCredentials;

public class UserRegistration {
    private UserSave userSave;
    private UserCredentials credentials;
    private List<Role> roles;
    public UserSave getUserSave() {
        return userSave;
    }

    public void setUserSave(UserSave userSave) {
        this.userSave = userSave;
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


	

  
	
}