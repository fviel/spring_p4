/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.recipe.services;

import com.fernando.recipe.entities.Ingredient;
import com.fernando.recipe.entities.Recipe;
import com.fernando.recipe.entities.UnityOfMeasure;
import com.fernando.recipe.enums.Difficulty;
import com.fernando.recipe.repositories.CategoryRepository;
import com.fernando.recipe.repositories.IngredientRepository;
import com.fernando.recipe.repositories.RecipeRepository;
import com.fernando.recipe.repositories.UnityOfMeasureRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fernando
 */
@Service
@Transactional
public class RecipeService {

    private CategoryRepository categoryRepository;
    private UnityOfMeasureRepository unityOfMeasureRepository;
    private IngredientRepository ingredientRepository;
    private RecipeRepository recipeRepository;

    //faz a injeção das dependencias via construtora
    public RecipeService(CategoryRepository categoryRepository,
            UnityOfMeasureRepository unityOfMeasureRepository,
            IngredientRepository ingredientRepository,
            RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unityOfMeasureRepository = unityOfMeasureRepository;
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
    }

    

    public void createSpicyChickenRecipe() {
        //cria no bd e entidades a receita de spicy grilled chicken
    }

    public List<Recipe> getRecipes() {
        //retorna a lista de receitas pesistidas na base de dados
        return null;
    }

    public Recipe getRecipe(int id) {
        return null;
    }
}
