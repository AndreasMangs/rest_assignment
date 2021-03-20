package se.lexicon.g33.jpa_assignment.data;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.g33.jpa_assignment.model.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, String> {
}
