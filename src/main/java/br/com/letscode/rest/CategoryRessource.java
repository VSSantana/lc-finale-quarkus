package br.com.letscode.rest;

import java.util.List;

import javax.annotation.processing.Generated;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.letscode.model.Category;
import br.com.letscode.repository.CategoryRepository;
import br.com.letscode.service.CategoryService;

@Path("/category/list")
public class CategoryRessource {

    @Inject
    CategoryService categoryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getCategoryList() {
        return categoryService.listAll();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertCategory(Category category) {
        categoryService.persist(category);
    }

}
