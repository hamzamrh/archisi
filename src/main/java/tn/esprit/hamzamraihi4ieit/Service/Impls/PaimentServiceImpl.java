package tn.esprit.hamzamraihi4ieit.Service.Impls;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.hamzamraihi4ieit.Repository.IPaimentRepository;
import tn.esprit.hamzamraihi4ieit.Service.IPaimentServices;
import tn.esprit.hamzamraihi4ieit.domaine.Paiment;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaimentServiceImpl implements IPaimentServices {

    private final IPaimentRepository iPaimentRepository;

    @Override
    public Paiment getById(long id) {
        return iPaimentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("paiment not found"));
    }

    @Override
    public Paiment add(Paiment paiment) {
        return iPaimentRepository.save(paiment);
    }

    @Override
    public Paiment update(Paiment paiment) {
        return iPaimentRepository.save(paiment);
    }

    @Override
    public void deleteById(Long id) {
        iPaimentRepository.deleteById(id);
    }

    @Override
    public List<Paiment> findAll() {
        return iPaimentRepository.findAll();
    }
}
