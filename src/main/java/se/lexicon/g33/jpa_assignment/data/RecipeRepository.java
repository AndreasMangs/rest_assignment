package se.lexicon.g33.jpa_assignment.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.g33.jpa_assignment.model.entity.Ingredient;
import se.lexicon.g33.jpa_assignment.model.entity.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface RecipeRepository extends CrudRepository<Recipe, String> {

    Collection<Recipe> findByNameContains(String name);

    @Query("SELECT i FROM Recipe i WHERE i.recipe.recipeIngredients.ingredient.ingredient = :ingredient ")
    Collection<Recipe> findRecipeByRecipeIngredientsContains(@Param("ingredient") String ingredient);

}
