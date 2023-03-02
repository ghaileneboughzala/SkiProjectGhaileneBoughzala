package tn.esprit.tic.skighaileneboughzala.services;

import tn.esprit.tic.skighaileneboughzala.entities.Abonnement;

import java.util.List;
import java.util.Optional;

public interface IAbonnementService {

    List<Abonnement> retrieveAllAbonnement();
    Abonnement addAbonnement(Abonnement abonnement);
    Abonnement updateAbonnement (Abonnement abonnement);
    Optional<Abonnement> retrieveAbonnement (Long numAbon);

    void removeAbonnement(Long numAbon);
}
