package tn.esprit.hamzamraihi4ieit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.hamzamraihi4ieit.domaine.Reservation;

public interface IReservationRepository extends JpaRepository<Reservation, Integer> {
}
