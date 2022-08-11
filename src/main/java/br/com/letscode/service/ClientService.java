package br.com.letscode.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.letscode.model.Client;

@Path("/client/list")
@RegisterRestClient
public interface ClientService {

    @GET
    @javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
    public List<Client> getList();

}
