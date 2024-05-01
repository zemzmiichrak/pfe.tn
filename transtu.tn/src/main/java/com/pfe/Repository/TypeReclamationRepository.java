package com.pfe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.Entity.TypeReclamation;

@Repository
public interface TypeReclamationRepository extends JpaRepository<TypeReclamation, Long> {
    TypeReclamation findByLabel(String label);
}