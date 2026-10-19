package tn.esprit.hamzamraihi4ieit.Service;

import tn.esprit.hamzamraihi4ieit.domaine.vehicule;

import java.util.List;

public interface IVehiculeServices {
    vehicule getById(long id);
    vehicule add(vehicule vehicule);
    vehicule update(vehicule vehicule);
    void deleteById(Long id);
    List<vehicule> findAll();
}
