package tn.esprit.hamzamraihi4ieit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.hamzamraihi4ieit.domaine.Equipements;

public interface IEquipementsRepository extends JpaRepository<Equipements, Long> {
}
