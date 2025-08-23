package com.vladopard.recipes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "recipes")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_recipe_user"))
    private User user;

    @NotBlank
    @Column(nullable = false, length = 200)
    private  String title;

    @Column(columnDefinition = "text")
    private String description;

    @Min(1)
    @Column(nullable = false)
    private Integer servings;

    @Min(0)
    @Column(nullable = false)
    private Integer prepMinutes;

    @Min(0)
    @Column(nullable = false)
    private Integer cookMinutes;


}
