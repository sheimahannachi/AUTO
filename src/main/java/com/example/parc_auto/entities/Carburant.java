package com.example.parc_auto.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Carburant {  // Class names should start with an uppercase letter and follow CamelCase.

    public enum Libelle {  // Enum names should start with an uppercase letter and follow CamelCase.
        ESSENCE,
        GAZOILE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_carburant;  // Changed "Int" to "int" to fix the data type.

    private Libelle libelle;  // Changed "Libellé" to "Libelle" to match the enum name.

    public int getId_carburant() {
        return id_carburant;
    }

    public void setId_carburant(int id_carburant) {
        this.id_carburant = id_carburant;
    }

    public Libelle getLibelle() {
        return libelle;
    }

    public void setLibelle(Libelle libelle) {
        this.libelle = libelle;
    }

    public Carburant(int id_carburant, Libelle libelle) {
        this.id_carburant = id_carburant;
        this.libelle = libelle;
    }

    public Carburant() {
        // Default constructor is needed for JPA.
    }
}
