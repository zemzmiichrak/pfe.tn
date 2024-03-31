package com.pfe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.Entity.MoyenTransport;



@Repository
public interface MoyenTransportRepository extends JpaRepository<MoyenTransport, Long> {
   
}