package com.vladopard.recipes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @NotBlank
    @Column(nullable = false, length = 255)
    private String password;

    @NotBlank
    @Column(nullable = false, length = 80)
    private String displayName;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recipe> recipes = new ArrayList<>();

    //helperi
    public void addRecipe(Recipe recipe){
        if(recipe == null) return;
        if(!recipes.contains(recipe)) recipes.add(recipe);
        if(recipe.getUser() != this) recipe.setUser(this);
    }

    public void removeRecipe(Recipe recipe){
        if(recipe == null) return;
        recipes.remove(recipe);
        if(recipe.getUser() == this) recipe.setUser(null);
    }


}



