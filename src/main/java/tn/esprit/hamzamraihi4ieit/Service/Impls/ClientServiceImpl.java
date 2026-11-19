package tn.esprit.hamzamraihi4ieit.Service.Impls;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.hamzamraihi4ieit.Repository.IClientRepository;
import tn.esprit.hamzamraihi4ieit.Service.IClientServices;
import tn.esprit.hamzamraihi4ieit.domaine.Client;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IClientServices {

    private final IClientRepository iClientRepository;

    @Override
    public Client getById(long id) {
        return iClientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("client not found"));
    }

    @Override
    public Client add(Client client) {
        return iClientRepository.save(client);
    }

    @Override
    public Client update(Client client) {
        return iClientRepository.save(client);
    }

    @Override
    public void deleteById(Long id) {
        iClientRepository.deleteById(id);
    }

    @Override
    public List<Client> findAll() {
        return iClientRepository.findAll();
    }
}
