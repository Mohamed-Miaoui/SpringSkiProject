package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Cours;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.repositories.CoursRepository;
import tn.esprit.gestionski.repositories.InscriptionRepository;
import tn.esprit.gestionski.repositories.SkieurRepository;

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
}
