package com.example.skighailene.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Cours extends BaseEntity {

     //On l'a modifiée ( best practice base entity )
     private long id;

    private int niveau;

    private float prix;
    private int creneau;
@Enumerated(EnumType.STRING)
    private TypeCours typeCours;
    @Enumerated(EnumType.ORDINAL)

    private Support support;
    @OneToMany(mappedBy = "cours")
    @JsonIgnore
    private List<Inscription> inscriptions;
}
