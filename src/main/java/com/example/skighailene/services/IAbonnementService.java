package com.example.skighailene.services;

import com.example.skighailene.entities.Abonnement;
import com.example.skighailene.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;


public interface IAbonnementService {

    List<Abonnement> retrieveAllAbonnement();
    Abonnement addAbonnement(Abonnement abonnement);
    Abonnement updateAbonnement (Abonnement abonnement);
    Abonnement retrieveAbonnement (Long numAbon);

    void removeAbonnement(Long numAbon);
    List<Abonnement> getSubParType(TypeAbonnement typeAbonnement);
    List<Abonnement> retrieveSubscriptionsByDates(LocalDate dateDebut, LocalDate dateFin);
}
