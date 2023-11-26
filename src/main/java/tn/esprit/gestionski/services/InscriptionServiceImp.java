package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.*;
import tn.esprit.gestionski.repositories.CoursRepository;
import tn.esprit.gestionski.repositories.InscriptionRepository;
import tn.esprit.gestionski.repositories.SkieurRepository;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class InscriptionServiceImp implements Iinscritption{

    private InscriptionRepository inscriptionRepository;
    private SkieurRepository skieurRepository;
    private CoursRepository coursRepository;

    @Override
    public Inscription addInscription(Inscription s) {
        return inscriptionRepository.save(s);
    }

    @Override
    public Inscription updateInscription(Inscription s) {
        return inscriptionRepository.save(s);
    }

    @Override
    public List<Inscription> findAllInscription() {
        return inscriptionRepository.findAll();
    }

    @Override
    public Inscription findByIdInscription(long id) {
        return inscriptionRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteInscription(long id) {
        inscriptionRepository.deleteById(id);
    }

    @Override
    public Inscription addInscriptionandAssaginSkieur(Inscription inscription, Long isSkieur) {
        Skieur s =skieurRepository.findById(isSkieur).orElse(null);
        inscription.setSkieur(s);
        return inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription addInscriptionandAssaginCours(Inscription inscription, Long numCours) {
        Cours c = coursRepository.findById(numCours).orElse(null);
        inscription.setCours(c);
        return inscriptionRepository.save(inscription);
    }
    //homework---------------------------------------------------
    @Override
    public Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long numSkieur, Long numCours) {
        Cours c = coursRepository.findById(numCours).orElse(null);
        Skieur sk = skieurRepository.findById(numSkieur).orElse(null);

        Date currentDate = new Date();
        Date birthday =sk.getDateNaissance();
        int age = currentDate.getYear() - birthday.getYear();

        if((c.getTypeCours() == Typecours.COLLECTIF_ENFANT || c.getTypeCours() == Typecours.COLLECTIF_ADULTE) && age >16){
        inscription.setCours(c);
        inscription.setSkieur(sk);
        return inscriptionRepository.save(inscription);
        }else {
            return null;
        }
    }

    @Override
    public List<Integer> numWeeksCourseOfInstructorBySupport(Long nummoniteur, Support support) {
        return inscriptionRepository.numWeeksCourseOfInstructorBySupport(nummoniteur ,support);
    }
}
