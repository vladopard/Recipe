package com.vladopard.recipes.repository;

import com.vladopard.recipes.entity.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {

    List<RecipeIngredient> findByRecipeId(Long recipeId);

    boolean existsByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

    void deleteByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

    void deleteByRecipeId(Long recipeId);
}
