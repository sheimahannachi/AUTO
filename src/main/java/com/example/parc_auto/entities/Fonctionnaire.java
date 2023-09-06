package com.example.parc_auto.entities;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Table(name="tab_fonctionnaire")
@Entity
public class Fonctionnaire extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cin;



}
