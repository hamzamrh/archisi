package tn.esprit.hamzamraihi4ieit.Service;

import tn.esprit.hamzamraihi4ieit.domaine.Agence;

import java.util.List;

public interface IAgenceServices {
    Agence getById(long id);
    Agence add(Agence agence);
    Agence update(Agence agence);
    void deleteById(Long id);
    List<Agence> findAll();
}
