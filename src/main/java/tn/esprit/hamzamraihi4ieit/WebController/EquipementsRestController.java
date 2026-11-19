package tn.esprit.hamzamraihi4ieit.WebController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.hamzamraihi4ieit.Service.IEquipementsServices;
import tn.esprit.hamzamraihi4ieit.domaine.Equipements;

import java.util.List;

@Tag(name = "Equipement", description = "Gestion des equipements des vehicules")
@RestController
@RequestMapping("equipements")
@RequiredArgsConstructor
public class EquipementsRestController {

    private final IEquipementsServices equipementsServices;

    @Operation(summary = "Ajouter un equipement")
    @PostMapping("add")
    public Equipements create(@RequestBody Equipements equipements) {
        return equipementsServices.add(equipements);
    }

    @Operation(summary = "Lister les equipements")
    @GetMapping("all")
    public List<Equipements> getAll() {
        return equipementsServices.findAll();
    }

    @Operation(summary = "Afficher un equipement par son id")
    @GetMapping("get/{id}")
    public Equipements getById(@PathVariable long id) {
        return equipementsServices.getById(id);
    }

    @Operation(summary = "Modifier un equipement")
    @PutMapping("update")
    public Equipements update(@RequestBody Equipements equipements) {
        return equipementsServices.update(equipements);
    }

    @Operation(summary = "Supprimer un equipement par son id")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        equipementsServices.deleteById(id);
    }
}
