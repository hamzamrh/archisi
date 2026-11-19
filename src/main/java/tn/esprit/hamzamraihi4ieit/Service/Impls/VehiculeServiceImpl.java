package tn.esprit.hamzamraihi4ieit.Service.Impls;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.hamzamraihi4ieit.Repository.IAgenceRepository;
import tn.esprit.hamzamraihi4ieit.Repository.IEquipementsRepository;
import tn.esprit.hamzamraihi4ieit.Repository.IVehiculeRepository;
import tn.esprit.hamzamraihi4ieit.Service.IVehiculeServices;
import tn.esprit.hamzamraihi4ieit.domaine.Agence;
import tn.esprit.hamzamraihi4ieit.domaine.Equipements;
import tn.esprit.hamzamraihi4ieit.domaine.vehicule;

import java.util.List;
@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehiculeServices {

    private final IVehiculeRepository iVehiculeRepository;
    private final IAgenceRepository iAgenceRepository;
    private final IEquipementsRepository iEquipementsRepository;


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

    @Override
    public vehicule assignToAgence(long idVehicule, long idagence) {
        vehicule vehicule = iVehiculeRepository.findById(idVehicule).orElseThrow(() -> new EntityNotFoundException("vehicule not found"));
        Agence agence = iAgenceRepository.findById(idagence).orElseThrow(() -> new EntityNotFoundException("agence not found"));
        vehicule.setAgence(agence);
        return iVehiculeRepository.save(vehicule);
    }

    @Override
    public vehicule assignTo(long idVehicule, long iddoc) {
        return null;
    }


    @Override
    public vehicule assignToEquipement(long idVehicule, long idEquipement) {
        vehicule vehicule = iVehiculeRepository.findById(idVehicule).orElseThrow(() -> new EntityNotFoundException("vehicule not found"));
        Equipements equipement = iEquipementsRepository.findById(idEquipement).orElseThrow(() -> new EntityNotFoundException("Équipement not found"));
        vehicule.getEquipements().add(equipement);
        return iVehiculeRepository.save(vehicule);
    }

    @Override
    public vehicule unassignToAgence(long idVehicule, long idagence) {
        vehicule vehicule = iVehiculeRepository.findById(idVehicule).orElseThrow(() -> new EntityNotFoundException("vehicule not found"));
        Agence agence = iAgenceRepository.findById(idagence).orElseThrow(() -> new EntityNotFoundException("agence not found"));
        if (vehicule.getAgence() == null) {
            throw new IllegalStateException("vehicule n'est affecte a aucune agence");
        }
        if (vehicule.getAgence().getIdAgence() != agence.getIdAgence()) {
            throw new IllegalStateException("vehicule n'est pas affecte a cette agence");
        }
        vehicule.setAgence(null);
        return iVehiculeRepository.save(vehicule);
    }

    @Override
    public vehicule unassignToEquipement(long idVehicule, long idEquipement) {
        vehicule vehicule = iVehiculeRepository.findById(idVehicule).orElseThrow(() -> new EntityNotFoundException("vehicule not found"));
        Equipements equipement = iEquipementsRepository.findById(idEquipement).orElseThrow(() -> new EntityNotFoundException("Équipement not found"));
        vehicule.getEquipements().remove(equipement);
        return iVehiculeRepository.save(vehicule);
    }


}
