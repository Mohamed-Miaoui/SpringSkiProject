package tn.esprit.gestionski.services;

import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.entities.TypeAbonnement;

import java.util.Date;
import java.util.List;

public interface IAbonnement {
    public Abonnement addAbonnement(Abonnement c);
    public Abonnement updateAbonnement(Abonnement c);
    public List<Abonnement> findAllAbonnement();
    public Abonnement findByIdAbonnement(long id);
    public void deleteAbonnement(long id);
    List<Abonnement> getAbonnementByTypeAbon(TypeAbonnement typeAbonnement);
    List<Abonnement> getdateinBetween(Date dateDebut , Date datend);
}
