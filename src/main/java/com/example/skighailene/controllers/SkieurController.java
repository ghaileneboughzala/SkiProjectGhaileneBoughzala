package com.example.skighailene.controllers;

import com.example.skighailene.entities.Support;
import com.example.skighailene.entities.TypeAbonnement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.skighailene.entities.Skieur;
import com.example.skighailene.services.ISkieurService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("skieur")
public class SkieurController {
    @Autowired
    ISkieurService iSkieurService;
    //localhost:9090/retrieveAllSkieurs
    @GetMapping
    public List<Skieur> getAll(){
        return iSkieurService.retrieveAllSkieurs();

    }
    @GetMapping("{numSkieur}")

    public Optional<Skieur> retrieveSkieur(@PathVariable Long numSkieur) {

        return  iSkieurService.retrieveSkieur(numSkieur);

    }
    @PostMapping

    public Skieur addSkieur(@RequestBody Skieur skieur){

        return iSkieurService.addSkieur(skieur);
    }
    @DeleteMapping("{numSkieur}")
    public void removeSkieur(@PathVariable Long numSkieur){

        iSkieurService.removeSkieur(numSkieur);
    }

    @PutMapping
    public Skieur updateSkieur(@RequestBody Skieur Skieur) {

        return  iSkieurService.updateSkieur(Skieur);

    }
    @PutMapping("{numSkieur}/{numPiste}")
    public Skieur assignSkierToPiste(@PathVariable Long numSkieur,@PathVariable Long numPiste){
        return iSkieurService.assignSkierToPiste(numSkieur, numPiste);
    }

    @PutMapping("{numSkieur}/{numAbon}")
    public Skieur AssignSkierToSubscription(@PathVariable Long numSkieur, @PathVariable Long numAbon) {
        return iSkieurService.AssignSkierToSubscription(numSkieur, numAbon);
    }
    @GetMapping("getSkieurParTypeAbon/{type}")
    public List<Skieur> getSkieurParTypeAbon(@PathVariable TypeAbonnement type){
        return  iSkieurService.retrieveSkiersBySubscriptionType(type);
    }

    @GetMapping("findByNameAndSupport/{support}/{nom}")
    public List<Skieur> findByMoniteurNameAndSupportTypeJPQL(@PathVariable Support support, @PathVariable String nom) {
        return iSkieurService.findByMoniteurNameAndSupportTypeJPQL(support, nom);
    }
}
