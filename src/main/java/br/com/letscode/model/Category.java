package br.com.letscode.model;

public class Category {

    private Long code;
    private String name;

    public Category() {

    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category [code=" + code + ", name=" + name + "]";
    }

}
