package com.example.parc_auto.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cin;

    private String nom;
    private String prenom;
    private String adresse  ;
    private  int telephone ;

    public int getId() {
        return cin;
    }
    public void setId(Integer cin) {
        this.cin = cin;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
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


    public User() {

    }

    public User(int cin, String nom, String prenom, String adresse, int telephone) {
        super();
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
    }

}

