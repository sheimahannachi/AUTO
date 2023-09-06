package com.example.parc_auto.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name="tab_carnet_de_bord")
@Entity
public class Carnet_de_bord
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int kilometrage_initial;
    private int kilometrage_sortie;
    private String obsrevation;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getKilometrage_initial() {
        return kilometrage_initial;
    }
    public void setKilometrage_initial(int kilometrage_initial) {
        this.kilometrage_initial = kilometrage_initial;
    }
    public int getKilometrage_sortie() {
        return kilometrage_sortie;
    }
    public void setKilometrage_sortie(int kilometrage_sortie) {
        this.kilometrage_sortie = kilometrage_sortie;
    }
    public String getObsrevation() {
        return obsrevation;
    }
    public void setObsrevation(String obsrevation) {
        this.obsrevation = obsrevation;
    }
    public Carnet_de_bord(int id, int kilometrage_initial, int kilometrage_sortie, String obsrevation) {
        super();
        this.id = id;
        this.kilometrage_initial = kilometrage_initial;
        this.kilometrage_sortie = kilometrage_sortie;
        this.obsrevation = obsrevation;
    }

}




