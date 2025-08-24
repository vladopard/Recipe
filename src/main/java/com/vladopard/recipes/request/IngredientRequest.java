package com.vladopard.recipes.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class IngredientRequest {
    @NotBlank
    public String name;
}
