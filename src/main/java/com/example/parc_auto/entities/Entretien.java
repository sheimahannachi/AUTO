package com.example.parc_auto.entities;

import javax.persistence.*;

@Table(name="tab_entretien")
@Entity
public class Entretien {  // Class names should start with an uppercase letter and follow CamelCase.

    public enum OperationEntretien {  // Enum names should start with an uppercase letter and follow CamelCase.
        VIDANGE_MOTEUR,
        CHAN_CROIE_CLIMATISEUR,
        CHAN_MANOMETRE_RADIATEUR,
        VERIFICATION_CIRCUIT_EAU,
        CHAN_JEU_DE_FREDAU_ARRIERE,
        CHAN_TRAIN_DE_ROUE_AVANT,
        CHAN_TAMBOUR_ARRIERE,
        CHAN_TRAIN_ROUE_AVANT,
        CHAN_FREDAU_ARRIERE,
        CHAN_MARMITE_ARRIERE,
        CHAN_CHAINE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_entretien;  // Changed "Int" to "int" to fix the data type.

    private OperationEntretien operation_entretien;  // Changed "Operation_entretien" to "OperationEntretien" to match the enum name.

    public int getId_entretien() {
        return id_entretien;
    }

    public void setId_entretien(int id_entretien) {
        this.id_entretien = id_entretien;
    }

    public OperationEntretien getOperation_entretien() {
        return operation_entretien;
    }

    public void setOperation_entretien(OperationEntretien operation_entretien) {
        this.operation_entretien = operation_entretien;
    }

    public Entretien(int id_entretien, OperationEntretien operation_entretien) {
        this.id_entretien = id_entretien;
        this.operation_entretien = operation_entretien;
    }

    public Entretien() {
        // Default constructor is needed for JPA.
    }
}
