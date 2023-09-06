package com.example.parc_auto.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.parc_auto.entities.Carnet_de_bord;
import org.springframework.stereotype.Repository;

@Repository
public interface Carnet_de_bordRepository extends JpaRepository<Carnet_de_bord, Integer> {

}