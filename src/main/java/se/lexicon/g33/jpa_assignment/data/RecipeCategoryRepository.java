package se.lexicon.g33.jpa_assignment.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.g33.jpa_assignment.model.entity.RecipeCategory;

import java.util.Locale;

public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory, String> {

}
