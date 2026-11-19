package tn.esprit.hamzamraihi4ieit.Service;

import tn.esprit.hamzamraihi4ieit.domaine.Contrat;

import java.util.List;

public interface IContratServices {
    Contrat getById(long id);
    Contrat add(Contrat contrat);
    Contrat update(Contrat contrat);
    void deleteById(Long id);
    List<Contrat> findAll();
}
