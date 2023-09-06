package com.example.parc_auto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.parc_auto.entities.Acquisition;
@Repository
public interface AcquisitionRepository extends JpaRepository<Acquisition, Integer> {

}