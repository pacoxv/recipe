package paco.recipe.services;

import java.util.Set;

import paco.recipe.model.Recipe;

public interface RecipeService {
	public Set<Recipe> getRecipes();
	public Recipe findById(Long id);
}
