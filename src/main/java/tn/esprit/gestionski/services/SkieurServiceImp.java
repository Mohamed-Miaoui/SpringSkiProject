package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.*;
import tn.esprit.gestionski.repositories.CoursRepository;
import tn.esprit.gestionski.repositories.InscriptionRepository;
import tn.esprit.gestionski.repositories.PisteRepository;
import tn.esprit.gestionski.repositories.SkieurRepository;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class SkieurServiceImp implements ISkieur{

    private SkieurRepository skieurRepository;
    private PisteRepository pisteRepository;
    private CoursRepository coursRepository;
    private InscriptionRepository inscriptionRepository;
    private List<Piste> pistes;
    @Override
    public Skieur addSkieur(Skieur s) {
        return skieurRepository.save(s);
    }


    @Override
    public Skieur updateSkieur(Skieur s) {
        return skieurRepository.save(s);
    }

    @Override
    public List<Skieur> findAllSkieur() {
        return skieurRepository.findAll();
    }

    @Override
    public Skieur findByIdSkieur(long id) {
        return skieurRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteSkieur(long id) {
        skieurRepository.deleteById(id);
    }

    @Override
    public Skieur assignSkierToPiste(Long numSkieur, Long numPiste) {
        Piste piste = pisteRepository.getReferenceById(numPiste);
        pistes.add(piste);
        Skieur skieur =skieurRepository.findById(numSkieur).orElse(null);
        skieur.setListPiste(pistes);
        skieurRepository.save(skieur);
        return null;
    }

    @Override
    public Skieur assignSkierToCour(Skieur skieur, Long numCour) {
        Skieur savedSkieur =  skieurRepository.save(skieur);
        Cours cours = coursRepository.findById(numCour).orElse(null);
        List<Inscription> inscriptions =savedSkieur.getInscriptions();
        for ( Inscription i  : inscriptions ){
            i.setSkieur(savedSkieur);
            i.setCours(cours);
            inscriptionRepository.save(i);
        }
        return savedSkieur;
    }

    @Override
    public List<Skieur> retreiveSkieurByTypeAbonnement(TypeAbonnement typeAbonnement) {
        return skieurRepository.findByAbonnement_TypeAbon(typeAbonnement);
    }
//    @Scheduled(fixedRate = 30000)
//    public  void fixedRate(){
//        log.info("methode with fixed rate");
//    }
//    @Scheduled(cron = "0 34 16 * * *")
//    public  void cronMethode(){
//        log.info("methode with Cron");
//    }

}
