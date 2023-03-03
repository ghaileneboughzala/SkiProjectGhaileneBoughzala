package tn.esprit.tic.skighaileneboughzala.services;

import tn.esprit.tic.skighaileneboughzala.entities.Skieur;

import java.util.List;
import java.util.Optional;

public interface ISkieurService {
    List<Skieur> retrieveAllSkieurs();
    Skieur addSkieur(Skieur skieur);


    void removeSkieur (Long numSkieur);
    Optional<Skieur> retrieveSkieur (Long numSkieur);
    Skieur updateSkieur (Skieur Skieur);
    Skieur assignSkierToPiste(Long numSkieur, Long numPiste);
    Skieur AssignSkierToSubscription(long numSkieur, long numAbon);

    Skieur assignSkierToInscription(Long numSkieur, Long numInscription);


}
