package br.com.letscode.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.letscode.model.Category;

public class CategoryDto {

    private String name;

    public CategoryDto(Category category) {
        this.name = category.getName();
    }

    public String getName() {
        return name;
    }

    public static List<CategoryDto> convertion(List<Category> coategories) {
        return coategories.stream().map(CategoryDto::new).collect(Collectors.toList());
    }

}
