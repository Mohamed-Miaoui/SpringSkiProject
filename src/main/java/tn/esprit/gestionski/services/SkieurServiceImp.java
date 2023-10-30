package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Piste;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.repositories.PisteRepository;
import tn.esprit.gestionski.repositories.SkieurRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class SkieurServiceImp implements ISkieur{

    private SkieurRepository skieurRepository;
    private PisteRepository pisteRepository;
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

}
