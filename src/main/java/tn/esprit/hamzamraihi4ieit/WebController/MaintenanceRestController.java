package tn.esprit.hamzamraihi4ieit.WebController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.hamzamraihi4ieit.Service.IMaintenanceServices;
import tn.esprit.hamzamraihi4ieit.domaine.Maintenance;

import java.util.List;

@Tag(name = "Maintenance", description = "Gestion des maintenances des vehicules")
@RestController
@RequestMapping("maintenance")
@RequiredArgsConstructor
public class MaintenanceRestController {

    private final IMaintenanceServices maintenanceServices;

    @Operation(summary = "Ajouter une maintenance")
    @PostMapping("add")
    public Maintenance create(@RequestBody Maintenance maintenance) {
        return maintenanceServices.add(maintenance);
    }

    @Operation(summary = "Lister les maintenances")
    @GetMapping("all")
    public List<Maintenance> getAll() {
        return maintenanceServices.findAll();
    }

    @Operation(summary = "Afficher une maintenance par son id")
    @GetMapping("get/{id}")
    public Maintenance getById(@PathVariable int id) {
        return maintenanceServices.getById(id);
    }

    @Operation(summary = "Modifier une maintenance")
    @PutMapping("update")
    public Maintenance update(@RequestBody Maintenance maintenance) {
        return maintenanceServices.update(maintenance);
    }

    @Operation(summary = "Supprimer une maintenance par son id")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id) {
        maintenanceServices.deleteById(id);
    }
}
