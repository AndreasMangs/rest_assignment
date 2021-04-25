package se.lexicon.g33.jpa_assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.g33.jpa_assignment.data.IngredientRepository;
import se.lexicon.g33.jpa_assignment.model.entity.Ingredient;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class IngredientController {

    private IngredientRepository repository;

    @Autowired
    public IngredientController(IngredientRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/ingredient")
    public ResponseEntity<Iterable<Ingredient>> findIngredients(@RequestParam(name = "value", required = false) String value) {


        return ResponseEntity.ok(value != null ? repository.findByIngredientNameContains(value) : repository.findAll());
    }

    @PostMapping("/api/ingredient")
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
        repository.save(ingredient);
        return ResponseEntity.created(URI.create("/api/ingredient/" )).body(ingredient);
    }



}
