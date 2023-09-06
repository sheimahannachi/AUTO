package com.example.parc_auto.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name="tab_dotations")
@Entity
public class Dotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_dotation;

    private float montant_totale;


    public int getId_dotation() {
        return id_dotation;
    }

    public void setId_dotation(int id_dotation) {
        this.id_dotation = id_dotation;
    }

    public float getMontant_totale() {
        return montant_totale;
    }

    public void setMontant_totale(float montant_totale) {
        this.montant_totale = montant_totale;
    }

    public Dotation(int id_dotation, float montant_totale) {
        super();
        this.id_dotation = id_dotation;
        this.montant_totale = montant_totale;
    }
}