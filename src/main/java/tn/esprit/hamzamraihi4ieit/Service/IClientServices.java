package tn.esprit.hamzamraihi4ieit.Service;

import tn.esprit.hamzamraihi4ieit.domaine.Client;

import java.util.List;

public interface IClientServices {
    Client getById(long id);
    Client add(Client client);
    Client update(Client client);
    void deleteById(Long id);
    List<Client> findAll();
}
