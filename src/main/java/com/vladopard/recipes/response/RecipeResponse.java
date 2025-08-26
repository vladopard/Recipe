package com.vladopard.recipes.response;

import lombok.*;

import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class RecipeResponse {
    private Long id;
    private String title;
    private String description;
    private Integer servings;
    private Integer prepMinutes;
    private Integer cookMinutes;
    private Integer totalMinutes;
    private UserSummaryResponse user;
    private List<RecipeIngredientResponse> ingredients;
}
