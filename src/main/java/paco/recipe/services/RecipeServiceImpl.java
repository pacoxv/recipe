package paco.recipe.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import paco.recipe.model.Recipe;
import paco.recipe.repositories.RecipeRepository;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService{
	
	RecipeRepository recipeRepository;

	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		
		this.recipeRepository = recipeRepository;
		
	}
	
	public Set<Recipe> getRecipes(){
		
		
		Set<Recipe> result = new HashSet<Recipe>(); 
				
		recipeRepository.findAll().iterator().forEachRemaining(result :: add);
		
			
		return result;
	}
	
	public Recipe findById(Long id) {
		
		
		Optional<Recipe> recipeOpt = recipeRepository.findById(id);
		
		if(!recipeOpt.isPresent()) {
			throw new RuntimeException("Recipe Not Found");
		}
		
		return recipeOpt.get();
		
		
		
	}
}
