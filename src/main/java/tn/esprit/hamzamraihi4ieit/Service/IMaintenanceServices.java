package tn.esprit.hamzamraihi4ieit.Service;

import tn.esprit.hamzamraihi4ieit.domaine.Maintenance;

import java.util.List;

public interface IMaintenanceServices {
    Maintenance getById(int id);
    Maintenance add(Maintenance maintenance);
    Maintenance update(Maintenance maintenance);
    void deleteById(Integer id);
    List<Maintenance> findAll();
}
