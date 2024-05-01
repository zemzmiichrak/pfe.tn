package com.pfe.Repository;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.pfe.Entity.Ligne;

@Repository
@EnableJpaRepositories
public interface LigneRepository extends JpaRepository<Ligne, Long> {
    boolean existsByCodeOrLabel(String code, String label);
   

	List<Ligne> findAllByLabelIn(List<String> ligneLabels);

	List<Ligne> findAllByIdIn(List<Long> ids);
	
	Optional<Ligne> findByLabel(String label);

	Set<Ligne> findAllByIdIn(Set<Long> lignesIds);



	
}