package br.com.letscode.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer age;
    private String vatnumber;
    private String email;

    public Client(String name, Integer age, String vatnumber, String email) {
        this.name = name;
        this.age = age;
        this.vatnumber = vatnumber;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getVatnumber() {
        return vatnumber;
    }

    public void setVatnumber(String vatnumber) {
        this.vatnumber = vatnumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", vatnumber=" + vatnumber
                + "]";
    }

}
