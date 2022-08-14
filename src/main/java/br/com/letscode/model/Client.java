package br.com.letscode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    @Column(name = "vat_number")
    private String vatNumber;
    private String email;
    @Column(name = "id_category")
    private Long idCategory;

    public Client() {

    }

    public Client(String name, Integer age, String vatNumber, String email, Long idCategory) {
        this.name = name;
        this.age = age;
        this.vatNumber = vatNumber;
        this.email = email;
        this.idCategory = idCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return vatNumber;
    }

    public void setVatnumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", vatNumber=" + vatNumber
                + ", idCategory=" + idCategory
                + "]";
    }

}
