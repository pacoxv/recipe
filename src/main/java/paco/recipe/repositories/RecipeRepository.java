package paco.recipe.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import paco.recipe.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe,Long>{
	Optional<Recipe> findById(Long id);
}
