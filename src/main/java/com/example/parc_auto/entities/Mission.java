package com.example.parc_auto.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Table(name="tab_mission")
@Entity
public class Mission
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_mission;

    private Date date_debut;
    private Date date_fin;

    public int getId_mission() {
        return id_mission;
    }
    public void setId_mission(int id_mission) {
        this.id_mission = id_mission;
    }
    public Date getDate_debut() {
        return date_debut;
    }
    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }
    public Date getDate_fin() {
        return date_fin;
    }
    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }
    public Mission(int id_mission, Date date_debut, Date date_fin) {
        super();
        this.id_mission = id_mission;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }



}
