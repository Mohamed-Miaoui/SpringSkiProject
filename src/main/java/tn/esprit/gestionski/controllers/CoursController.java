package tn.esprit.gestionski.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionski.entities.Cours;
import tn.esprit.gestionski.services.ICours;

import java.util.List;

@AllArgsConstructor
@RestController
public class CoursController {
    
    private ICours iCours;
    @PostMapping("/addCours")
    public Cours addCours(@RequestBody Cours i){ // @RequestBody when we pass object
        //return CoursServiceImp.addCours(f);
        return iCours.addCours(i);
    }

    @PutMapping("/updatecours")
    public Cours updateCours(@RequestBody Cours i){
        //return CoursServiceImp.updateCours(f);
        return iCours.updateCours(i);
    }

    @GetMapping("/getallcours")
    public List<Cours> findAllCours(){
        //return CoursServiceImp.findAllCours();
        return iCours.findAllCours();
    }

    @GetMapping("/getbyidcours/{id}")
    public Cours findByIdCours(@PathVariable long id){ //@PathVariable cuz we pass the id in paramete to the path / when we passe just a variable
        //return CoursServiceImp.findByIdCours(id);
        return iCours.findByIdCours(id);
    }

    @DeleteMapping("/deletecours/{id}")
    public void deleteById(@PathVariable long id){
        //CoursServiceImp.deleteCours(id);
        iCours.deleteCours(id);
    }
}
