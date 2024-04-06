package com.pfe.Request;

import java.util.Set;

import com.pfe.Entity.UserCredentials;

public class UserRegistration {
    private UserSave userSave;
    private UserCredentials credentials;
    private Set<Long> roleIds; 
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

	public Set<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Set<Long> roleIds) {
		this.roleIds = roleIds;
	}

  
	
}