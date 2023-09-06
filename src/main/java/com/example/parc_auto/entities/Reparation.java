package com.example.parc_auto.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Table(name="tab_reparation")
@Entity
public class Reparation {

    public enum OperationReparation {

        REPARATION_ROUE,
        VISITE_CONTROLE,
        VERIFICATION_FUITE_HUILE,
        VERIFICATION_LAMPE_TEMOIN,
        VERIFICATION_BRUIT_AVANT_TRAIN,
        CHANGEMENT_RETROVISEUR,
        VERIFICATION_PONT_ARRIERE,
        MISE_EN_ETAT_LEVE_VITRE,
        CHANGEMENT_BATTERIE,
        MISE_EN_ETAT_MOTEUR

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_reparation;

    private OperationReparation operation_reparation;

    public int getId_reparation() {
        return id_reparation;
    }

    public void setId_reparation(int id_reparation) {
        this.id_reparation = id_reparation;
    }

    public OperationReparation getOperation_reparation() {
        return operation_reparation;
    }

    public void setOperation_reparation(OperationReparation operation_reparation) {
        this.operation_reparation = operation_reparation;
    }

    public Reparation(int id_reparation, OperationReparation operation_reparation) {
        this.id_reparation = id_reparation;
        this.operation_reparation = operation_reparation;
    }

    public Reparation() {

    }
}
