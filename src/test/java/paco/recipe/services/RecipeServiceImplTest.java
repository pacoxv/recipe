package paco.recipe.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.never;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


import org.junit.Before;
import org.junit.Test;
import org.mockito.AdditionalMatchers;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import paco.recipe.model.Recipe;
import paco.recipe.repositories.RecipeRepository;

public class RecipeServiceImplTest {

	RecipeServiceImpl recipeService;
	
	@Mock
	RecipeRepository recipeRepository;
	
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		
		recipeService = new RecipeServiceImpl(recipeRepository);
	}
	
	@Test
	public void testGetRecipes() throws Exception{
		Recipe recipe = new Recipe();
		Set<Recipe> recipeData = new HashSet<Recipe>();
		recipeData.add(recipe);
		
		when(recipeService.getRecipes()).thenReturn(recipeData);
		
		
		Set<Recipe> recipes = recipeService.getRecipes();
		assertEquals(recipes.size(), 1);
		
		//findall only called once verify interactions
		verify(recipeRepository, times(1)).findAll();
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetRecipeById() throws Exception {
		Recipe recipe = new Recipe();
		Long idVal = 1L;
		
		recipe.setId(idVal);
		Optional<Recipe> recipeOpt = Optional.of(recipe);
		
		when(recipeRepository.findById(Matchers.anyLong())).thenReturn(recipeOpt);
		
		Optional <Recipe> recipeFound = recipeRepository.findById(idVal);
		
		assertNotNull("Null Resipe return",recipeFound);
		
		verify(recipeRepository, times(1)).findById(Matchers.anyLong());
		verify(recipeRepository, never()).findAll();
		
		
	}

}
