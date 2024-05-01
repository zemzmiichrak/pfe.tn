package com.pfe.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.Entity.SourceInfoType;
@Repository
public interface SourceInfoTypeRepository extends JpaRepository<SourceInfoType, Long> {
    SourceInfoType findByLabel(String label);
}