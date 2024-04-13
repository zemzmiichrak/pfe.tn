package com.pfe.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.persistence.EntityNotFoundException;

@Service
public  class UserService implements UserInterfaceService {
	
   
   @Autowired
	private UserRepository userRepository;
   @Autowired
    private RoleRepository  roleRepo;

   @Autowired
   private UserCredentialsRepository credentialsRepository;
   @Autowired
   DistrictRepository    districtRepository;

   private SecretKey secretKey; 

   
   private final PasswordEncoder passwordEncoder;
   

  
   public UserService() {
	this.passwordEncoder = new BCryptPasswordEncoder();
	this.secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
   }
   @Override
   public String registerUser(UserSave userSave, UserCredentials credentials) {
       if (checkIfUserExists(userSave.getEmail())) {
           throw new IllegalStateException("User with email " + userSave.getEmail() + " already exists");
       }

       if (credentialsRepository.findByUsername(credentials.getUsername()) != null) {
           throw new IllegalStateException("Username " + credentials.getUsername() + " already exists");
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
           null
       );
       Set<Long> roleIds = userSave.getRoleIds(); 
       if (roleIds != null && !roleIds.isEmpty()) {
           Set<Role> roles = new HashSet<>();
           for (Long roleId : roleIds) {
               Role role = roleRepo.findById(roleId)
                       .orElseThrow(() -> new EntityNotFoundException("Role with id " + roleId + " not found"));
               roles.add(role);
           }
           user.setRoles(roles);
       }

       PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
       String hashedPassword = passwordEncoder.encode(credentials.getPassword());
       credentials.setPassword(hashedPassword);
       credentials.setUser(user);

       userRepository.save(user);
       credentialsRepository.save(credentials);

       return user.getFirstName();
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
           Set<Role> roles = user.getRoles(); 
           Set<Long> roleIds = roles.stream().map(Role::getId).collect(Collectors.toSet()); 

           UserRequest userReq = new UserRequest(
               user.getFirstName(),
               user.getLastName(),
               user.getEmail(),
               null,
               null, 
               null, 
               roleIds 
           );
           userReqList.add(userReq);
       }
       return userReqList;
   }



   @Override
   public String updateUser(UserUpdate userUpdate, UserCredentials updatedCredentials, Set<Long> roleIds) {
       if (userUpdate == null) {
           throw new IllegalArgumentException("userUpdate cannot be null");
       }

       if (userRepository.existsById(userUpdate.getId())) {
           User user = userRepository.findById(userUpdate.getId())
                   .orElseThrow(() -> new EntityNotFoundException("User with id " + userUpdate.getId() + " not found"));

           Set<Role> roles = new HashSet<>();
           if (roleIds != null && !roleIds.isEmpty()) {
               for (Long roleId : roleIds) {
                   Role role = roleRepo.findById(roleId)
                           .orElseThrow(() -> new EntityNotFoundException("Role with id " + roleId + " not found"));
                   roles.add(role);
               }
           }
           user.setRoles(roles);

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
   public String addUser(UserSave userSave, UserCredentials credentials, Set<Long> roleIds) {
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

       User user = new User(
           null,
           userSave.getFirstName(),
           userSave.getLastName(),
           userSave.getPhoneNumber(),
           userSave.getAddress(),
           userSave.getEmail(),
           null,
           null,
           null
       );

       Set<Role> roles = new HashSet<>();
       if (roleIds != null && !roleIds.isEmpty()) {
           for (Long roleId : roleIds) {
               Role role = roleRepo.findById(roleId)
                       .orElseThrow(() -> new EntityNotFoundException("Role with id " + roleId + " not found"));
               roles.add(role);
           }
       }
       user.setRoles(roles);

       String hashedPassword = passwordEncoder.encode(credentials.getPassword());
       credentials.setPassword(hashedPassword);
       credentials.setUser(user);

       userRepository.save(user);
       credentialsRepository.save(credentials);

       return user.getFirstName();
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
           Set<Role> roles = user.getRoles(); 

         
           Set<Long> roleIds = roles.stream().map(Role::getId).collect(Collectors.toSet());

           return new UserRequest(
               user.getFirstName(),
               user.getLastName(),
               user.getAddress(),
               user.getPhoneNumber(),
               user.getEmail(),
               credentials.getUsername(),
               roleIds
           );
       } else {
           throw new EntityNotFoundException("User with id " + id + " not found");
       }
   }

}