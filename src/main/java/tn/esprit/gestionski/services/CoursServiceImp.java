package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Cours;
import tn.esprit.gestionski.repositories.CoursRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class CoursServiceImp implements ICours{
    private CoursRepository coursRepository;
    @Override
    public Cours addCours(Cours c) {
        return coursRepository.save(c);
    }

    @Override
    public Cours updateCours(Cours c) {
        return coursRepository.save(c);
    }

    @Override
    public List<Cours> findAllCours() {
        return coursRepository.findAll();
    }

    @Override
    public Cours findByIdCours(long id) {
        return coursRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCours(long id) {
        coursRepository.deleteById(id);
    }
}
