package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Piste;
import tn.esprit.gestionski.repositories.PisteRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class PisteServiceImp implements IPiste{
    private PisteRepository pisteRepository;
    @Override
    public Piste addPiste(Piste p) {
        return pisteRepository.save(p);
    }

    @Override
    public Piste updatePiste(Piste p) {
        return pisteRepository.save(p);
    }

    @Override
    public List<Piste> findAllPiste() {
        return pisteRepository.findAll();
    }

    @Override
    public Piste findByIdPiste(long id) {
        return pisteRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePiste(long id) {
        pisteRepository.deleteById(id);

    }
}
