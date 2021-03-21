package se.lexicon.g33.jpa_assignment.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.g33.jpa_assignment.model.entity.Ingredient;

import java.util.Collection;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

    Ingredient findByIngredient(String ingredient);

    Collection<Ingredient> findByIngredientContains(String ingredient);




}
