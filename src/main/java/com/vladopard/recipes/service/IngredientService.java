package com.vladopard.recipes.service;

import com.vladopard.recipes.entity.Ingredient;
import com.vladopard.recipes.request.IngredientRequest;

import java.util.List;

public interface IngredientService {
    Ingredient create(IngredientRequest request);
    Ingredient getOrThrow(Long id);
    List<Ingredient> getAll();
    List<Ingredient> getByRecipe(Long recipeId);
    void delete(Long id);
}
