package tn.esprit.gestionski.services;

import tn.esprit.gestionski.entities.Inscription;

import java.util.List;

public interface Iinscritption {
    public Inscription addInscription(Inscription f);
    public Inscription updateInscription(Inscription f);
    public List<Inscription> findAllInscription();
    public Inscription findByIdInscription(long id);
    public void deleteInscription(long id);
}
