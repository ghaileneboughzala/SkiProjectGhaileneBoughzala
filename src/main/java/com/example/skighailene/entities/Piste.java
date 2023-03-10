package com.example.skighailene.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Piste {
    @Id

@GeneratedValue(strategy = GenerationType.IDENTITY)
    long numPiste;
    String nomPiste;
    int longeur;
    int pente;
    @Enumerated(EnumType.STRING)

    Couleur couleur;
    @ManyToMany(mappedBy = "pistes")
    private Set<Skieur> skieurs;

}
