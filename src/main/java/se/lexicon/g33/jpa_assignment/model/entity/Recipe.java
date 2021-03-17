package se.lexicon.g33.jpa_assignment.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    //Collection<RecipeIngredient> ingredients;
    //RecipeInstruction recipeInstruction;
    //Collection<RecipeCategory> recipeCategories;
}




