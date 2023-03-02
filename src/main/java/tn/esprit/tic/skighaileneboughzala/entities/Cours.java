package tn.esprit.tic.skighaileneboughzala.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long numCours;

    private int niveau;

    private float prix;
    private int creneau;
@Enumerated(EnumType.STRING)
    private TypeCours typeCours;
    @Enumerated(EnumType.ORDINAL)

    private Support support;
    @OneToMany(mappedBy = "cours")
    private List<Inscription> inscriptions;
}
