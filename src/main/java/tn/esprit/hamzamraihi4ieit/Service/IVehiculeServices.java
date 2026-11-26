package tn.esprit.hamzamraihi4ieit.Service;

import org.springframework.data.repository.query.Param;
import tn.esprit.hamzamraihi4ieit.domaine.Reservation;
import tn.esprit.hamzamraihi4ieit.domaine.categorieVehicule;
import tn.esprit.hamzamraihi4ieit.domaine.vehicule;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface IVehiculeServices {
    vehicule getById(long id);
    vehicule add(vehicule vehicule);
    vehicule update(vehicule vehicule);
    void deleteById(Long id);
    List<vehicule> findAll();
    vehicule assignToAgence(long idVehicule, long idagence);
    vehicule assignTo(long idVehicule, long iddoc);
    vehicule assignToEquipement(long idVehicule, long idEquipement);
    vehicule unassignToAgence(long idVehicule, long idagence);
    vehicule unassignToEquipement(long idVehicule, long idEquipement);
    vehicule addVehiculeAndAssignToAgence(vehicule vehicule, long idagence);
    List<vehicule> getAllBycategorie(categorieVehicule categorie);
    List<vehicule> getAllBycategorieandTarifJournalierBetween(categorieVehicule categorie,BigDecimal min, BigDecimal max);

}
