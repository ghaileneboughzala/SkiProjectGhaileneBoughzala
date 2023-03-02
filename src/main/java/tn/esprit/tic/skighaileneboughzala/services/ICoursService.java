package tn.esprit.tic.skighaileneboughzala.services;

import tn.esprit.tic.skighaileneboughzala.entities.Cours;

import java.util.List;
import java.util.Optional;

public interface ICoursService {

    List<Cours> retrieveAllCours();
    Cours addCours(Cours cours);
    Cours updateCours (Cours cours);
    Optional<Cours> retrieveCours (Long numCours);

    void removeCours(Long numCours);

}
