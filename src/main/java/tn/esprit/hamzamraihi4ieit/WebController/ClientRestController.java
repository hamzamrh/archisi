package tn.esprit.hamzamraihi4ieit.WebController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.hamzamraihi4ieit.Service.IClientServices;
import tn.esprit.hamzamraihi4ieit.domaine.Client;

import java.util.List;

@Tag(name = "Client", description = "Gestion des clients")
@RestController
@RequestMapping("client")
@RequiredArgsConstructor
public class ClientRestController {

    private final IClientServices clientServices;

    @Operation(summary = "Ajouter un client")
    @PostMapping("add")
    public Client create(@RequestBody Client client) {
        return clientServices.add(client);
    }

    @Operation(summary = "Lister les clients")
    @GetMapping("all")
    public List<Client> getAll() {
        return clientServices.findAll();
    }

    @Operation(summary = "Afficher un client par son id")
    @GetMapping("get/{id}")
    public Client getById(@PathVariable long id) {
        return clientServices.getById(id);
    }

    @Operation(summary = "Modifier un client")
    @PutMapping("update")
    public Client update(@RequestBody Client client) {
        return clientServices.update(client);
    }

    @Operation(summary = "Supprimer un client par son id")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        clientServices.deleteById(id);
    }
}
