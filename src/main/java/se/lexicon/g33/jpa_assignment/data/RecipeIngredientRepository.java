package se.lexicon.g33.jpa_assignment.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.g33.jpa_assignment.model.entity.Ingredient;
import se.lexicon.g33.jpa_assignment.model.entity.Recipe;
import se.lexicon.g33.jpa_assignment.model.entity.RecipeIngredient;

import java.util.Collection;

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, String> {

    Collection<RecipeIngredient> findRecipeIngredientByIngredient(Ingredient ingredient);
}
