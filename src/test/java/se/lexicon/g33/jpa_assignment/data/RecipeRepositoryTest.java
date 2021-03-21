package se.lexicon.g33.jpa_assignment.data;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import se.lexicon.g33.jpa_assignment.model.entity.*;
import se.lexicon.g33.jpa_assignment.model.misc.Measurement;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RecipeRepositoryTest {

    @Autowired
    private RecipeRepository testObject;
    @Autowired
    private TestEntityManager em;

    @BeforeEach
    void setUp() {

        RecipeInstruction recipeInstruction = new RecipeInstruction();
        recipeInstruction.setInstructions("Drop ingredients in bowl, mix it, put in owen in 200 degrees in 30 minutes");

        RecipeCategory recipeCategory1 = new RecipeCategory();
        RecipeCategory recipeCategory2 = new RecipeCategory();
        recipeCategory1.setCategory("Dessert");
        recipeCategory1.setCategory("Baking");
        Collection<RecipeCategory> recipeCategorys = new ArrayList<>();
        recipeCategorys.add(recipeCategory1);
        recipeCategorys.add(recipeCategory2);

        Ingredient ingredient1 = new Ingredient();
        Ingredient ingredient2 = new Ingredient();
        ingredient1.setIngredient("Sugar");
        ingredient2.setIngredient("Egg");

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


        Recipe recipe = new Recipe();
        recipe.setName("Sugar cake");
        recipe.setRecipeInstruction(recipeInstruction);
        recipe.setRecipeCategories(recipeCategorys);
        recipe.setRecipeIngredients(recipeIngredients);

        em.persist(recipeInstruction);
        em.persist(recipeCategory1);
        em.persist(recipeCategory2);
        em.persist(ingredient1);
        em.persist(ingredient2);
        em.persist(recipeIngredient1);
        em.persist(recipeIngredient2);
        em.persist(recipe);
        em.flush();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findByNameContains() {
        Collection<Recipe> r1 = testObject.findByNameContains("cake");
        Collection<Recipe> r2 = testObject.findByNameContains("cheese");

        assertEquals(r1.size(), 1);
        assertEquals(r2.size(), 0);
    }

    @Test
    void findRecipeByRecipeIngredientsContains() {
        Collection<Recipe> r1 = testObject.findRecipeByRecipeIngredientsContains("Egg");
        Collection<Recipe> r2 = testObject.findRecipeByRecipeIngredientsContains("Fudge");

        assertEquals(r1.size(), 1);
        assertEquals(r2.size(), 0);
    }



}