package tn.esprit.tic.skighaileneboughzala.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
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
    @JsonIgnore
    private List<Skieur> skieurs;

}
