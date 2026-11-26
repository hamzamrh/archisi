package tn.esprit.hamzamraihi4ieit.WebController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.hamzamraihi4ieit.Service.IVehiculeServices;
import tn.esprit.hamzamraihi4ieit.domaine.categorieVehicule;
import tn.esprit.hamzamraihi4ieit.domaine.vehicule;

import java.math.BigDecimal;
import java.util.List;

@Tag(name = "Vehicule", description = "Gestion de la flotte de vehicules")
@RestController
@RequestMapping("vehicule")
@RequiredArgsConstructor
public class VehiculeRestController {

    private final IVehiculeServices vehiculeServices;
    private final IVehiculeServices iVehiculeServices;

    @Operation(summary = "Ajouter un vehicule")
    @PostMapping("add")
    public vehicule create(@RequestBody vehicule vehicule) {
        return vehiculeServices.add(vehicule);
    }

    @Operation(summary = "Lister les vehicules")
    @GetMapping("all")
    public List<vehicule> getAll() {
        return vehiculeServices.findAll();
    }

    @Operation(summary = "Afficher un vehicule par son id")
    @GetMapping("get/{id}")
    public vehicule getById(@PathVariable long id) {
        return vehiculeServices.getById(id);
    }

    @Operation(summary = "Modifier un vehicule")
    @PutMapping("update")
    public vehicule update(@RequestBody vehicule vehicule) {
        return vehiculeServices.update(vehicule);
    }

    @Operation(summary = "Supprimer un vehicule par son id")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        vehiculeServices.deleteById(id);
    }

    @PutMapping("/{idVehicule}/{idAgence}")
    vehicule assignToAgence(@PathVariable long idVehicule, @PathVariable long idAgence) {
        return iVehiculeServices.assignToAgence(idVehicule, idAgence);
    }

    @PutMapping("/assignToEquipement/{idVehicule}/{idEquipement}")
    vehicule assignToEquipement(@PathVariable long idVehicule, @PathVariable long idEquipement) {
        return iVehiculeServices.assignToEquipement(idVehicule, idEquipement);
    }
    @PutMapping("/unassignToAgence/{idVehicule}/{idAgence}")
    vehicule unassignToAgence(@PathVariable long idVehicule, @PathVariable long idAgence) {
        return iVehiculeServices.unassignToAgence(idVehicule, idAgence);
    }

    @PutMapping("/unassignToEquipement/{idVehicule}/{idEquipement}")
    vehicule unassignToEquipement(@PathVariable long idVehicule, @PathVariable long idEquipement) {
        return iVehiculeServices.unassignToEquipement(idVehicule, idEquipement);
    }

    @PostMapping("/addVehiculeAndAssignToAgence/{idAgence}")
    vehicule addVehiculeAndAssignToAgence(@RequestBody vehicule vehicule, @PathVariable long idAgence) {
        return iVehiculeServices.addVehiculeAndAssignToAgence(vehicule, idAgence);
    }
    @GetMapping("Listbycateg/{categorie}")
    List<vehicule> afficherVehicules(@PathVariable categorieVehicule categorie) {
        return iVehiculeServices.getAllBycategorie(categorie);
    }
    @GetMapping("ListbycategAndtarif/{categorie}/{min}/{max}")
    List<vehicule> afficherVehiculesPartarif(@PathVariable categorieVehicule categorie, BigDecimal min, BigDecimal max) {
        return iVehiculeServices.getAllBycategorieandTarifJournalierBetween(categorie, min, max);
    }
}
