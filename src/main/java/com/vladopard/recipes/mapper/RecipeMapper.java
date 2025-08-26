package com.vladopard.recipes.mapper;

import com.vladopard.recipes.entity.Recipe;
import com.vladopard.recipes.entity.User;
import com.vladopard.recipes.response.RecipeResponse;
import com.vladopard.recipes.response.UserSummaryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RecipeMapper {

    @Mapping(target = "totalMinutes", expression = "java(recipe.getPrepMinutes() + recipe.getCookMinutes)")
    //za polje user u RecipeResponse prosledi user iz recipe
    @Mapping(target = "user", expression = "java(toUserSummary(recipe.getUser()))")
    @Mapping(target = "ingredients", ignore = true)//nije gotovo
    RecipeResponse toResponse(Recipe recipe);

    default UserSummaryResponse toUserSummary(User user){
        return new UserSummaryResponse(user.getId(), user.getDisplayName());
    }


}
