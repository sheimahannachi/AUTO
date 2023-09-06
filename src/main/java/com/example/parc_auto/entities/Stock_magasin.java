package com.example.parc_auto.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Table(name="tab_stock_magasin")
@Entity
public class Stock_magasin
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_magasin;

    private int nb_bon_entree;
    private int nb_bon_sortie;
    private Date date_entree;
    private Date date_sortie;

    public int getId_magasin() {
        return id_magasin;
    }
    public void setId_magasin(int id_magasin) {
        this.id_magasin = id_magasin;
    }
    public int getNb_bon_entree() {
        return nb_bon_entree;
    }
    public void setNb_bon_entree(int nb_bon_entree) {
        this.nb_bon_entree = nb_bon_entree;
    }
    public int getNb_bon_sortie() {
        return nb_bon_sortie;
    }
    public void setNb_bon_sortie(int nb_bon_sortie) {
        this.nb_bon_sortie = nb_bon_sortie;
    }
    public Date getDate_entree() {
        return date_entree;
    }
    public void setDate_entree(Date date_entree) {
        this.date_entree = date_entree;
    }
    public Date getDate_sortie() {
        return date_sortie;
    }
    public void setDate_sortie(Date date_sortie) {
        this.date_sortie = date_sortie;
    }
    public Stock_magasin(int id_magasin, int nb_bon_entree, int nb_bon_sortie, Date date_entree, Date date_sortie) {
        super();
        this.id_magasin = id_magasin;
        this.nb_bon_entree = nb_bon_entree;
        this.nb_bon_sortie = nb_bon_sortie;
        this.date_entree = date_entree;
        this.date_sortie = date_sortie;
    }

}

