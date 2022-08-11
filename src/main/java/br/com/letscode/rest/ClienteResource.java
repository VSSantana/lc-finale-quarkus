package br.com.letscode.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import br.com.letscode.dto.ClientDto;
import br.com.letscode.model.Client;
import br.com.letscode.repository.ClientRepository;

@Path("/client")
public class ClienteResource {

    private ClientRepository clientRepository;

    @GET
    @Path("/list")
    public List<ClientDto> getClients() {
        List<Client> clients = clientRepository.findAll();
        return ClientDto.convertion(clients);
    }

    // @POST
    // @Transactional
    // public ResponseEntity<ClientDto> insertClient(@RequestBody @Valid ClientForm
    // client,
    // UriComponentsBuilder uriBuilder) {
    // Client newClient = client.convertion();
    // clientRepository.save(newClient);
    // URI uri =
    // uriBuilder.path("/client/details/{id}").buildAndExpand(newClient.getId()).toUri();
    // return ResponseEntity.created(uri).body(new ClientDto(newClient));
    // }

    // @RequestMapping("/details/{id}")
    // @GetMapping
    // public ResponseEntity<ClientDto> getClient(@PathVariable Integer id) {
    // Optional<Client> optionalClient = clientRepository.findById(id);
    // if (optionalClient.isPresent()) {
    // return ResponseEntity.ok().body(new ClientDto(optionalClient.get()));
    // }
    // return ResponseEntity.notFound().build();
    // }

    // @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    // @PutMapping
    // @Transactional
    // public ResponseEntity<ClientDto> alterClient(@PathVariable Integer id,
    // @RequestBody @Valid ClientForm clientForm) {
    // Optional<Client> optionalClient = clientRepository.findById(id);
    // if (optionalClient.isPresent()) {
    // Client client = clientForm.update(id, clientRepository);
    // return ResponseEntity.ok().body(new ClientDto(client));
    // }
    // return ResponseEntity.notFound().build();
    // }

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
