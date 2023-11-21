package tn.esprit.gestionski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.entities.Support;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription,Long> {
//    @Query("select i.numSemaine from Inscription i " +
//    "JOIN Moniteur m"+
//    " on i.cours member m.coursList" +
//    " where i.numInscription = :numInstructor and i.cours.support =: support ")
//    List<Integer> numWeeksCourseOfInstructorBySupport(@Param("numInstructor") Long numInstructor,@Param("support") Support support);

@Query("select ins.numSemaine from Inscription ins " +
        "JOIN  Moniteur mon " +
        "on ins.cours member of mon.coursList " +
        "where mon.numMoniteur = :numInstructor and ins.cours.support = :support ")
List<Integer> numWeeksCourseOfInstructorBySupport(@Param("numInstructor") Long numInstructor, @Param("support") Support support);
}
