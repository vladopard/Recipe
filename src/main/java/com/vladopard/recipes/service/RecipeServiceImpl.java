package com.vladopard.recipes.service;

import com.vladopard.recipes.entity.Recipe;
import com.vladopard.recipes.repository.RecipeRepository;
import com.vladopard.recipes.request.RecipeRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class RecipeServiceImpl implements RecipeService{

    private final RecipeRepository recipes;
    private final UserService users;

    public RecipeServiceImpl(RecipeRepository recipes, UserService users) {
        this.recipes = recipes;
        this.users = users;
    }


    @Override
    public Recipe create(Long userId, RecipeRequest request) {
        var user = users.getOrThrow(userId);

        var r = new Recipe();
        r.setUser(user);
        applyRequest(r, request);
        return recipes.save(r);
    }

    @Override
    @Transactional(readOnly = true)
    public Recipe getOrThrow(Long recipeId) {
        return recipes.findById(recipeId)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Recipe " + recipeId + " not found"));
    }


    @Override
    @Transactional(readOnly = true)
    public List<Recipe> findByUser(Long userId) {
        return recipes.findByUserId(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Recipe> getAll(){
        return recipes.findAll();
    }

    @Override
    public Recipe update(Long recipeId, RecipeRequest request) {
        var r = getOrThrow(recipeId);
        applyRequest(r, request);
        return recipes.save(r);
    }

    @Override
    public void delete(Long recipeId) {
        var r = getOrThrow(recipeId);
        recipes.delete(r);
    }

    //HELPER
    private static void applyRequest(Recipe r, RecipeRequest req){
        r.setTitle(req.getTitle());
        r.setDescription(req.getDescription());
        r.setServings(req.getServings());
        r.setPrepMinutes(req.getPrepMinutes());
        r.setCookMinutes(req.getCookMinutes());
    }



}
