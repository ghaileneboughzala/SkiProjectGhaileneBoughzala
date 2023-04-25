package com.example.skighailene.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.example.skighailene.entities.Moniteur;
import com.example.skighailene.repositories.MoniteurRepository;

import java.util.List;
import java.util.Optional;

@Slf4j //elle va déclarer un espace log dans cette classe et dans void test je vais définir le message
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

    @Scheduled(fixedDelay = 60000)
    @Scheduled(fixedRate = 60000)
    @Scheduled(cron = "0 0 0 * * MON-FRI" )
    @Override
    public void testScheduler() {

        //le message de retour
        log.info("4ds4 hello");
        System.out.println();

    }
}
