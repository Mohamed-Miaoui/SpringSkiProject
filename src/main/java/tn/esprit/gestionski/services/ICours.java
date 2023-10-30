package tn.esprit.gestionski.services;

import tn.esprit.gestionski.entities.Cours;

import java.util.List;

public interface ICours {

    public Cours addCours(Cours c);
    public Cours updateCours(Cours c);
    public List<Cours> findAllCours();
    public Cours findByIdCours(long id);
    public void deleteCours(long id);
}
