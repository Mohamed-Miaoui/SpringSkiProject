package tn.esprit.gestionski.services;

import org.springframework.data.repository.query.Param;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.entities.Support;

import java.util.List;

public interface Iinscritption {
    public Inscription addInscription(Inscription f);
    public Inscription updateInscription(Inscription f);
    public List<Inscription> findAllInscription();
    public Inscription findByIdInscription(long id);
    public void deleteInscription(long id);
    public Inscription addInscriptionandAssaginSkieur(Inscription inscription , Long idSkieur);
    public Inscription addInscriptionandAssaginCours(Inscription inscription , Long numCours);
    public Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long numSkieur, Long numCours);
    List<Integer> numWeeksCourseOfInstructorBySupport(Long nummoniteur,Support support);
}
