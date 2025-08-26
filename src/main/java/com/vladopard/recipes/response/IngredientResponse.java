package com.vladopard.recipes.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class IngredientResponse {
    private Long id;
    private String name;

    public IngredientResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
