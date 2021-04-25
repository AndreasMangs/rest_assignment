package se.lexicon.g33.jpa_assignment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {

    @GetMapping("/api/recipe")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Hello world");
    }

}
