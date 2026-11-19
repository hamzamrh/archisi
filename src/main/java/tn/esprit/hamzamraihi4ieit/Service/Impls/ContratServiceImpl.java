package tn.esprit.hamzamraihi4ieit.Service.Impls;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.hamzamraihi4ieit.Repository.IContratRepository;
import tn.esprit.hamzamraihi4ieit.Service.IContratServices;
import tn.esprit.hamzamraihi4ieit.domaine.Contrat;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratServiceImpl implements IContratServices {

    private final IContratRepository iContratRepository;

    @Override
    public Contrat getById(long id) {
        return iContratRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("contrat not found"));
    }

    @Override
    public Contrat add(Contrat contrat) {
        return iContratRepository.save(contrat);
    }

    @Override
    public Contrat update(Contrat contrat) {
        return iContratRepository.save(contrat);
    }

    @Override
    public void deleteById(Long id) {
        iContratRepository.deleteById(id);
    }

    @Override
    public List<Contrat> findAll() {
        return iContratRepository.findAll();
    }
}
