package tn.esprit.hamzamraihi4ieit.Service.Impls;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.hamzamraihi4ieit.Repository.IMaintenanceRepository;
import tn.esprit.hamzamraihi4ieit.Service.IMaintenanceServices;
import tn.esprit.hamzamraihi4ieit.domaine.Maintenance;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImpl implements IMaintenanceServices {

    private final IMaintenanceRepository iMaintenanceRepository;

    @Override
    public Maintenance getById(int id) {
        return iMaintenanceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("maintenance not found"));
    }

    @Override
    public Maintenance add(Maintenance maintenance) {
        return iMaintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance update(Maintenance maintenance) {
        return iMaintenanceRepository.save(maintenance);
    }

    @Override
    public void deleteById(Integer id) {
        iMaintenanceRepository.deleteById(id);
    }

    @Override
    public List<Maintenance> findAll() {
        return iMaintenanceRepository.findAll();
    }
}
