package br.com.letscode.rest;

import javax.annotation.processing.Generated;

import br.com.letscode.model.Category;
import br.com.letscode.repository.CategoryRepository;
import br.com.letscode.service.CategoryService;

@Path("/category/list")
public class CategoryRessource {

    @Inject
    @RegisterRestClient
    CategoryRepository categoryRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getList() {
        return categoryRepository.getList();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertCategory(Category category) {
        categoryRepository.persist(category);
    }

}
