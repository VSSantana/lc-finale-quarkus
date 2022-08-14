package br.com.letscode.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.letscode.model.Category;
import br.com.letscode.model.Client;
import br.com.letscode.repository.CategoryRepository;
import br.com.letscode.repository.ClientRepository;

@Path("/client")
@RegisterRestClient(configKey = "quarkus-api")
public class ClientService {

    @Inject
    ClientRepository clientRepository;
    @Inject
    CategoryRepository categoryRepository;

    public List<Client> geClientList() {
        return clientRepository.listAll();
    }

    public Optional<Client> getClient(Long id) {
        Optional<Client> optionalClient = clientRepository.findByIdOptional(id);
        return optionalClient;
    }

    @Transactional
    public Client insertClient(Client client) {
        Optional<Category> category = categoryRepository.findByIdOptional(client.getIdCategory());
        if (category.isPresent()) {
            clientRepository.persist(client);
            return client;
        }
        return null;
    }

    @Transactional
    public Client alterClient(Long id, Client clientForm) {
        Optional<Client> optionalClient = clientRepository.findByIdOptional(id);
        Optional<Category> category = categoryRepository.findByIdOptional(clientForm.getIdCategory());
        if (optionalClient.isPresent() && category.isPresent()) {
            optionalClient.get().setName(clientForm.getName());
            optionalClient.get().setAge(clientForm.getAge());
            optionalClient.get().setVatNumber(clientForm.getVatNumber());
            optionalClient.get().setEmail(clientForm.getEmail());
            optionalClient.get().setIdCategory(clientForm.getIdCategory());
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
