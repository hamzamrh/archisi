package tn.esprit.hamzamraihi4ieit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.hamzamraihi4ieit.domaine.Reservation;
import tn.esprit.hamzamraihi4ieit.domaine.categorieVehicule;
import tn.esprit.hamzamraihi4ieit.domaine.vehicule;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface IVehiculeRepository  extends JpaRepository<vehicule,Long> {
    List<vehicule> findByCategorie(categorieVehicule categorie);
    List<vehicule> findByCategorieAndTarifJournalierBetween(categorieVehicule categorie, BigDecimal min, BigDecimal max );

}
