package se.lexicon.g33.jpa_assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.g33.jpa_assignment.data.RecipeRepository;
import se.lexicon.g33.jpa_assignment.model.entity.Recipe;
import se.lexicon.g33.jpa_assignment.model.entity.RecipeCategory;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

@RestController
public class RecipeController {

    private RecipeRepository repository;

    @Autowired
    public RecipeController(RecipeRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/api/recipe")
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {

        repository.save(recipe);
        return ResponseEntity.created(URI.create("/api/recipe/" )).body(recipe);
    }

/*
    @GetMapping("/api/recipe/all")
    public ResponseEntity<Iterable<Recipe>> findAllRecipes(){

        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/api/recipe/name")
    public ResponseEntity<Collection<Recipe>> findRecipesByName(@RequestParam (name = "value", required = true) String value) {

        return ResponseEntity.ok(repository.findByRecipeNameContainsIgnoreCase(value));
    }



    @GetMapping("/api/recipe/ingredient")
    public ResponseEntity<Collection<Recipe>> findByIngredient(@RequestParam (name = "value", required = true) String value) {

        return ResponseEntity.ok(repository.findByIngredientNameIgnoreCase(value));
    }

    @GetMapping("/api/recipe/category")
    public ResponseEntity<Collection<Recipe>> findByCategory(@RequestParam (name = "value", required = true) String value) {

        return ResponseEntity.ok(repository.findByCategoryIgnoreCase(value));
    }

    @GetMapping("/api/recipe/categories")
    public ResponseEntity<Collection<Recipe>> findByCategories(@RequestParam (name = "values", required = true) Collection<String> values) {

        return ResponseEntity.ok(repository.findByCategories(values));
    }
*/
    @GetMapping("/api/recipe")
    public ResponseEntity<Collection<Recipe>> findRecipes(@RequestParam (name ="name", required = false ) String name,
                                                          @RequestParam (name = "ingredient", required = false) String ingredient,
                                                          @RequestParam (name="category", required = false) String category,
                                                          @RequestParam (name = "categories", required = false) Collection<String> categories) {

        if(name != null){
            return ResponseEntity.ok(repository.findByRecipeNameContainsIgnoreCase(name));
        } else if (ingredient != null) {
            return ResponseEntity.ok(repository.findByIngredientNameIgnoreCase(ingredient));
        } else if (category != null) {
            return ResponseEntity.ok(repository.findByCategoryIgnoreCase(category));
        } else if (categories != null){
            return ResponseEntity.ok(repository.findByCategories(categories));
        } else {
            return ResponseEntity.ok(repository.findAll());
        }

    }

}
