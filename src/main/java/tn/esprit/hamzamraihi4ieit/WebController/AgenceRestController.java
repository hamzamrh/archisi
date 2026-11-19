package tn.esprit.hamzamraihi4ieit.WebController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.hamzamraihi4ieit.Service.IAgenceServices;
import tn.esprit.hamzamraihi4ieit.domaine.Agence;

import java.util.List;

@Tag(name = "Agence", description = "Gestion des agences")
@RestController
@RequestMapping("agence")
@RequiredArgsConstructor
public class AgenceRestController {

    private final IAgenceServices agenceServices;

    @Operation(summary = "Ajouter une agence")
    @PostMapping("add")
    public Agence create(@RequestBody Agence agence) {
        return agenceServices.add(agence);
    }

    @Operation(summary = "Lister les agences")
    @GetMapping("all")
    public List<Agence> getAll() {
        return agenceServices.findAll();
    }

    @Operation(summary = "Afficher une agence par son id")
    @GetMapping("get/{id}")
    public Agence getById(@PathVariable long id) {
        return agenceServices.getById(id);
    }

    @Operation(summary = "Modifier une agence")
    @PutMapping("update")
    public Agence update(@RequestBody Agence agence) {
        return agenceServices.update(agence);
    }

    @Operation(summary = "Supprimer une agence par son id")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        agenceServices.deleteById(id);
    }
}
