package com.pfe.Service;

import java.util.List;
import java.util.Set;

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
        Role role = new Role();
        role.setLabel(roleRequest.getLabel());
        role.setDescription(roleRequest.getDescription());
        Set<District> districts = districtService.getDistrictsByIds(roleRequest.getDistrictIds());
        role.setDistricts(districts);

        roleRepository.save(role);
    }


    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
    
    public boolean deleteRoleById(Long id) {
        if (roleRepository.existsById(id)) {
            roleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}