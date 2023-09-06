package com.example.parc_auto.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name="tab_chauffeur")
@Entity
public class Chauffeur extends User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private String direction;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Chauffeur(String direction) {
        super();
        this.direction = direction;
    }

}