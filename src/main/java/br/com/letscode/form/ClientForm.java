package br.com.letscode.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import br.com.letscode.model.Client;

public class ClientForm {

    @NotNull(message = "O nome não pode ser vazio!")
    @Length(min = 5, max = 100, message = "Observar o tamanho mínimo e máximo para o nome.")
    private String name;
    @NotNull(message = "Idade não pode ser vazio!")
    @Min(message = "O cliente deve ser maior de idade!", value = 18)
    private Integer age;
    @NotNull(message = "O Vat Number não pode ser vazio!")
    @Pattern(message = "O padrão para o Vat Number não foi reconhecido!", regexp = "^[a-zA-Z]{2}[0-9]{9}")
    private String vatNumber;
    @NotNull(message = "O email não pode ser vazio!")
    @Email(message = "Email não possui o formato padrão.")
    private String email;
    @NotNull(message = "Necessário informar o código da categoria do cliente.")
    private Long idCategory;

    public ClientForm() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public Client convertion() {
        return new Client(name, age, vatNumber, email, idCategory);
    }

}
