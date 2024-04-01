package com.pfe.Request;

import java.util.Set;

import com.pfe.Entity.UserCredentials;

public class UserRegistration {
    private UserSave userSave;
    private UserCredentials credentials;
    private Set<String> roleLabels; 
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

    public Set<String> getRoleLabels() {
        return roleLabels;
    }

    public void setRoleLabels(Set<String> roleLabels) {
        this.roleLabels = roleLabels;
    }
}