package com.pfe.Service;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Optional;


import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pfe.Entity.Role;
import com.pfe.Entity.User;
import com.pfe.Entity.UserCredentials;
import com.pfe.Repository.DistrictRepository;
import com.pfe.Repository.RoleRepository;
import com.pfe.Repository.UserCredentialsRepository;
import com.pfe.Repository.UserRepository;
import com.pfe.Request.UserCredentialsLogin;
import com.pfe.Request.UserRequest;
import com.pfe.Request.UserSave;
import com.pfe.Request.UserUpdate;

import io.jsonwebtoken.Jwts;

import jakarta.persistence.EntityNotFoundException;

@Service
public  class UserService implements UserInterfaceService {
	

    @Autowired
    DistrictRepository    districtRepository;


    private SecretKey secretKey; 
    private final UserRepository userRepository;
    private final UserCredentialsRepository credentialsRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserCredentialsRepository credentialsRepository,
                       RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.credentialsRepository = credentialsRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }
 


    @Override
    public void registerUser(UserSave userSave, UserCredentials credentials, List<Role> roles) {
        List<Role> managedRoles = new ArrayList<>();

        for (Role role : roles) {
            if (role.getId() != null) {
                Role existingRole = roleRepository.findById(role.getId())
                        .orElseThrow(() -> new EntityNotFoundException("Role with id " + role.getId() + " not found"));

                managedRoles.add(existingRole);
            }
        }

        User user = new User(
            null,
            userSave.getFirstName(),
            userSave.getLastName(),
            userSave.getPhoneNumber(),
            userSave.getAddress(),
            userSave.getEmail(),
            null,
            null,
            null,
            managedRoles
        );

        String hashedPassword = passwordEncoder.encode(credentials.getPassword());
        credentials.setPassword(hashedPassword);
        credentials.setUser(user);

        userRepository.save(user);
        credentialsRepository.save(credentials);
    }

    @Override
    public String login(UserCredentialsLogin credentialsLogin) {
        UserCredentials credentials = credentialsRepository.findByUsername(credentialsLogin.getUsername());
        if (credentials != null && verifyPassword(credentialsLogin.getPassword(), credentials.getPassword())) {
            String token = generateToken(credentials.getUser().getEmail());
            return token;
        } else {
            throw new IllegalArgumentException("Invalid username or password");
        }
    }

    public String generateToken(String email) {
        long expirationTime = 864_000_000;

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(secretKey)
                .compact();
    }

    @Override
    public List<UserRequest> getAllUser() {
        List<User> getUsers = userRepository.findAll();
        List<UserRequest> userReqList = new ArrayList<>();
        for (User user : getUsers) {
            List<Role> roles = new ArrayList<>(user.getRoles());

            UserRequest userReq = new UserRequest(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                null,
                null, 
                null, 
                roles 
            );
            userReqList.add(userReq);
        }
        return userReqList;
    }

    @Override
    public String updateUser(UserUpdate userUpdate, UserCredentials updatedCredentials, List<Role> roles) {
        if (userUpdate == null) {
            throw new IllegalArgumentException("userUpdate cannot be null");
        }

        if (userRepository.existsById(userUpdate.getId())) {
            User user = userRepository.findById(userUpdate.getId())
                    .orElseThrow(() -> new EntityNotFoundException("User with id " + userUpdate.getId() + " not found"));

            if (roles != null && !roles.isEmpty()) {
                user.setRoles(new ArrayList<>(roles));
            }

            credentialsRepository.save(updatedCredentials);
            userRepository.save(user);
            return "User updated successfully";
        } else {
            throw new EntityNotFoundException("User with id " + userUpdate.getId() + " not found");
        }
    }


    public boolean checkIfUserExists(String email) {
        return userRepository.findByEmail(email) != null;
    }

    private boolean verifyPassword(String plainPassword, String hashedPassword) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(plainPassword, hashedPassword);
    }
    @Override
    public String addUser(UserSave userSave, UserCredentials credentials, List<Role> roles) {
        if (userSave == null || userSave.getFirstName() == null || userSave.getLastName() == null ||
            userSave.getPhoneNumber() == null || userSave.getAddress() == null || userSave.getEmail() == null ||
            credentials == null || credentials.getUsername() == null || credentials.getPassword() == null) {
            throw new IllegalArgumentException("UserSave object or its fields cannot be null");
        }

        if (checkIfUserExists(userSave.getEmail())) {
            throw new IllegalStateException("User with email " + userSave.getEmail() + " already exists");
        }

        if (credentialsRepository.findByUsername(credentials.getUsername()) != null) {
            throw new IllegalStateException("Username " + credentials.getUsername() + " already exists");
        }

        registerUser(userSave, credentials, roles); 

        return userSave.getFirstName() + " registered successfully";
    }

    @Override
    public boolean deleteUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            userRepository.delete(user);
            return true;
        } else {
            System.out.println("User not found");
            return false;
        }
    }

    @Override
    public void logout(String email) {
        System.out.println("User logged out: " + email);
    }

    @Override
    public void updatePassword(String email, String oldPassword, String newPassword) {
        UserCredentials credentials = credentialsRepository.findByUsername(email);

        if (credentials == null) {
            throw new IllegalArgumentException("User not found");
        }

        if (!passwordEncoder.matches(oldPassword, credentials.getPassword())) {
            throw new IllegalArgumentException("Incorrect old password");
        }
        String hashedPassword = passwordEncoder.encode(newPassword);
        credentials.setPassword(hashedPassword);
        credentialsRepository.save(credentials);
    }


    @Override
    public UserRequest showUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            UserCredentials credentials = user.getCredentials();
            List<Role> roles = new ArrayList<>(user.getRoles()); 

            return new UserRequest(
                user.getFirstName(),
                user.getLastName(),
                user.getAddress(),
                user.getPhoneNumber(),
                user.getEmail(),
                credentials.getUsername(),
                roles
            );
        } else {
            throw new EntityNotFoundException("User with id " + id + " not found");
        }
    }
}
