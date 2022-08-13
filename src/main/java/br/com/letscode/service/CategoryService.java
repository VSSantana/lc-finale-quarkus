package br.com.letscode.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.letscode.model.Category;
import br.com.letscode.repository.CategoryRepository;

@Path("/category")
@RegisterRestClient(configKey = "quarkus-api")
public class CategoryService {

    @Inject
    CategoryRepository categoryRepository;

    public List<Category> geCategoryList() {
        return categoryRepository.listAll();
    }

    public Optional<Category> getCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findByIdOptional(id);
        return optionalCategory;
    }

    @Transactional
    public Category insertCategory(Category category) {
        categoryRepository.persist(category);
        return category;
    }

    @Transactional
    public Category alterCategory(Long id, Category categoryForm) {
        Optional<Category> optionalCategory = categoryRepository.findByIdOptional(id);
        if (optionalCategory.isPresent()) {
            optionalCategory.get().setName(categoryForm.getName());
            return optionalCategory.get();
        }
        return null;
    }

    @Transactional
    public Category deleteCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findByIdOptional(id);
        if (optionalCategory.isPresent()) {
            categoryRepository.deleteById(id);
            return optionalCategory.get();
        }
        return null;
    }

}
