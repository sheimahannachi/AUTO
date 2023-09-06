package com.example.parc_auto.entities;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Table (name = "tab_vehicule")
@Entity
public class Vehicule {

    public enum Type {
        Service,
        Fonction
    }

    public enum Marque {
        Peugeot,
        Citroen,
        Renault,
        Opel,
        Audi
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="immatriculation")
    private String immatriculation;
    @Column(name="puissance")
     private int puissance;
    @Column(name="date_d'aquisition")
    private LocalDate date_aquisition;
    @Column(name="kilometrage_initial")
    private float kilometrage_initial;
    @Column(name="poids")
    private float poids;
    @Column(name="nb_places")
    private int nb_places;
    @Column(name="type_vehicule")
    private Type type;
    @Column(name="marque")
    private Marque marque;

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public LocalDate getDate_aquisition() {
        return date_aquisition;
    }

    public void setDate_aquisition(LocalDate date_aquisition) {
        this.date_aquisition = date_aquisition;
    }

    public float getKilometrage_initial() {
        return kilometrage_initial;
    }

    public void setKilometrage_initial(float kilometrage_initial) {
        this.kilometrage_initial = kilometrage_initial;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public int getNb_places() {
        return nb_places;
    }

    public void setNb_places(int nb_places) {
        this.nb_places = nb_places;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Vehicule(String immatriculation, int puissance, LocalDate date_aquisition, float kilometrage_initial,
                    float poids, int nb_places, Type type, Marque marque) {
        super();
        this.immatriculation = immatriculation;
        this.puissance = puissance;
        this.date_aquisition = date_aquisition;
        this.kilometrage_initial = kilometrage_initial;
        this.poids = poids;
        this.nb_places = nb_places;
        this.type = type;
        this.marque = marque;
    }

    public Vehicule() {

    }
}

