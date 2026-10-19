package tn.esprit.hamzamraihi4ieit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.hamzamraihi4ieit.domaine.vehicule;

public interface IVehiculeRepository  extends JpaRepository<vehicule,Long> {
}
