package com.example.parc_auto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.parc_auto.entities.Carburant;
@Repository
public interface CarburantRepository extends JpaRepository<Carburant, Integer> {

}
