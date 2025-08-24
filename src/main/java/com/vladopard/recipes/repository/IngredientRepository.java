package com.vladopard.recipes.repository;

import com.vladopard.recipes.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    boolean existsByNameIgnoreCase(String name);

    @Query("select ri.ingredient from RecipeIngredient ri where ri.recipe.id = :recipeId ")
    List<Ingredient> findAllByRecipeId(@Param("recipeId") Long recipeId);
}
