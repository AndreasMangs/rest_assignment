package se.lexicon.g33.jpa_assignment.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import se.lexicon.g33.jpa_assignment.model.entity.Ingredient;
import se.lexicon.g33.jpa_assignment.model.entity.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.lexicon.g33.jpa_assignment.model.entity.RecipeCategory;
import se.lexicon.g33.jpa_assignment.data.RecipeIngredientRepository;
import se.lexicon.g33.jpa_assignment.data.IngredientRepository;
import se.lexicon.g33.jpa_assignment.model.entity.RecipeIngredient;


import java.util.Collection;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    Collection<Recipe> findByRecipeNameContainsIgnoreCase(String name);



    @Query("SELECT r FROM Recipe r JOIN FETCH r.recipeIngredients AS ri WHERE UPPER(ri.ingredient.ingredientName) = UPPER(:name)")
    Collection<Recipe> findByIngredientNameIgnoreCase(@Param("name") String name);



    @Query("SELECT r FROM Recipe r JOIN FETCH r.recipeCategories AS rc WHERE UPPER(rc.category) = UPPER(:category)")
    Collection<Recipe> findByCategoryIgnoreCase(@Param("category") String category);


    @Query("SELECT r FROM Recipe r JOIN FETCH r.recipeCategories AS rc WHERE rc.category IN (:categories)")
    Collection<Recipe> findByCategories(@Param("categories") Collection<String> categories);


}
