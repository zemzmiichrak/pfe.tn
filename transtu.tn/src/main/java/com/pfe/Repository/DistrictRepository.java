package com.pfe.Repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.Entity.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {

	 List<District> findByLabelIn(Set<String> districtLabels);
	 List<District> findByRolesId(Long roleId);
  
}