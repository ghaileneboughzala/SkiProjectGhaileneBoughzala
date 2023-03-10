package com.example.skighailene.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.skighailene.entities.Moniteur;
import com.example.skighailene.repositories.MoniteurRepository;

import java.util.List;
import java.util.Optional;

@Service
public class IMoniteurServiceImp implements IMoniteurService{

    @Autowired
    MoniteurRepository moniteurRepository;
    @Override
    public List<Moniteur> retrieveAllMoniteurs() {
        return moniteurRepository.findAll();
    }

    @Override
    public Moniteur addMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }

    @Override
    public Moniteur updateMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);    }

    @Override
    public Optional<Moniteur> retrieveMoniteur(Long numMoniteur) {

        return moniteurRepository.findById(numMoniteur);
    }

    @Override
    public void removeMoniteur(Long numMoniteur) {
        moniteurRepository.deleteById(numMoniteur);

    }
}
