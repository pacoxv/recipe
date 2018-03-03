package paco.recipe.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(exclude= {"recipe"})
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
		
	private String description;
	private BigDecimal amount;
	
	@ManyToOne //inverse side to 1-n n-1
	private Recipe recipe;
	
	@OneToOne(fetch = FetchType.EAGER) //retrived every time
	private UnitOfMeasure uom;
	
		
	
	 public Ingredient() {
	 
	 }

	 public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom) {
	        this.description = description;
	        this.amount = amount;
	        this.uom = uom;
	        this.recipe = recipe;
	    }

	
	
}
