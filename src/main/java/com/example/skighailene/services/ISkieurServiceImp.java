package com.example.skighailene.services;

import com.example.skighailene.entities.*;
import com.example.skighailene.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ISkieurServiceImp implements ISkieurService{
    @Autowired
    SkieurRepository skieurRepository;
    @Autowired
    PisteRepository pisteRepo;
    @Autowired
    AbonnementRepository abonnementRepo;
    @Autowired
    private CoursRepository coursRepository;
    @Autowired
    private InscriptionRepository inscriptionRepository;

    @Override
    public List<Skieur> retrieveAllSkieurs() {
        return  skieurRepository.findAll();
    }

    @Override
    public Skieur addSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }


    @Override
    public void removeSkieur(Long numSkieur) {
        skieurRepository.deleteById(numSkieur);
    }

    @Override
    public Optional<Skieur> retrieveSkieur(Long numSkieur) {
        return skieurRepository.findById(numSkieur);
    }

    @Override
    public Skieur updateSkieur(Skieur Skieur) {
        return skieurRepository.save(Skieur);
    }

    @Override
    public Skieur assignSkierToPiste(Long numSkieur, Long numPiste) {

        Skieur skieur =  skieurRepository.findById(numSkieur).orElse(null);
        Piste piste = pisteRepo.findById(numPiste).orElse(null);

        if(skieur!=null && piste!=null){

           // piste.getSkieurs().add(skieur);
            Set<Piste> pistes = skieur.getPistes();
            pistes.add(piste);
            skieur.setPistes(pistes);
            return skieurRepository.save(skieur);
        }
        //return skieurRepository.findById(numSkieur).orElse(null);
        return  null ;
    }

    @Override
    public Skieur AssignSkierToSubscription(Long numSkieur, Long  numAbon) {
        Skieur skieur =  skieurRepository.findById(numSkieur).orElse(null);
        Assert.notNull(skieur,"skieur not found");
        Abonnement abonnement = abonnementRepo.findById(numAbon).orElse(null);
        Assert.notNull(abonnement,"abonnement not found");
        //if(skieur!=null && abonnement!=null) {
            skieur.setAbonnement(abonnement);
            return skieurRepository.save(skieur);
        //}
        //return null;
    }

    @Override
    public List<Skieur> getSkieurByAbonnement_TypeAbon(TypeAbonnement typeAbonnement) {
        return skieurRepository.findByAbonnementTypeAbon(typeAbonnement);
    }

    @Override
    public List<Skieur> findByMoniteurNameAndSupportTypeJPQL(Support support, String nom) {
        return skieurRepository.findByMoniteurNameAndSupportTypeJPQL(support, nom);
    }


    @Override
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
        return skieurRepository.findByAbonnementTypeAbon(typeAbonnement);
    }

    @Override
    public Skieur addSkierAndAssignToCourse(Skieur skieur) {
        Assert.notNull(skieur.getAbonnement(),"Abonnement must not be empty"); //Je vérifie si l'abobjet abonnement existe
        Assert.notNull(skieur.getInscriptions(),"Inscriptions must not be empty"); // Je vérifie l'existance de l'objet Insctiption
        Set<Inscription> inscriptions=skieur.getInscriptions();
        inscriptions.forEach(inscription ->  { //Je parcoue la liste des inscriptions et je m'assure que chaque inscri contient un cours
            Assert.notNull(inscription.getCours().getNumCours(), " Cours must be entered !!");
            Cours cours = coursRepository.findById(inscription.getCours().getNumCours()).orElse(null);
            Assert.notNull(cours, " No cours found with this id!");
            inscription.setCours(cours); //Inscription contient un seul cours donc l'inscription gérera la relation et affectera l'inscription au cours
            inscription.setSkieur(skieur);
            inscriptionRepository.save(inscription);
            //Exception handler
        });
        skieurRepository.save(skieur);//Je l'insère dans cette partie ( en dehors de la boucle for vu qu'il ne va pas enregistrer les ctrls de saisie et j'implémenterai une autre boucle for
        //Pas de différence entre save and saveandflush juste la notification instantannée pour flush
        skieur.getInscriptions().forEach(inscription -> {
            inscription.setSkieur(skieur);
            inscriptionRepository.save(inscription);
        });
        return skieur;
    }


}
