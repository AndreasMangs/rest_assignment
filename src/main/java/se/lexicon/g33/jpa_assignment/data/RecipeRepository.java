package se.lexicon.g33.jpa_assignment.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import se.lexicon.g33.jpa_assignment.model.entity.Ingredient;
import se.lexicon.g33.jpa_assignment.model.entity.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.lexicon.g33.jpa_assignment.model.entity.RecipeCategory;

import java.util.Collection;

public interface RecipeRepository extends JpaRepository<Recipe, String> {

    Collection<Recipe> findByNameContainsIgnoreCase(String name);

    /*
    @Query("SELECT i FROM Recipe i WHERE i.recipe.recipeIngredients.ingredient.ingredient IN :ingredient ")
    Collection<Recipe> findRecipeByRecipeIngredientsContains(@Param("ingredient") String ingredient);
    */

    /*
    SELECT name FROM recipe WHERE id IN
            (SELECT ingredient_id FROM recipe_ingredient WHERE ingredient_id IN
                    (SELECT id FROM ingredient WHERE ingredient = ?))
    */

    /*
    @Query("SELECT c FROM Recipe c WHERE c.recipeCategories. IN :category ")
    Collection<Recipe> findByRecipeCategories(@Param("category") String category);
    */

    /*
    SELECT name FROM recipe WHERE id IN
            (SELECT recipe_id FROM recipe_id_recipe_category_id where id IN
                    (SELECT id FROM recipe_category WHERE category IN ?))
     */
}
