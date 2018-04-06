/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.recipe.services;

import com.fernando.recipe.entities.Recipe;
import com.fernando.recipe.entities.UnityOfMeasure;
import com.fernando.recipe.repositories.CategoryRepository;
import com.fernando.recipe.repositories.UnityOfMeasureRepository;
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

    //faz a injeção das dependencias via construtora
    public RecipeService(CategoryRepository categoryRepository, UnityOfMeasureRepository unityOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unityOfMeasureRepository = unityOfMeasureRepository;
    }
    
    public void createGuacaMoleRecipe(){
        UnityOfMeasure u1 = new UnityOfMeasure("Unidade","A unidade de um item");
        UnityOfMeasure u2 = new UnityOfMeasure("Colher de chá","Colher pequena de 10ml");
        UnityOfMeasure u3 = new UnityOfMeasure("Colher de sopa","Colher pequena de 25ml");
        UnityOfMeasure u4 = new UnityOfMeasure("Fatia","Fatia de um item");
        
        unityOfMeasureRepository.save(u1);
        unityOfMeasureRepository.save(u2);
        unityOfMeasureRepository.save(u3);
        unityOfMeasureRepository.save(u4);
    }
    
    public void createSpicyChickenRecipe(){
        //cria no bd e entidades a receita de spicy grilled chicken
    }
    
    public List<Recipe> getRecipes(){
        //retorna a lista de receitas pesistidas na base de dados
        return null;
    }
    
    public Recipe getRecipe(int id){
        return null;
    }
}
