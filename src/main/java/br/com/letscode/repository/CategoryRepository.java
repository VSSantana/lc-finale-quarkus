package br.com.letscode.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.letscode.model.Category;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CategoryRepository implements PanacheRepository<Category> {

}
