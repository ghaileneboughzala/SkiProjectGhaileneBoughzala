package tn.esprit.tic.skighaileneboughzala.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tic.skighaileneboughzala.entities.Abonnement;
import tn.esprit.tic.skighaileneboughzala.entities.TypeAbonnement;

import java.util.List;

public interface AbonnementRepository extends JpaRepository<Abonnement,Long > {

    List<Abonnement> findByTypeAbon(TypeAbonnement typeAbonnement);
}
