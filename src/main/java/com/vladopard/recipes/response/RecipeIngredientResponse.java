package com.vladopard.recipes.response;

import lombok.*;

import java.math.BigDecimal;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class RecipeIngredientResponse {
    private Long ingredientId;
    private String ingredientName;
    private BigDecimal quantity;
    private String unit;
}
