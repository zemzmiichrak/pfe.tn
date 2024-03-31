package com.pfe.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.Entity.UserCredentials;
import com.pfe.Request.UserCredentialsLogin;
import com.pfe.Request.UserRegistration;
import com.pfe.Request.UserRequest;
import com.pfe.Request.UserSave;
import com.pfe.Request.UserUpdating;
import com.pfe.Service.UserService;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping(path = "/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistration userRegistration) {
        if (userService.checkIfUserExists(userRegistration.getUserSave().getEmail())) {
            throw new IllegalStateException("User with email " + userRegistration.getUserSave().getEmail() + " already exists");
        }
        String firstName = userService.registerUser(userRegistration.getUserSave(), userRegistration.getCredentials());
        return ResponseEntity.status(HttpStatus.CREATED).body(firstName + " registered successfully");
    }
    
    @PostMapping(path = "/save")
    public ResponseEntity<String> saveUser(@RequestBody UserRegistration userRegistration) {
        try {
            if (userRegistration == null || userRegistration.getUserSave() == null || userRegistration.getCredentials() == null) {
                return ResponseEntity.badRequest().body("User registration data is incomplete");
            }

            UserSave userSave = userRegistration.getUserSave();
            UserCredentials credentials = userRegistration.getCredentials();

            userService.addUser(userSave, credentials);
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register user: " + e.getMessage());
        }
    }

    @PostMapping(path = "/login")
    public ResponseEntity<String> loginUser(@RequestBody UserCredentialsLogin credentialsLogin) {
        String token = userService.login(credentialsLogin);
        if (token != null) {
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @GetMapping(path = "/getAllUser")
    public ResponseEntity<List<UserRequest>> getAllUsers() {
        List<UserRequest> allUsers = userService.getAllUser();
        return ResponseEntity.ok(allUsers);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<String> updateUser(@RequestBody UserUpdating userUpdating) {
        userService.updateUser(userUpdating.getUserUpdate(), userUpdating.getUpdatedCredentials(), userUpdating.getRoleIds());
        return ResponseEntity.ok("User updated successfully");
    }

    @DeleteMapping(path = "/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(value = "id") Long id) {
        if (userService.deleteUser(id)) {
            return ResponseEntity.ok("User deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found or could not be deleted");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logoutUser(@RequestBody Map<String, String> requestData) {
        String email = requestData.get("email");

        if (email == null) {
            return ResponseEntity.badRequest().body("Email is required for logout");
        }

        userService.logout(email);

        return ResponseEntity.ok("User logged out successfully");
    }

    @PutMapping("/updatePassword")
    public ResponseEntity<String> updatePassword(@RequestBody Map<String, String> requestData) {
        String email = requestData.get("email");
        String oldPassword = requestData.get("oldPassword");
        String newPassword = requestData.get("newPassword");

        if (email == null || oldPassword == null || newPassword == null) {
            return ResponseEntity.badRequest().body("Email, old password, and new password are required");
        }

        userService.updatePassword(email, oldPassword, newPassword);

        return ResponseEntity.ok("Password updated successfully");
    }
}