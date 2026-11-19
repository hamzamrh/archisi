package tn.esprit.hamzamraihi4ieit.WebController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.hamzamraihi4ieit.Service.IPaimentServices;
import tn.esprit.hamzamraihi4ieit.domaine.Paiment;

import java.util.List;

@Tag(name = "Paiement", description = "Gestion des paiements des contrats")
@RestController
@RequestMapping("paiment")
@RequiredArgsConstructor
public class PaimentRestController {

    private final IPaimentServices paimentServices;

    @Operation(summary = "Ajouter un paiement")
    @PostMapping("add")
    public Paiment create(@RequestBody Paiment paiment) {
        return paimentServices.add(paiment);
    }

    @Operation(summary = "Lister les paiements")
    @GetMapping("all")
    public List<Paiment> getAll() {
        return paimentServices.findAll();
    }

    @Operation(summary = "Afficher un paiement par son id")
    @GetMapping("get/{id}")
    public Paiment getById(@PathVariable long id) {
        return paimentServices.getById(id);
    }

    @Operation(summary = "Modifier un paiement")
    @PutMapping("update")
    public Paiment update(@RequestBody Paiment paiment) {
        return paimentServices.update(paiment);
    }

    @Operation(summary = "Supprimer un paiement par son id")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        paimentServices.deleteById(id);
    }
}
