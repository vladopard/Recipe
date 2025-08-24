package com.vladopard.recipes.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RecipeRequest {
    @NotBlank
    private String title;

    private String description;

    @Min(1)
    private Integer servings;

    @Min(0)
    private Integer prepMinutes;

    @Min(0)
    private Integer cookMinutes;

}
