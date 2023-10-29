package tn.esprit.gestionski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Skieur;

public interface InscriptionRepository extends JpaRepository<Inscription,Long> {
}
