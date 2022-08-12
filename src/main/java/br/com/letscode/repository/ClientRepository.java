package br.com.letscode.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.letscode.model.Client;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ClientRepository implements PanacheRepository<Client> {

}
