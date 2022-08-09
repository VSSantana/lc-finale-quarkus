package br.com.letscode.rest.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.letscode.rest.controller.dto.ClientDto;
import br.com.letscode.rest.controller.form.ClientForm;
import br.com.letscode.rest.model.Client;
import br.com.letscode.rest.repository.ClientRepository;

@RestController
@RequestMapping("/client")
public class ClienteController {

    @Autowired
    private ClientRepository clientRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<ClientDto> getClients() {
        List<Client> clients = clientRepository.findAll();
        return ClientDto.convertion(clients);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ClientDto> insertClient(@RequestBody @Valid ClientForm client,
            UriComponentsBuilder uriBuilder) {
        Client newClient = client.convertion();
        clientRepository.save(newClient);
        URI uri = uriBuilder.path("/client/details/{id}").buildAndExpand(newClient.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClientDto(newClient));
    }

    @RequestMapping("/details/{id}")
    @GetMapping
    public ResponseEntity<ClientDto> getClient(@PathVariable Integer id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            return ResponseEntity.ok().body(new ClientDto(optionalClient.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @PutMapping
    @Transactional
    public ResponseEntity<ClientDto> alterClient(@PathVariable Integer id, @RequestBody @Valid ClientForm clientForm) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client client = clientForm.update(id, clientRepository);
            return ResponseEntity.ok().body(new ClientDto(client));
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @DeleteMapping
    @Transactional
    public ResponseEntity<?> deleteClient(@PathVariable Integer id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            clientRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
