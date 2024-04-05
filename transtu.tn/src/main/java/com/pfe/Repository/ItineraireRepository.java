package com.pfe.Repository;






import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.Entity.Itineraire;

@Repository
public interface ItineraireRepository extends JpaRepository<Itineraire, Long> {


	

}