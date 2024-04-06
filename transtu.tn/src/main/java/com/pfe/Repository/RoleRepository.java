package com.pfe.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.pfe.Entity.Role;

@Repository
@EnableJpaRepositories
public interface RoleRepository extends JpaRepository<Role,Long>{

	Optional<Role> findByLabel(String label);

	

}