package tn.esprit.gestionski.services;

import tn.esprit.gestionski.entities.Skieur;

import java.util.List;

public interface ISkieur {
    public Skieur addSkieur(Skieur s);
    public Skieur updateSkieur(Skieur s);
    public List<Skieur> findAllSkieur();
    public Skieur findByIdSkieur(long id);
    public void deleteSkieur(long id);
    public Skieur assignSkierToPiste(Long numSkieur, Long numPiste);

    public Skieur assignSkierToCour(Skieur skieur, Long numCour);

}
