package com.example.skighailene.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.skighailene.entities.Inscription;
import com.example.skighailene.services.IInscriptionService;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("inscription")

public class InscriptionController {

    @Autowired
    IInscriptionService iInscriptionService;
    @GetMapping
    public List<Inscription> getAll(){
        return iInscriptionService.retrieveAllInscription();

    }
    @GetMapping("{numInscription}")

    public Optional<Inscription> retrieveInscription(@PathVariable Long numInscription) {

        return  iInscriptionService.retrieveInscription(numInscription);

    }
    @PostMapping

    public Inscription addInscription(@RequestBody Inscription inscription){

        return iInscriptionService.addInscription(inscription);
    }
    @DeleteMapping("{numInscription}")
    public void removeInscription(@PathVariable Long numInscription){

        iInscriptionService.removeInscription(numInscription);
    }

    @PutMapping
    public Inscription updateInscription(@RequestBody Inscription inscription) {

        return  iInscriptionService.updateInscription(inscription);

    }
}
