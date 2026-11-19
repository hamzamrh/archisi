package tn.esprit.hamzamraihi4ieit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.hamzamraihi4ieit.domaine.Paiment;

public interface IPaimentRepository extends JpaRepository<Paiment, Long> {
}
