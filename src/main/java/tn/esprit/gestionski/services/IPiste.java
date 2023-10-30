package tn.esprit.gestionski.services;

import tn.esprit.gestionski.entities.Piste;

import java.util.List;

public interface IPiste {
    public Piste addPiste(Piste p);
    public Piste updatePiste(Piste p);
    public List<Piste> findAllPiste();
    public Piste findByIdPiste(long id);
    public void deletePiste(long id);
}
