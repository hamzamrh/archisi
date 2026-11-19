package tn.esprit.hamzamraihi4ieit.Service.Impls;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.hamzamraihi4ieit.Repository.IReservationRepository;
import tn.esprit.hamzamraihi4ieit.Service.IReservationServices;
import tn.esprit.hamzamraihi4ieit.domaine.Reservation;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservationServices {

    private final IReservationRepository iReservationRepository;

    @Override
    public Reservation getById(int id) {
        return iReservationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("reservation not found"));
    }

    @Override
    public Reservation add(Reservation reservation) {
        return iReservationRepository.save(reservation);
    }

    @Override
    public Reservation update(Reservation reservation) {
        return iReservationRepository.save(reservation);
    }

    @Override
    public void deleteById(Integer id) {
        iReservationRepository.deleteById(id);
    }

    @Override
    public List<Reservation> findAll() {
        return iReservationRepository.findAll();
    }
}
