package tn.esprit.hamzamraihi4ieit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.hamzamraihi4ieit.domaine.Agence;

public interface IAgenceRepository extends JpaRepository<Agence, Long> {
}
