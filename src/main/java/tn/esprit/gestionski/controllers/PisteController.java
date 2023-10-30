package tn.esprit.gestionski.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionski.entities.Piste;
import tn.esprit.gestionski.services.IPiste;

import java.util.List;

@AllArgsConstructor
@RestController
public class PisteController {
    private IPiste iPiste;
    
    @PostMapping("/addPiste")
    public Piste addPiste(@RequestBody Piste p){ // @RequestBody when we pass object
        //return PisteServiceImp.addPiste(f);
        return iPiste.addPiste(p);
    }

    @PutMapping("/updatePiste")
    public Piste updatePiste(@RequestBody Piste p){
        //return PisteServiceImp.updatePiste(f);
        return iPiste.updatePiste(p);
    }

    @GetMapping("/getallPiste")
    public List<Piste> findAllPiste(){
        //return PisteServiceImp.findAllPiste();
        return iPiste.findAllPiste();
    }

    @GetMapping("/getbyidPiste/{id}")
    public Piste findByIdPiste(@PathVariable long id){ //@PathVariable cuz we pass the id in paramete to the path / when we passe just a variable
        //return PisteServiceImp.findByIdPiste(id);
        return iPiste.findByIdPiste(id);
    }

    @DeleteMapping("/deletePiste/{id}")
    public void deleteById(@PathVariable long id){
        //PisteServiceImp.deletePiste(id);
        iPiste.deletePiste(id);
    }
}
