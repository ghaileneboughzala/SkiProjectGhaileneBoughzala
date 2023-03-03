package tn.esprit.tic.skighaileneboughzala.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.skighaileneboughzala.entities.Skieur;
import tn.esprit.tic.skighaileneboughzala.services.ISkieurService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("skieur")
public class SkieurController {
    @Autowired
    ISkieurService iSkieurService;

    //localhost:9090/retrieveAllSkieurs
    @GetMapping
    public List<Skieur> getAll() {
        return iSkieurService.retrieveAllSkieurs();

    }

    @GetMapping("{numSkieur}")

    public Optional<Skieur> retrieveSkieur(@PathVariable Long numSkieur) {

        return iSkieurService.retrieveSkieur(numSkieur);

    }

    @PostMapping

    public Skieur addSkieur(@RequestBody Skieur skieur) {

        return iSkieurService.addSkieur(skieur);
    }

    @DeleteMapping("{numSkieur}")
    public void removeSkieur(@PathVariable Long numSkieur) {

        iSkieurService.removeSkieur(numSkieur);
    }

    @PutMapping
    public Skieur updateSkieur(@RequestBody Skieur Skieur) {

        return iSkieurService.updateSkieur(Skieur);

    }

    @PutMapping("/assignSkierToPiste/{numSkieur}/{numPiste}")
    public Skieur assignSkierToPiste(@PathVariable Long numSkieur, @PathVariable Long numPiste) {
        return iSkieurService.assignSkierToPiste(numSkieur, numPiste);

    }
    @PutMapping("{numSkieur}/{numAbon}")

    public Skieur AssignSkierToSubscription(@PathVariable long numSkieur, @PathVariable long numAbon) {

        return iSkieurService.AssignSkierToSubscription(numSkieur, numAbon);
    }

    @PutMapping("{numSkieur}/{numInscription}")

    public Skieur AssignSkierToInscription(@PathVariable long numSkieur, @PathVariable long numInscription) {

        return iSkieurService.assignSkierToInscription(numSkieur, numInscription);
    }
}