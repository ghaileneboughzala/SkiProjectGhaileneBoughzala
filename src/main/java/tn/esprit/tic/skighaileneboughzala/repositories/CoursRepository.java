package tn.esprit.tic.skighaileneboughzala.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tic.skighaileneboughzala.entities.Cours;

import java.util.List;

public interface CoursRepository extends JpaRepository<Cours,Long > {

    
}
