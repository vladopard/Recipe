package com.vladopard.recipes.mapper;

import com.vladopard.recipes.entity.RecipeIngredient;
import com.vladopard.recipes.response.RecipeIngredientResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecipeIngredientMapper {

    @Mapping(target = "ingredientId", source = "ingredient.id")
    @Mapping(target = "ingredientName", source = "ingredient.name")
    RecipeIngredientResponse toResponse(RecipeIngredient ri);

    List<RecipeIngredientResponse> toResponseList(List<RecipeIngredient> ris);

}
