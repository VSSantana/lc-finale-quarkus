package br.com.letscode.rest;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.letscode.dto.CategoryDto;
import br.com.letscode.form.CategoryForm;
import br.com.letscode.model.Category;
import br.com.letscode.service.CategoryService;

@Path("/category")
public class CategoryRessource {

    @Inject
    CategoryService categoryService;

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategoryDto> getCategories() {
        List<Category> categories = categoryService.geCategoryList();
        return CategoryDto.convertion(categories);
    }

    @GET
    @Path("/details/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategory(@PathParam("id") Long id) {
        Optional<Category> category = categoryService.getCategory(id);
        if (category.isPresent()) {
            return Response.ok().entity(new CategoryDto(category.get())).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertCategory(@Valid CategoryForm categoryForm) {
        Category newCategory = categoryForm.convertion();
        categoryService.insertCategory(newCategory);
        return Response.status(Response.Status.CREATED).entity(new CategoryDto(newCategory)).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response alterCategory(@PathParam("id") Long id, @Valid CategoryForm categoryForm) {
        Category category = categoryService.alterCategory(id, categoryForm.convertion());
        if (category != null) {
            return Response.status(Response.Status.OK).entity(new CategoryDto(category)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteCategory(@PathParam("id") Long id) {
        Category category = categoryService.deleteCategory(id);
        if (category != null) {
            return Response.status(Response.Status.OK).entity(new CategoryDto(category)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
