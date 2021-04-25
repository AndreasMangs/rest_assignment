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
import java.util.Locale;

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
        Collection<RecipeCategory> recipeCategories = new ArrayList<>();
        recipeCategories.add(recipeCategory1);
        recipeCategories.add(recipeCategory2);

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


        Recipe recipe = new Recipe();
        recipe.setRecipeName("Sugar cake");
        recipe.setRecipeInstruction(recipeInstruction);
        recipe.setRecipeCategories(recipeCategories);
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
    void findByRecipeNameContains() {
        Collection<Recipe> r1 = testObject.findByRecipeNameContainsIgnoreCase("cAkE");
        Collection<Recipe> r2 = testObject.findByRecipeNameContainsIgnoreCase("cHeEsE");

        assertEquals(r1.size(), 1);
        assertEquals(r2.size(), 0);
    }


    @Test
    void findByIngredientNameIgnoreCase() {

        Collection<Recipe> recipes = testObject.findByIngredientNameIgnoreCase("Sugar");

        assertEquals(recipes.size(), 1);

    }





    @Test
    void findByCategoryIgnoreCase() {
        Collection<Recipe> r1 = testObject.findByCategoryIgnoreCase("Egg");
        Collection<Recipe> r2 = testObject.findByCategoryIgnoreCase("Fudge");

        assertEquals(r1.size(), 1);
        assertEquals(r2.size(), 0);
    }


    @Test
    void findByCategories() {
        Collection<String> recipeCategories1 = new ArrayList<>();
        Collection<String> recipeCategories2 = new ArrayList<>();
        recipeCategories1.add("Dessert");
        recipeCategories2.add("Grilling");


        Collection<Recipe> r1 = testObject.findByCategories(recipeCategories1);
        Collection<Recipe> r2 = testObject.findByCategories(recipeCategories2);

        assertEquals(r1.size(), 1);
        assertEquals(r2.size(), 0);
    }


}