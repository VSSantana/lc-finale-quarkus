package br.com.letscode.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.letscode.model.Client;

public class ClientDto {

    private String name;
    private Integer age;
    private String vatnumber;
    private String email;

    public ClientDto(Client client) {
        this.name = client.getName();
        this.age = client.getAge();
        this.vatnumber = client.getVatnumber();
        this.email = client.getEmail();
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

    public static List<ClientDto> convertion(List<Client> clients) {
        return clients.stream().map(ClientDto::new).collect(Collectors.toList());
    }

}
