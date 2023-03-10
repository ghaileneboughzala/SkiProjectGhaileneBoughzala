package com.example.skighailene.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.skighailene.entities.Inscription;

public interface InscriptionRepository extends JpaRepository<Inscription,Long > {
}
