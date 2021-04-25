package se.lexicon.g33.jpa_assignment.data;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import se.lexicon.g33.jpa_assignment.model.entity.Ingredient;
import se.lexicon.g33.jpa_assignment.model.entity.RecipeIngredient;
import se.lexicon.g33.jpa_assignment.model.misc.Measurement;
import se.lexicon.g33.jpa_assignment.data.RecipeIngredientRepository;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RecipeIngredientRepositoryTest {

    @Autowired
    private RecipeIngredientRepository testObject;
    @Autowired
    private IngredientRepository testObjectIngredient;
    @Autowired
    private TestEntityManager em;

    Ingredient ingredient;
    Collection<RecipeIngredient> recipeIngredients = new ArrayList<>();

    @BeforeEach
    void setUp() {
        Ingredient ingredient1 = new Ingredient();
        Ingredient ingredient2 = new Ingredient();
        ingredient1.setIngredientName("Sugar");
        ingredient2.setIngredientName("Egg");

        RecipeIngredient recipeIngredient1 = new RecipeIngredient();
        RecipeIngredient recipeIngredient2 = new RecipeIngredient();
        recipeIngredient1.setIngredient(ingredient1);
        recipeIngredient2.setIngredient(ingredient2);
        recipeIngredient1.setAmount(2);
        recipeIngredient1.setMeasurement(Measurement.DL);
        recipeIngredient2.setAmount(3);
        recipeIngredient2.setMeasurement(Measurement.HG);
        Collection<RecipeIngredient> recipeIngredients = new ArrayList<>();
        recipeIngredients.add(recipeIngredient1);
        recipeIngredients.add(recipeIngredient2);

        em.persist(ingredient1);
        em.persist(ingredient2);

        em.persist(recipeIngredient1);
        em.persist(recipeIngredient2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findRecipeIngredientByIngredientContains() {
        ingredient = testObjectIngredient.findByIngredientNameIgnoreCase("sUgaR");
        recipeIngredients  = testObject.findRecipeIngredientByIngredient(ingredient);

        System.out.println(ingredient);
        System.out.println(recipeIngredients);

        assertEquals(recipeIngredients.size(), 1);

    }
}