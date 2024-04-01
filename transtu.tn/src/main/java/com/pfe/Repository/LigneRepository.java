package com.pfe.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.pfe.Entity.Ligne;

@Repository
@EnableJpaRepositories
public interface LigneRepository extends JpaRepository<Ligne, Long> {
    boolean existsByCodeOrLabel(String code, String label);
   
	

	List<Ligne> findAllByLabelIn(List<String> ligneLabels);
}