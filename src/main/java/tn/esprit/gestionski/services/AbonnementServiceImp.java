package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.entities.TypeAbonnement;
import tn.esprit.gestionski.repositories.AbonnementRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class AbonnementServiceImp implements IAbonnement{
    AbonnementRepository abonnementRepository;
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

}
