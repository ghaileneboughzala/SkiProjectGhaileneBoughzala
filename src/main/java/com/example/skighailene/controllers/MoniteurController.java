package com.example.skighailene.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.skighailene.entities.Moniteur;
import com.example.skighailene.services.IMoniteurService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("moniteur")

public class MoniteurController {
    @Autowired
    IMoniteurService iMoniteurService;
    @GetMapping
    public List<Moniteur> getAll(){
        return iMoniteurService.retrieveAllMoniteurs();

    }
    @GetMapping("{numMoniteur}")

    public Optional<Moniteur> retrieveMoniteur(@PathVariable Long numMoniteur) {

        return  iMoniteurService.retrieveMoniteur(numMoniteur);

    }
    @PostMapping

    public Moniteur addMoniteur(@RequestBody Moniteur moniteur){

        return iMoniteurService.addMoniteur(moniteur);
    }
    @DeleteMapping("{numMoniteur}")
    public void removeMoniteur(@PathVariable Long numMoniteur){

        iMoniteurService.removeMoniteur(numMoniteur);
    }

    @PutMapping
    public Moniteur updateMoniteur(@RequestBody Moniteur Moniteur) {

        return  iMoniteurService.updateMoniteur(Moniteur);

    }
}
