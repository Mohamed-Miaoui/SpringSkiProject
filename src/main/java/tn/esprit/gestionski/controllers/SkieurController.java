package tn.esprit.gestionski.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Piste;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.entities.TypeAbonnement;
import tn.esprit.gestionski.repositories.SkieurRepository;
import tn.esprit.gestionski.services.SkieurServiceImp;

import java.util.List;


@AllArgsConstructor
@RestController
public class SkieurController {
    private SkieurServiceImp SkieurServiceImp;
    private SkieurRepository skieurRepository;


    @PostMapping("/addSkieur")
    public Skieur addSkieur(@RequestBody Skieur f){ // @RequestBody when we pass object
        return SkieurServiceImp.addSkieur(f);
    }

    @PutMapping("/updateSkieur")
    public Skieur updateSkieur(@RequestBody Skieur f){
        return SkieurServiceImp.updateSkieur(f);
    }

    @GetMapping("/skieurs")
    public List<Skieur> findAllSkieur(){
        return SkieurServiceImp.findAllSkieur();
    }

    @GetMapping("/getSkieurbyid/{id}")
    public Skieur findByIdSkieur(@PathVariable long id){ //@PathVariable cuz we pass the id in paramete to the path / when we passe just a variable
        return SkieurServiceImp.findByIdSkieur(id);
    }

    @DeleteMapping("/deleteSkieur/{id}")
    public void deleteById(@PathVariable long id){
        SkieurServiceImp.deleteSkieur(id);
    }

    @PostMapping("/assignSkierToPiste/{numSkieur}/{numPiste}")
    public Skieur assignSkierToPiste(@PathVariable long numPiste, @PathVariable long numSkieur){
        return SkieurServiceImp.assignSkierToPiste(numSkieur,numPiste);
    }
    @PostMapping("/assignSkierToCour/{numCour}")
    public Skieur assignSkierToCour(@RequestBody  Skieur skieur, @PathVariable Long numCour) {
        return SkieurServiceImp.assignSkierToCour(skieur,numCour);
    }
    @PostMapping("/assignSkierToAbonnement/{idSki}/{numAbonn}")
    public Skieur assignSkierToAbonnement(@PathVariable Long idSki, @PathVariable Long numAbonn) {

        return SkieurServiceImp.assignSkierToAbonnement(idSki, numAbonn);
    }

    @GetMapping("/retreiveSkieurByTypeAbonnement/{typeAbonnement}")
    public List<Skieur> retreiveSkieurByTypeAbonnement(@PathVariable  TypeAbonnement typeAbonnement){
        return skieurRepository.findByAbonnement_TypeAbon(typeAbonnement);
    }

}
