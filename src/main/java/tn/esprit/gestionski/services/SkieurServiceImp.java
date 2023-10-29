package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.repositories.SkieurRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class SkieurServiceImp implements ISkieur{

    private SkieurRepository skieurRepository;
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

}
