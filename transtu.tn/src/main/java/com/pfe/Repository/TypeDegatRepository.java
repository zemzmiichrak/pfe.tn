package com.pfe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.Entity.TypeDegat;
@Repository
public interface TypeDegatRepository extends JpaRepository<TypeDegat, Long> {
    TypeDegat findByLabel(String label);
}
