package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Cours;
import tn.esprit.gestionski.entities.Moniteur;
import tn.esprit.gestionski.repositories.CoursRepository;
import tn.esprit.gestionski.repositories.MoniteurRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class MoniteurServiceImp implements IMoniteur{
    CoursRepository coursRepository ;
    MoniteurRepository moniteurRepository;
    @Override
    public Moniteur addMoniteurAndassaginToCours(Moniteur m, long numCour) {
        Cours cours = coursRepository.findById(numCour).orElse(null);
        List<Cours> coursList =new ArrayList<>();
        coursList.add(cours);
        m.setCoursList(coursList);
        return moniteurRepository.save(m);
    }
}
