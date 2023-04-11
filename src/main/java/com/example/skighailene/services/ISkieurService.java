package com.example.skighailene.services;

import com.example.skighailene.entities.Skieur;
import com.example.skighailene.entities.Support;
import com.example.skighailene.entities.TypeAbonnement;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ISkieurService {
    List<Skieur> retrieveAllSkieurs();
    Skieur addSkieur(Skieur skieur);


    void removeSkieur (Long numSkieur);
    Optional<Skieur> retrieveSkieur (Long numSkieur);
    Skieur updateSkieur (Skieur Skieur);
    Skieur assignSkierToPiste(Long numSkieur, Long numPiste);
    Skieur AssignSkierToSubscription(Long numSkieur, Long numAbon);

    List<Skieur> getSkieurByAbonnement_TypeAbon(TypeAbonnement typeAbonnement);

    List<Skieur> findByMoniteurNameAndSupportTypeJPQL(@Param("support") Support support, @Param("nom") String nom);


    List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement);
}
