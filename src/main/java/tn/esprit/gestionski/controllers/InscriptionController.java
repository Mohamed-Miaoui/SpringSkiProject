package tn.esprit.gestionski.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.services.InscriptionServiceImp;

import java.util.List;

@AllArgsConstructor
@RestController
public class InscriptionController {
    private InscriptionServiceImp InscriptionServiceImp;

    @PostMapping("/addInscription")
    public Inscription addInscription(@RequestBody Inscription f){ // @RequestBody when we pass object
        return InscriptionServiceImp.addInscription(f);
    }

    @PutMapping("/update")
    public Inscription updateInscription(@RequestBody Inscription f){
        return InscriptionServiceImp.updateInscription(f);
    }

    @GetMapping("/getall")
    public List<Inscription> findAllInscription(){
        return InscriptionServiceImp.findAllInscription();
    }

    @GetMapping("/getbyid/{id}")
    public Inscription findByIdInscription(@PathVariable long id){ //@PathVariable cuz we pass the id in paramete to the path / when we passe just a variable
        return InscriptionServiceImp.findByIdInscription(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){
        InscriptionServiceImp.deleteInscription(id);
    }

}
