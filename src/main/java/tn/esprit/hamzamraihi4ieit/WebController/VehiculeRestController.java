package tn.esprit.hamzamraihi4ieit.WebController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.hamzamraihi4ieit.Service.IVehiculeServices;
import tn.esprit.hamzamraihi4ieit.domaine.vehicule;

import java.util.List;

@Tag(name = "Vehicule", description = "Gestion de la flotte de vehicules")
@RestController
@RequestMapping("vehicule")
@RequiredArgsConstructor
public class VehiculeRestController {

    private final IVehiculeServices vehiculeServices;

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
    public vehicule getById(@PathVariable("id") long id) {
        return vehiculeServices.getById(id);
    }

    @Operation(summary = "Modifier un vehicule")
    @PutMapping("update")
    public vehicule update(@RequestBody vehicule vehicule) {
        return vehiculeServices.update(vehicule);
    }

    @Operation(summary = "Supprimer un vehicule par son id")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        vehiculeServices.deleteById(id);
    }
}
