package tn.esprit.tic.skighaileneboughzala.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore

    private Cours cours;

    @ManyToOne
    @JsonIgnore
    private Skieur skieur;



}
