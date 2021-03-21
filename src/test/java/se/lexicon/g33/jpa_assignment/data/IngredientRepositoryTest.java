package se.lexicon.g33.jpa_assignment.data;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import se.lexicon.g33.jpa_assignment.model.entity.Ingredient;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class IngredientRepositoryTest {

    @Autowired
    private IngredientRepository testObject;
    @Autowired
    private TestEntityManager em;

    @BeforeEach
    void setUp() {
        Ingredient testIngredient = new Ingredient(0,"Socker");
        em.persist(testIngredient);
        em.flush();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("findByIngredient - Should find ingredient")
    void findByIngredient() {
        Ingredient i = testObject.findByIngredient("Socker");

        assertEquals(i.getIngredient(), "Socker");
        assertEquals(i.getId(), 1);
    }

    @Test
    @DisplayName("findByIngredientContains - Should get a collection of 1")
    void findByIngredientContains() {

        Collection<Ingredient> i = new ArrayList<>();

        i = testObject.findByIngredientContains("ock");

        assertEquals(i.size(), 1);


    }

}