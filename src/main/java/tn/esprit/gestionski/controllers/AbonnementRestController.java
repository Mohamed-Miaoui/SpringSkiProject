package tn.esprit.gestionski.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.entities.TypeAbonnement;
import tn.esprit.gestionski.services.IAbonnement;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class AbonnementRestController {
   private IAbonnement iAbonnement;

    @GetMapping("/getAbonnementByTypeAbon/{typeAbonnement}")
    public   List<Abonnement> getAbonnementByTypeAbon(@PathVariable TypeAbonnement typeAbonnement){
        return iAbonnement.getAbonnementByTypeAbon(typeAbonnement);
    }
    @GetMapping("/getdateinBetween/{dateD}/{dateE}")
    public List<Abonnement> getdateinBetween(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateD, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateE){
        return iAbonnement.getdateinBetween(dateD,dateE);
    }



}
