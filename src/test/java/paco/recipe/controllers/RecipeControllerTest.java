package paco.recipe.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import paco.recipe.model.Recipe;
import paco.recipe.services.RecipeService;

public class RecipeControllerTest {
	
	@Mock
	RecipeService recipeService;
	
	RecipeController recipeController;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		recipeController = new RecipeController(recipeService);
		
	}

	@Test
	public void testGetRecipe() throws Exception {
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
		
		Mockito.when(recipeService.findById(Mockito.anyLong())).thenReturn(recipe);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/recipe/show/1"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.view().name("recipe/show"))
		.andExpect(MockMvcResultMatchers.model().attributeExists("recipe"));
		
		
	}

}
