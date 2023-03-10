package com.example.skighailene.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    long numInscription;
    int numSemaine;
    @ManyToOne
    private Cours cours;

    @ManyToOne
    private Skieur skieur;



}
