package br.com.letscode.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.letscode.model.Client;
import br.com.letscode.repository.ClientRepository;

@Path("/client/list")
@RegisterRestClient(configKey = "quarkus-api")
public class ClientService {

    @Inject
    ClientRepository clientRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Client> geClienttList() {
        return clientRepository.listAll();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertClient(Client client) {
        clientRepository.persist(client);
    }

}
