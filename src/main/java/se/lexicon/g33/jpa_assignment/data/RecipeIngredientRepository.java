package se.lexicon.g33.jpa_assignment.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.g33.jpa_assignment.model.entity.RecipeIngredient;

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, String> {
}
