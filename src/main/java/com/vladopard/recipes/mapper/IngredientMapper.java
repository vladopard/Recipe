package com.vladopard.recipes.mapper;

import com.vladopard.recipes.entity.Ingredient;
import com.vladopard.recipes.response.IngredientResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IngredientMapper {
    IngredientResponse toResponse(Ingredient ingredient);
    List<IngredientResponse> toResponseList(List<Ingredient> ingredients);
}
