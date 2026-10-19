package tn.esprit.hamzamraihi4ieit.Service.Impls;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.hamzamraihi4ieit.Repository.IVehiculeRepository;
import tn.esprit.hamzamraihi4ieit.Service.IVehiculeServices;
import tn.esprit.hamzamraihi4ieit.domaine.vehicule;

import java.util.List;
@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehiculeServices {

    private final IVehiculeRepository iVehiculeRepository;

    @Override
    public vehicule getById(long id) {
        return iVehiculeRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("vehicule not found"));
    }

    @Override
    public vehicule add(vehicule vehicule) {
        return iVehiculeRepository.save(vehicule);
    }

    @Override
    public vehicule update(vehicule vehicule) {
        return iVehiculeRepository.save(vehicule);
    }

    @Override
    public void deleteById(Long id) {
        iVehiculeRepository.deleteById(id);

    }

    @Override
    public List<vehicule> findAll() {
        return iVehiculeRepository.findAll();
    }
}
