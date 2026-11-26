package tn.esprit.hamzamraihi4ieit.WebController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.hamzamraihi4ieit.Service.IReservationServices;
import tn.esprit.hamzamraihi4ieit.domaine.Reservation;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "Reservation", description = "Gestion des reservations")
@RestController
@RequestMapping("reservation")
@RequiredArgsConstructor
public class ReservationRestController {

    private final IReservationServices reservationServices;

    @Operation(summary = "Ajouter une reservation")
    @PostMapping("add")
    public Reservation create(@RequestBody Reservation reservation) {
        return reservationServices.add(reservation);
    }

    @Operation(summary = "Lister les reservations")
    @GetMapping("all")
    public List<Reservation> getAll() {
        return reservationServices.findAll();
    }

    @Operation(summary = "Afficher une reservation par son id")
    @GetMapping("get/{id}")
    public Reservation getById(@PathVariable int id) {
        return reservationServices.getById(id);
    }

    @Operation(summary = "Modifier une reservation")
    @PutMapping("update")
    public Reservation update(@RequestBody Reservation reservation) {
        return reservationServices.update(reservation);
    }

    @Operation(summary = "Supprimer une reservation par son id")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id) {
        reservationServices.deleteById(id);
    }



    @GetMapping("/date/{date}")
    public List<Reservation> getByDate(@PathVariable LocalDate date) {
        return reservationServices.affichereservationpardate(date);
    }


}
