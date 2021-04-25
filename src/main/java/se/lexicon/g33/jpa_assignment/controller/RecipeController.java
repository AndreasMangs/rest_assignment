package se.lexicon.g33.jpa_assignment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lexicon.g33.jpa_assignment.model.entity.Ingredient;
import se.lexicon.g33.jpa_assignment.model.entity.Recipe;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RecipeController {



    @GetMapping("/api/recipe")
    public ResponseEntity<Recipe> findAllRecipes(){
        Recipe recipe = new Recipe(1,"Gulashsoppa" );
        return ResponseEntity.ok(recipe);
    }

}
