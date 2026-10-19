package tn.esprit.hamzamraihi4ieit.WebController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.hamzamraihi4ieit.Service.IVehiculeServices;
import tn.esprit.hamzamraihi4ieit.domaine.vehicule;
@RestController
@RequestMapping("vehicule")
@RequiredArgsConstructor

public class VehiculeRestController {
    private final IVehiculeServices vehiculeServices;
    @PostMapping("add")
    public vehicule create(@RequestBody vehicule vehicule){
        return vehiculeServices.add(vehicule);
    }
}
