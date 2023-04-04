package com.example.skighailene.repositories;

import com.example.skighailene.entities.Couleur;
import com.example.skighailene.entities.Support;
import com.example.skighailene.entities.TypeAbonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.skighailene.entities.Skieur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.tic.skighaileneboughzala.entities.TypeCours;

import java.util.List;

public interface SkieurRepository extends JpaRepository<Skieur,Long > {


    List<Skieur> findByAbonnementTypeAbon(TypeAbonnement typeAbonnement);

    @Query("select s from Skieur s where s.abonnement.typeAbon = ?1 and s.ville = ?2 ")
    List<Skieur> findByAbonnementTypeAbonJPQL(TypeAbonnement typeAbonnement);

    @Query(value = "select * from Skieur s where s.abonnement.typeAbon = :typeAbonnement and s.ville = :ville ",nativeQuery = true)
    List<Skieur> findByAbonnementTypeAbonJPQL2(TypeAbonnement typeAbonnement);

    @Query(value ="SELECT *" +
            "FROM skieur s "+
            "join abonnement a" +
            "on s.abonnement_num_abon=a.num_abon"+
            " WHERE a.type_abon=:typeAbonnement"+
            "AND s.ville=:ville",nativeQuery = true)
    List<Skieur> findSkieurByAbonnement_TypeAbonjpSQL(@Param(  "typeAbonnement") TypeAbonnement typeAbonnement, @Param("ville") String abc);

    List<Skieur> findByInscriptionsCoursTypeCoursAndInscriptionsCoursSupportAndPistesCouleur(TypeCours insctiptions_cours_typecours, Support inscriptions_cours_support, Couleur pistes_couleur);
}
