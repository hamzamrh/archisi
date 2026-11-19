package tn.esprit.hamzamraihi4ieit.Service.Impls;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.hamzamraihi4ieit.Repository.IEquipementsRepository;
import tn.esprit.hamzamraihi4ieit.Service.IEquipementsServices;
import tn.esprit.hamzamraihi4ieit.domaine.Equipements;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipementsServiceImpl implements IEquipementsServices {

    private final IEquipementsRepository iEquipementsRepository;

    @Override
    public Equipements getById(long id) {
        return iEquipementsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("equipements not found"));
    }

    @Override
    public Equipements add(Equipements equipements) {
        return iEquipementsRepository.save(equipements);
    }

    @Override
    public Equipements update(Equipements equipements) {
        return iEquipementsRepository.save(equipements);
    }

    @Override
    public void deleteById(Long id) {
        iEquipementsRepository.deleteById(id);
    }

    @Override
    public List<Equipements> findAll() {
        return iEquipementsRepository.findAll();
    }
}
