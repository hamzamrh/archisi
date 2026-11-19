package tn.esprit.hamzamraihi4ieit.Service;

import tn.esprit.hamzamraihi4ieit.domaine.Reservation;

import java.util.List;

public interface IReservationServices {
    Reservation getById(int id);
    Reservation add(Reservation reservation);
    Reservation update(Reservation reservation);
    void deleteById(Integer id);
    List<Reservation> findAll();
}
