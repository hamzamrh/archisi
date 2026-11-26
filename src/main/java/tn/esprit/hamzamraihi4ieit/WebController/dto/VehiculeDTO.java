package tn.esprit.hamzamraihi4ieit.WebController.dto;

import lombok.Getter;
import lombok.Setter;
import tn.esprit.hamzamraihi4ieit.domaine.categorieVehicule;

import java.math.BigDecimal;

@Setter
@Getter
public class VehiculeDTO {

    private String immatriculation;
    private String marque;
    private String modele;
    private categorieVehicule categorie;
    private BigDecimal tarifJournalier;
    private String nomAgence;
}
