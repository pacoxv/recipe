package paco.recipe.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(exclude= {"recipes"}) //avoid stackoverflow from circular ref
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String categoryName;
	
	@ManyToMany(mappedBy="categories") //inverse of joinTable annot
	private Set<Recipe> recipes;


	
		
}
