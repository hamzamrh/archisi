package tn.esprit.hamzamraihi4ieit.Service;

import org.springframework.data.repository.query.Param;
import tn.esprit.hamzamraihi4ieit.domaine.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface IReservationServices {
    Reservation getById(int id);
    Reservation add(Reservation reservation);
    Reservation update(Reservation reservation);
    void deleteById(Integer id);
    List<Reservation> findAll();
    List<Reservation> affichereservationpardate(@Param("d") LocalDate date);
}
