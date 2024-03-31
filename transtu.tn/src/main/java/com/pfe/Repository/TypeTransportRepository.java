package com.pfe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.Entity.TypeTransport;

@Repository
public interface TypeTransportRepository extends JpaRepository<TypeTransport, Long> {
    
}
