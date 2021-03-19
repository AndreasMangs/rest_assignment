package se.lexicon.g33.jpa_assignment.data;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.g33.jpa_assignment.model.entity.Ingredient;

import java.util.Collection;

public class IngredientRepository extends JpaRepository<Ingredient, String> {
    Collection<Ingredient> findAll();

}
