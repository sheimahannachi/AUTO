package com.example.parc_auto.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name="tab_acquisition")
@Entity
public class Acquisition
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_acquisition;

    private float  montant_totale;

    public int getId_acquisition() {
        return id_acquisition;
    }

    public void setId_acquisition(int id_acquisition) {
        this.id_acquisition = id_acquisition;
    }

    public float getMontant_totale() {
        return montant_totale;
    }

    public void setMontant_totale(float montant_totale) {
        this.montant_totale = montant_totale;
    }

    public Acquisition(int id_acquisition, float montant_totale) {
        super();
        this.id_acquisition = id_acquisition;
        this.montant_totale = montant_totale;
    }
}