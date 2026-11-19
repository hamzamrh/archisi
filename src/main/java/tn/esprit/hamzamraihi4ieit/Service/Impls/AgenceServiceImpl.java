package tn.esprit.hamzamraihi4ieit.Service.Impls;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.hamzamraihi4ieit.Repository.IAgenceRepository;
import tn.esprit.hamzamraihi4ieit.Service.IAgenceServices;
import tn.esprit.hamzamraihi4ieit.domaine.Agence;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgenceServiceImpl implements IAgenceServices {

    private final IAgenceRepository iAgenceRepository;

    @Override
    public Agence getById(long id) {
        return iAgenceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("agence not found"));
    }

    @Override
    public Agence add(Agence agence) {
        return iAgenceRepository.save(agence);
    }

    @Override
    public Agence update(Agence agence) {
        return iAgenceRepository.save(agence);
    }

    @Override
    public void deleteById(Long id) {
        iAgenceRepository.deleteById(id);
    }

    @Override
    public List<Agence> findAll() {
        return iAgenceRepository.findAll();
    }
}
