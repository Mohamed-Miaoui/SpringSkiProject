package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.repositories.InscriptionRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class InscriptionServiceImp implements Iinscritption{

    private InscriptionRepository InscriptionRepository;
    @Override
    public Inscription addInscription(Inscription s) {
        return InscriptionRepository.save(s);
    }
//    public Inscription addInscriptionavecid(Inscription s,Long id) {
//        return InscriptionRepository.save(s);
//    }

    @Override
    public Inscription updateInscription(Inscription s) {
        return InscriptionRepository.save(s);
    }

    @Override
    public List<Inscription> findAllInscription() {
        return InscriptionRepository.findAll();
    }

    @Override
    public Inscription findByIdInscription(long id) {
        return InscriptionRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteInscription(long id) {
        InscriptionRepository.deleteById(id);
    }
}
