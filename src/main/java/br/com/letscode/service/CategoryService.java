package br.com.letscode.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.letscode.model.Category;

@Path("/category/list")
@RegisterRestClient(configKey = "quarkus-api")
public class CategoryService {

    @GET
    @javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
    public List<Category> getList();

}
