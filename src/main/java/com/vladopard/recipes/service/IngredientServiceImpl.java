package com.vladopard.recipes.service;

import com.vladopard.recipes.entity.Ingredient;
import com.vladopard.recipes.repository.IngredientRepository;
import com.vladopard.recipes.repository.RecipeRepository;
import com.vladopard.recipes.request.IngredientRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class IngredientServiceImpl implements IngredientService{

    private final IngredientRepository ingredients;
    private final RecipeRepository recipes;

    public IngredientServiceImpl(IngredientRepository ingredients, RecipeRepository recipes) {
        this.ingredients = ingredients;
        this.recipes = recipes;
    }

    @Override
    public Ingredient create(IngredientRequest request) {
        String name = request.getName();
        if (name == null || name.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name is required");
        }
        String normalized = name.trim();
        if (ingredients.existsByNameIgnoreCase(normalized)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ingredient already exists");
        }
        var ing = new Ingredient();
        ing.setName(normalized);
        return ingredients.save(ing);
    }

    @Override
    public Ingredient getOrThrow(Long id) {
        return ingredients.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Ingredient " + id + "not found"));
    }

    @Override
    public List<Ingredient> getAll() {
        return ingredients.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ingredient> getByRecipe(Long recipeId) {
        recipes.findById(recipeId).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Recipe " + recipeId + "not found"
                ));
        return ingredients.findAllByRecipeId(recipeId);
    }

    @Override
    public void delete(Long id) {
        var ing = getOrThrow(id);
        ingredients.delete(ing);
    }
}
