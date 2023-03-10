package com.example.skighailene.repositories;

import com.example.skighailene.entities.TypeAbonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.skighailene.entities.Abonnement;

import java.time.LocalDate;
import java.util.List;

public interface AbonnementRepository extends JpaRepository<Abonnement,Long > {

    List<Abonnement> findByTypeAbon(TypeAbonnement typeAbonnement);

    List<Abonnement> findAbonnementByDateDebutAndDateFin(LocalDate startDate, LocalDate endDate);
}
