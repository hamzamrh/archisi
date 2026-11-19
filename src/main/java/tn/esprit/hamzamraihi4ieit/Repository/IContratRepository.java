package tn.esprit.hamzamraihi4ieit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.hamzamraihi4ieit.domaine.Contrat;

public interface IContratRepository extends JpaRepository<Contrat, Long> {
}
