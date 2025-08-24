package com.vladopard.recipes.service;

import com.vladopard.recipes.entity.Recipe;
import com.vladopard.recipes.request.RecipeRequest;

import java.util.List;

public interface RecipeService {
    Recipe create(Long userId, RecipeRequest request);
    Recipe getOrThrow(Long recipeId);
    List<Recipe> findByUser(Long userId);
    List<Recipe> getAll();
    Recipe update(Long recipeId, RecipeRequest request);
    void delete(Long recipeId);
}
