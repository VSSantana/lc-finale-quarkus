package br.com.letscode.rest;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.letscode.dto.ClientDto;
import br.com.letscode.form.ClientForm;
import br.com.letscode.model.Client;
import br.com.letscode.service.ClientService;

@Path("/client")
public class ClienteResource {

    @Inject
    private ClientService clientService;

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ClientDto> getClients() {
        List<Client> clients = clientService.geClientList();
        return ClientDto.convertion(clients);
    }

    @GET
    @Path("/details/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClient(@PathParam("id") Long id) {
        Optional<Client> client = clientService.getClient(id);
        if (client.isPresent()) {
            return Response.ok().entity(new ClientDto(client.get())).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertClient(@Valid ClientForm clientForm) {
        Client newClient = clientForm.convertion();
        Client createdClient = clientService.insertClient(newClient);
        if (createdClient != null) {
            return Response.status(Response.Status.CREATED).entity(new ClientDto(newClient)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response alterClient(@PathParam("id") Long id, @Valid ClientForm clientForm) {
        Client client = clientService.alterClient(id, clientForm.convertion());
        if (client != null) {
            return Response.status(Response.Status.OK).entity(new ClientDto(client)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteClient(@PathParam("id") Long id) {
        Client client = clientService.deleteClient(id);
        if (client != null) {
            return Response.status(Response.Status.OK).entity(new ClientDto(client)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
