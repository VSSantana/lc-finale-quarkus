package br.com.letscode.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.http.client.utils.URIBuilder;

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
    public List<ClientDto> getClients() {
        List<Client> clients = clientService.geClienttList();
        return ClientDto.convertion(clients);
    }

    @POST
    public Response insertClient(@Valid ClientForm client) {
        Client newClient = client.convertion();
        clientService.insertClient(newClient);
        URI uri = UriBuilder.fromPath("/client/details/{id}").build(newClient.getId());
        return Response.created(uri).build();
    }

    @Path("/details/{id}")
    @GET
    public Response getClient(@Param???? Integer id) {
        Optional<Client> client = clientService.getClient(id);
        if (client.isPresent()) {
            return ResponseEntity.ok().body(new ClientDto(client.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PathVariable("/{id}")
    @PUT
    @Transactional
    public ResponseEntity<ClientDto> alterClient(@PathVariable Long id,
            @RequestBody @Valid ClientForm clientForm) {
        Client client = clientService.findById(id, clientForm);
        if (client != null) {
            return ResponseEntity.ok().body(new ClientDto(client));
        }
        return ResponseEntity.notFound().build();
    }

    // @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    // @DeleteMapping
    // @Transactional
    // public ResponseEntity<?> deleteClient(@PathVariable Integer id) {
    // Optional<Client> optionalClient = clientRepository.findById(id);
    // if (optionalClient.isPresent()) {
    // clientRepository.deleteById(id);
    // return ResponseEntity.ok().build();
    // }
    // return ResponseEntity.notFound().build();
    // }

}
