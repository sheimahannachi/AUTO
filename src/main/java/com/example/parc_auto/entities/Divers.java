package com.example.parc_auto.entities;

import javax.persistence.*;

@Table(name="tab_divers")
@Entity
public class Divers {  // Class names should start with an uppercase letter and follow CamelCase.

    public enum OperationDivers {  // Enum names should start with an uppercase letter and follow CamelCase.
        REPARATION_TOLE,
        ACHAT_PIECES_DE_RECHANGE,
        ACHAT_BATTERIE,
        DEMANDE_DEVIS
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_divers;  // Changed "Int" to "int" to fix the data type.

    private OperationDivers operation_divers;  // Changed "Operation_divers" to "OperationDivers" to match the enum name.

    public int getId_divers() {
        return id_divers;
    }

    public void setId_divers(int id_divers) {
        this.id_divers = id_divers;
    }

    public OperationDivers getOperation_divers() {
        return operation_divers;
    }

    public void setOperation_divers(OperationDivers operation_divers) {
        this.operation_divers = operation_divers;
    }

    public Divers(int id_divers, OperationDivers operation_divers) {
        this.id_divers = id_divers;
        this.operation_divers = operation_divers;
    }

    public Divers() {
        // Default constructor is needed for JPA.
    }
}

