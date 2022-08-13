package br.com.letscode.form;

import javax.validation.constraints.NotBlank;

import br.com.letscode.model.Category;

public class CategoryForm {

    @NotBlank(message = "Nome da categoria não pode ser vazio!")
    private String name;

    public CategoryForm() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Category convertion() {
        return new Category(name);
    }

}
