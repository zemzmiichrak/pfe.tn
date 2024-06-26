package com.pfe.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pfe.Entity.District;
import com.pfe.Entity.Role;
import com.pfe.Repository.RoleRepository;
import com.pfe.Request.RoleRequest;
@Service
public class RoleService {

    private final RoleRepository roleRepository;

    private final DistrictService districtService;

    public RoleService(RoleRepository roleRepository, DistrictService districtService) {
        this.roleRepository = roleRepository;
        this.districtService = districtService;
    }
    public void createRole(RoleRequest roleRequest) {
        if (roleRequest.getDistricts() == null) {
            throw new IllegalArgumentException("Districts list cannot be null");
        }

        Optional<Role> existingRole = roleRepository.findByLabel(roleRequest.getLabel());
        if (existingRole.isPresent()) {
            throw new IllegalArgumentException("Role with the same label already exists");
        }

        Role role = new Role();
        role.setLabel(roleRequest.getLabel());
        role.setDescription(roleRequest.getDescription());

        Set<District> existingDistricts = new HashSet<>();
        for (District district : roleRequest.getDistricts()) {
            District existingDistrict = districtService.getDistrictById(district.getId());
            existingDistricts.add(existingDistrict);
        }
        role.setDistrictsSet(existingDistricts);

        roleRepository.save(role);
    }

    public ResponseEntity<String> updateRole(Long id, RoleRequest roleRequest) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        if (optionalRole.isPresent()) {
            Role role = optionalRole.get();
            role.setLabel(roleRequest.getLabel());
            role.setDescription(roleRequest.getDescription());

            Set<District> existingDistricts = new HashSet<>();
            for (District district : roleRequest.getDistricts()) {
       
                District existingDistrict = districtService.getDistrictById(district.getId());
                existingDistricts.add(existingDistrict);
            }
            role.setDistrictsSet(existingDistricts);

            roleRepository.save(role);
            return ResponseEntity.ok("Role updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Role not found");
        }
    }



    public List<Role> getAllRolesWithDistricts() {
        List<Role> roles = roleRepository.findAll();
        for (Role role : roles) {
            List<District> districtsList = districtService.getDistrictsByRole(role.getId());
            Set<District> districtsSet = new HashSet<>(districtsList);
            role.setDistrictsSet(districtsSet);
        }
        return roles;
    }
    public boolean deleteRoleById(Long id) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        if (optionalRole.isPresent()) {
            roleRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public List<Role> getRolesByIds(List<Long> roleIds) {
        return roleRepository.findAllById(roleIds);
    }

	
}