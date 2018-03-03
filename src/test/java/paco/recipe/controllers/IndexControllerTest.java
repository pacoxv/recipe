package paco.recipe.controllers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.results.ResultMatchers;
import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.RequestResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import paco.recipe.model.Recipe;
import paco.recipe.services.RecipeServiceImpl;

public class IndexControllerTest {
	
	IndexController indexController;
	
	@Mock
	RecipeServiceImpl recipeService;
	
	@Mock
	Model model;
	
	
	@Before
	public void setUp() throws Exception{
		
		MockitoAnnotations.initMocks(this);
		
		indexController = new IndexController(recipeService);
	}
	
	@Test
	public void testMockMvc() throws Exception{
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
		
		mockMvc.perform(MockMvcRequestBuilders.get("/"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.view().name("index"));
		
	}
	

	@Test
	public void testGetIndexPage() {
	
		//given
		Set<Recipe> recipes = new HashSet<Recipe>();
		Recipe recipe = new Recipe();
		recipe.setId(1000L); recipes.add(recipe);
		recipe.setId(2000L); recipes.add(recipe);
		
		when(recipeService.getRecipes()).thenReturn(recipes);

		ArgumentCaptor<Set<Recipe>> argCaptor = ArgumentCaptor.forClass(Set.class);
		
		//when
		String viewName = indexController.getIndexPage(model);
		
		
		//then
		verify(recipeService, times(1)).getRecipes();
		verify(model, times(1)).addAttribute(Mockito.matches("recipes"), argCaptor.capture());
		assertEquals("index",viewName);
		
		Set<Recipe> setOfRecipesFromController = argCaptor.getValue();
		assertEquals(setOfRecipesFromController.size(),2);
		
	}

}
