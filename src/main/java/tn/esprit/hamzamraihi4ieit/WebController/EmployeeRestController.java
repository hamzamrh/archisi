package tn.esprit.hamzamraihi4ieit.WebController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.hamzamraihi4ieit.Service.IEmployeeServices;
import tn.esprit.hamzamraihi4ieit.domaine.Employee;

import java.util.List;

@Tag(name = "Employe", description = "Gestion des employes des agences")
@RestController
@RequestMapping("employee")
@RequiredArgsConstructor
public class EmployeeRestController {

    private final IEmployeeServices employeeServices;

    @Operation(summary = "Ajouter un employe")
    @PostMapping("add")
    public Employee create(@RequestBody Employee employee) {
        return employeeServices.add(employee);
    }

    @Operation(summary = "Lister les employes")
    @GetMapping("all")
    public List<Employee> getAll() {
        return employeeServices.findAll();
    }

    @Operation(summary = "Afficher un employe par son id")
    @GetMapping("get/{id}")
    public Employee getById(@PathVariable long id) {
        return employeeServices.getById(id);
    }

    @Operation(summary = "Modifier un employe")
    @PutMapping("update")
    public Employee update(@RequestBody Employee employee) {
        return employeeServices.update(employee);
    }

    @Operation(summary = "Supprimer un employe par son id")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        employeeServices.deleteById(id);
    }
}
