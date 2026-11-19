package tn.esprit.hamzamraihi4ieit.WebController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.hamzamraihi4ieit.Service.IContratServices;
import tn.esprit.hamzamraihi4ieit.domaine.Contrat;

import java.util.List;

@Tag(name = "Contrat", description = "Gestion des contrats de location")
@RestController
@RequestMapping("contrat")
@RequiredArgsConstructor
public class ContratRestController {

    private final IContratServices contratServices;

    @Operation(summary = "Ajouter un contrat")
    @PostMapping("add")
    public Contrat create(@RequestBody Contrat contrat) {
        return contratServices.add(contrat);
    }

    @Operation(summary = "Lister les contrats")
    @GetMapping("all")
    public List<Contrat> getAll() {
        return contratServices.findAll();
    }

    @Operation(summary = "Afficher un contrat par son id")
    @GetMapping("get/{id}")
    public Contrat getById(@PathVariable long id) {
        return contratServices.getById(id);
    }

    @Operation(summary = "Modifier un contrat")
    @PutMapping("update")
    public Contrat update(@RequestBody Contrat contrat) {
        return contratServices.update(contrat);
    }

    @Operation(summary = "Supprimer un contrat par son id")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        contratServices.deleteById(id);
    }
}
