package com.example.parc_auto.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.parc_auto.entities.Stock_magasin;

@Repository
public interface Stock_magasinrepository extends JpaRepository<Stock_magasin, Integer> {

}
