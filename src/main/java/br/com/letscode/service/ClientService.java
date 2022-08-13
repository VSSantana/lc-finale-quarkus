package br.com.letscode.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.letscode.model.Client;
import br.com.letscode.repository.ClientRepository;

@Path("/client")
@RegisterRestClient(configKey = "quarkus-api")
public class ClientService {

    @Inject
    ClientRepository clientRepository;

    public List<Client> geClientList() {
        return clientRepository.listAll();
    }

    public Optional<Client> getClient(Long id) {
        Optional<Client> optionalClient = clientRepository.findByIdOptional(id);
        return optionalClient;
    }

    @Transactional
    public Client insertClient(Client client) {
        clientRepository.persist(client);
        return client;
    }

    @Transactional
    public Client alterClient(Long id, Client clientForm) {
        Optional<Client> optionalClient = clientRepository.findByIdOptional(id);
        if (optionalClient.isPresent()) {
            optionalClient.get().setName(clientForm.getName());
            optionalClient.get().setAge(clientForm.getAge());
            optionalClient.get().setVatnumber(clientForm.getVatnumber());
            optionalClient.get().setEmail(clientForm.getEmail());
            return optionalClient.get();
        }
        return null;
    }

    @Transactional
    public Client deleteClient(Long id) {
        Optional<Client> optionalClient = clientRepository.findByIdOptional(id);
        if (optionalClient.isPresent()) {
            clientRepository.deleteById(id);
            return optionalClient.get();
        }
        return null;
    }

}
