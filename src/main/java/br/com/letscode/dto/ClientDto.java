package br.com.letscode.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import br.com.letscode.model.Client;
import br.com.letscode.repository.CategoryRepository;

public class ClientDto {

    private String name;
    private Integer age;
    private String vatnumber;
    private String email;
    private String category;

    @Inject
    CategoryRepository categoryRepository = new CategoryRepository();

    public ClientDto(Client client) {
        this.name = client.getName();
        this.age = client.getAge();
        this.vatnumber = client.getVatnumber();
        this.email = client.getEmail();
        this.category = categoryRepository.findById(client.getIdCategory()).getName();
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getVatnumber() {
        return vatnumber;
    }

    public String getEmail() {
        return email;
    }

    public String getCategory() {
        return category;
    }

    public static List<ClientDto> convertion(List<Client> clients) {
        return clients.stream().map(ClientDto::new).collect(Collectors.toList());
    }

}
