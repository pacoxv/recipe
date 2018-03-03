package paco.recipe.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import paco.recipe.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	Optional<Category> findByCategoryName(String categoryName);
}
