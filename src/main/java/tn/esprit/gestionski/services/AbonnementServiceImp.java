package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.entities.TypeAbonnement;
import tn.esprit.gestionski.repositories.AbonnementRepository;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class AbonnementServiceImp implements IAbonnement{
    AbonnementRepository abonnementRepository;
    SkieurServiceImp skieurServiceImp ;
    @Override
    public Abonnement addAbonnement(Abonnement c) {
        return abonnementRepository.save(c);
    }

    @Override
    public Abonnement updateAbonnement(Abonnement c) {
        return abonnementRepository.save(c);
    }

    @Override
    public List<Abonnement> findAllAbonnement() {
        return abonnementRepository.findAll();
    }

    @Override
    public Abonnement findByIdAbonnement(long id) {
        return abonnementRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteAbonnement(long id) {
        abonnementRepository.deleteById(id);
    }

    @Override
    public List<Abonnement> getAbonnementByTypeAbon(TypeAbonnement typeAbonnement) {
        return abonnementRepository.getAbonnementByTypeAbon(typeAbonnement);
    }

    @Override
    public List<Abonnement> getdateinBetween(Date dateDebut, Date datend) {
        return abonnementRepository.findByDateDebutBetween(dateDebut,datend);
    }

    //Homework-------------------------------
    @Scheduled(fixedRate = 30000)
    @Override
    public void findByDatelessThan7() {
        Date currentDate = new Date();
        List<Abonnement> abonnements = abonnementRepository.findAll();
        for (Abonnement ab : abonnements) {
            Date dateFin = ab.getDateFin();
            Integer dayLeft = dateFin.getDate() - currentDate.getDate();
            if ( dayLeft <= 7 && dayLeft >0){
                log.info(" the subscription : "+ ab + " the owner id  : "+ skieurServiceImp.getSkieurByAbbon(ab).getNumSkieur()+ "firstname :" + skieurServiceImp.getSkieurByAbbon(ab).getNomS() +" lastname : "+  skieurServiceImp.getSkieurByAbbon(ab).getPrenomS());
            }
        }

    }
}
