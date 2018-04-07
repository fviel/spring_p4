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
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fernando
 */
@Service
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

    public void createGuacaMoleRecipe() {
        UnityOfMeasure unid = new UnityOfMeasure("Unidade", "A unidade de um item");
        UnityOfMeasure ccha = new UnityOfMeasure("Colher de chá", "Colher pequena de 10ml");
        UnityOfMeasure csopa = new UnityOfMeasure("Colher de sopa", "Colher pequena de 25ml");
        UnityOfMeasure fatia = new UnityOfMeasure("Fatia", "Fatia de um item");
        UnityOfMeasure punhado = new UnityOfMeasure("Punhado", "Punhado de um item");
        UnityOfMeasure cmesa = new UnityOfMeasure("Pitada", "Pitada de um item"); //pinch
        UnityOfMeasure pitada = new UnityOfMeasure("Colher de mesa", "Colher de pau"); //tbspn

        unityOfMeasureRepository.save(unid);
        unityOfMeasureRepository.save(ccha);
        unityOfMeasureRepository.save(csopa);
        unityOfMeasureRepository.save(fatia);

        Ingredient abacate = new Ingredient("Abacate", new BigDecimal(2.0), unid);
        Ingredient sal = new Ingredient("Sal", new BigDecimal(0.5), ccha);
        Ingredient sucolimao = new Ingredient("Suco fresco de limão", new BigDecimal(1.0), csopa);
        Ingredient cebola = new Ingredient("Cebola", new BigDecimal(2.0), csopa);
        Ingredient pimenta = new Ingredient("Pimenta sem sementes", new BigDecimal(2.0), unid);
        Ingredient coentro = new Ingredient("Coentro finamente picado", new BigDecimal(2.0), csopa);
        Ingredient tomate = new Ingredient("Tomate", new BigDecimal(0.5), unid);

        List<Ingredient> ingr = new ArrayList<>();
        ingr.add(sal);
        ingr.add(abacate);
        ingr.add(sucolimao);
        ingr.add(cebola);
        ingr.add(pimenta);
        ingr.add(coentro);
        ingr.add(tomate);
        
        ingredientRepository.saveAll(ingr);        
        
        Recipe guaca = new Recipe();
        guaca.setDifficulty(Difficulty.MEDIUM);
        guaca.setPrepTime(10);
        guaca.setServings(4);
        guaca.setIngredients(ingr);
        
        recipeRepository.save(guaca);
        
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
