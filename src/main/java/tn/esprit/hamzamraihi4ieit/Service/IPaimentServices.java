package tn.esprit.hamzamraihi4ieit.Service;

import tn.esprit.hamzamraihi4ieit.domaine.Paiment;

import java.util.List;

public interface IPaimentServices {
    Paiment getById(long id);
    Paiment add(Paiment paiment);
    Paiment update(Paiment paiment);
    void deleteById(Long id);
    List<Paiment> findAll();
}
