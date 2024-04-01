package com.pfe.Controller;

import java.util.List;

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

import com.pfe.Entity.Role;
import com.pfe.Request.RoleRequest;
import com.pfe.Service.RoleService;

@RestController
@RequestMapping("api/v1/role")
public class RoleController {

    private final RoleService roleService;


    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    @PostMapping(path="/create")
    public ResponseEntity<String> createRole(@RequestBody RoleRequest roleRequest) {
        roleService.createRole(roleRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Role created successfully");
    }


    @GetMapping(path="/getAll")
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        return ResponseEntity.ok(roles);
    }
    
    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable("id") Long id) {
        boolean deleted = roleService.deleteRoleById(id);
        if (deleted) {
            return ResponseEntity.ok("Role deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Role not found or could not be deleted");
        }
    }
    @PutMapping(path="/update/{id}")
    public ResponseEntity<String> updateRole(@PathVariable("id") Long id, @RequestBody RoleRequest roleRequest) {
        ResponseEntity<String> responseEntity = roleService.updateRole(id, roleRequest);
        return responseEntity;
    }
}