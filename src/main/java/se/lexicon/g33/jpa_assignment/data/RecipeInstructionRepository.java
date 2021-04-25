package se.lexicon.g33.jpa_assignment.data;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.g33.jpa_assignment.model.entity.RecipeInstruction;

public interface RecipeInstructionRepository extends CrudRepository<RecipeInstruction, Integer> {
}
