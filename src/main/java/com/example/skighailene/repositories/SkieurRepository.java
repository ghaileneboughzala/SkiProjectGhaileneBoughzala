package com.example.skighailene.repositories;

import com.example.skighailene.entities.TypeAbonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.skighailene.entities.Skieur;

import java.util.List;

public interface SkieurRepository extends JpaRepository<Skieur,Long > {

    List<Skieur> findByAbonnementTypeAbon(TypeAbonnement typeAbonnement);
}
