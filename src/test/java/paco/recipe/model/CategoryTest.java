package paco.recipe.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CategoryTest {
	
	Category category;
	
	@Before
	public void setUp() {
		category = new Category();
	}

	@Test
	public void testGetId() {
		Long val = 4L;
		category.setId(val);
		assertEquals(val ,category.getId());
	}

	@Test
	public void testGetCategoryName() {
		
	}

	@Test
	public void testGetRecipes() {
		
	}

}
