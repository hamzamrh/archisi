package tn.esprit.hamzamraihi4ieit.Service;

import tn.esprit.hamzamraihi4ieit.domaine.Equipements;

import java.util.List;

public interface IEquipementsServices {
    Equipements getById(long id);
    Equipements add(Equipements equipements);
    Equipements update(Equipements equipements);
    void deleteById(Long id);
    List<Equipements> findAll();
}
