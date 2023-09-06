package com.example.parc_auto.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name="tab_fournisseur")
@Entity
public class Fournisseur
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_fournisseur;
    @Column(name="adresse")
    private String adresse;
    private int telephone;

    public int getId_fournisseur() {
        return id_fournisseur;
    }
    public void setId_fournisseur(int id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public int getTelephone() {
        return telephone;
    }
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    public Fournisseur(int id_fournisseur, String adresse, int telephone) {
        super();
        this.id_fournisseur = id_fournisseur;
        this.adresse = adresse;
        this.telephone = telephone;
    }
}