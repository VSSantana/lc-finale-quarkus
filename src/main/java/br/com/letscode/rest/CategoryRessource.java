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

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

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
    @Operation(summary = "Recupera a lista de categorias da base de dados", description = "Lista de categorias no formato JSON")
    @APIResponse(responseCode = "200", description = "Recupera lista de categorias", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Category.class))
    })
    public List<CategoryDto> getCategories() {
        List<Category> categories = categoryService.geCategoryList();
        return CategoryDto.convertion(categories);
    }

    @GET
    @Path("/details/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Recupera os detalhes de uma categoria da base de dados", description = "Apresenta o registro de uma categoria no formato JSON")
    @APIResponse(responseCode = "200", description = "Recupera o registro de uma categoria", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Category.class))
    })
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
    @Operation(summary = "Insere uma categoria na base de dados", description = "Inclui uma categoria na base de dados")
    @APIResponse(responseCode = "201", description = "Inserir categoria", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Category.class))
    })
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
    @Operation(summary = "Altera uma categoria na base de dados", description = "Altera uma categoria na base de dados")
    @APIResponse(responseCode = "200", description = "Alterar categoria", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Category.class))
    })
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
    @Operation(summary = "Deleta uma categoria da base de dados", description = "Deleta uma categoria da base de dados")
    @APIResponse(responseCode = "200", description = "Deletar categoria", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Category.class))
    })
    public Response deleteCategory(@PathParam("id") Long id) {
        Category category = categoryService.deleteCategory(id);
        if (category != null) {
            return Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
