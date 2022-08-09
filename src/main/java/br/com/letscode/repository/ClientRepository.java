package br.com.letscode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.letscode.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
