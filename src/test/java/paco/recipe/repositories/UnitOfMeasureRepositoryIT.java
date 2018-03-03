package paco.recipe.repositories;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import paco.recipe.model.UnitOfMeasure;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {
	
	@Autowired
	UnitOfMeasureRepository unitOfMeasureRepository;

	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindByUom() {
		Optional<UnitOfMeasure> uom = unitOfMeasureRepository.findByUom("Each");
		assertEquals(uom.get().getUom(),"Each");
	}

}
