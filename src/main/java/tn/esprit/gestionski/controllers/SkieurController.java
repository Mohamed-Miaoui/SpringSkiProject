package tn.esprit.gestionski.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.services.SkieurServiceImp;

import java.util.List;

@AllArgsConstructor
@RestController
public class SkieurController {
    private SkieurServiceImp SkieurServiceImp;

    @PostMapping("/addSkieur")
    public Skieur addSkieur(@RequestBody Skieur f){ // @RequestBody when we pass object
        return SkieurServiceImp.addSkieur(f);
    }

    @PutMapping("/update")
    public Skieur updateSkieur(@RequestBody Skieur f){
        return SkieurServiceImp.updateSkieur(f);
    }

    @GetMapping("/getall")
    public List<Skieur> findAllSkieur(){
        return SkieurServiceImp.findAllSkieur();
    }

    @GetMapping("/getbyid/{id}")
    public Skieur findByIdSkieur(@PathVariable long id){ //@PathVariable cuz we pass the id in paramete to the path / when we passe just a variable
        return SkieurServiceImp.findByIdSkieur(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){
        SkieurServiceImp.deleteSkieur(id);
    }

}
