package tn.esprit.hamzamraihi4ieit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.hamzamraihi4ieit.domaine.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface IReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByClientEmail(String email);

    @Query("""
    SELECT res  
     From Reservation res
     WHERE :d < current_date  
""")
    List<Reservation> affichereservationpardate(@Param("d") LocalDate date);
}
