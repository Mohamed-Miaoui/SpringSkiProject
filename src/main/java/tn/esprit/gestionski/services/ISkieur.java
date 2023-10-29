package tn.esprit.gestionski.services;

import tn.esprit.gestionski.entities.Skieur;

import java.util.List;

public interface ISkieur {
    public Skieur addSkieur(Skieur f);
    public Skieur updateSkieur(Skieur f);
    public List<Skieur> findAllSkieur();
    public Skieur findByIdSkieur(long id);
    public void deleteSkieur(long id);
}
