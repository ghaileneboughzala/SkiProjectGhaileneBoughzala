package tn.esprit.tic.skighaileneboughzala.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long numAbon;
    LocalDate dateDebut;
    LocalDate dateFin;
    float prixAbon;
    @Enumerated(EnumType.STRING)

    TypeAbonnement typeAbon;



}
