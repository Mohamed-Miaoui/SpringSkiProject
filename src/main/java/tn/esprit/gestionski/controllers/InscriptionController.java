package tn.esprit.gestionski.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Support;
import tn.esprit.gestionski.services.Iinscritption;
import tn.esprit.gestionski.services.InscriptionServiceImp;

import java.util.List;

@AllArgsConstructor
@RestController
public class InscriptionController {
    private Iinscritption iinscritption;
    private InscriptionServiceImp InscriptionServiceImp;

    @PostMapping("/addInscriptionIns")
    public Inscription addInscription(@RequestBody Inscription i){ // @RequestBody when we pass object
        //return InscriptionServiceImp.addInscription(f);
        return iinscritption.addInscription(i);
    }

    @PutMapping("/updateIns")
    public Inscription updateInscription(@RequestBody Inscription i){
        //return InscriptionServiceImp.updateInscription(f);
        return iinscritption.updateInscription(i);
    }

    @GetMapping("/getallIns")
    public List<Inscription> findAllInscription(){
        //return InscriptionServiceImp.findAllInscription();
        return iinscritption.findAllInscription();
    }

    @GetMapping("/getbyidIns/{id}")
    public Inscription findByIdInscription(@PathVariable long id){ //@PathVariable cuz we pass the id in paramete to the path / when we passe just a variable
        //return InscriptionServiceImp.findByIdInscription(id);
        return iinscritption.findByIdInscription(id);
    }

    @DeleteMapping("/deleteIns/{id}")
    public void deleteById(@PathVariable long id){
        //InscriptionServiceImp.deleteInscription(id);
        iinscritption.deleteInscription(id);
    }
    @PostMapping("/addAndAssignSkieur/{numSkieur}")
    public Inscription addInscriptionandAssaginSkieur(@RequestBody Inscription inscription,@PathVariable long numSkieur){
        return iinscritption.addInscriptionandAssaginSkieur(inscription,numSkieur);
    }
    @PostMapping("/addAndAssignCours/{numCours}")
    public Inscription addInscriptionandAssaginCour(@RequestBody Inscription inscription,@PathVariable long numCours){
        return iinscritption.addInscriptionandAssaginCours(inscription,numCours);
    }

    @GetMapping("/numWeeksCourseOfInstructorBySup/{nummoniteur}/{support}")
    public  List<Integer> numWeeksCourseOfInstructorBySup(@PathVariable Long nummoniteur,@PathVariable Support support){
        return iinscritption.numWeeksCourseOfInstructorBySupport(nummoniteur,support);
    }
    //homework------------------------------
    @PostMapping("/addAndAssignCoursAndSkieur/{numsk}/{numCours}")
    public Inscription addRegistrationAndAssignToSkierAndCourse(@RequestBody Inscription inscription,@PathVariable long numsk,@PathVariable long numCours){
        return iinscritption.addRegistrationAndAssignToSkierAndCourse(inscription,numsk,numCours);
    }





}
