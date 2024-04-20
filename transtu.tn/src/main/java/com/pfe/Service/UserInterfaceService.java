package com.pfe.Service;

import java.util.List;


import com.pfe.Entity.Role;
import com.pfe.Entity.UserCredentials;
import com.pfe.Request.UserCredentialsLogin;
import com.pfe.Request.UserRequest;
import com.pfe.Request.UserSave;
import com.pfe.Request.UserUpdate;

public interface UserInterfaceService {

	 public void logout(String email);

	 public void updatePassword(String email, String oldPassword, String newPassword);

	 public boolean deleteUser(Long id);

	 public String addUser(UserSave userSave, UserCredentials credentials, List<Role> roles);

	 public List<UserRequest> getAllUser();

	 public String login(UserCredentialsLogin credentialsLogin);

	 public String updateUser(UserUpdate userUpdate, UserCredentials updatedCredentials, List<Role> roles);

	 public  void registerUser(UserSave userSave, UserCredentials credentials, List<Role> roles);

	 public UserRequest showUser(Long id);

}
