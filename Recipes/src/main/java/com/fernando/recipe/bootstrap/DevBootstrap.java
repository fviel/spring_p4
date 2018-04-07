/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.recipe.bootstrap;

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
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * DevBootstrap é uma classe apenas para carregar os dados de teste no sistema.
 *
 * @author Fernando
 */
@Component //transforma em spring bean
//ApplicationListener<ContextRefreshedEvent> é um dos eventos padrões do spring, ainda não entendi direito, mas vou ver
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private CategoryRepository categoryRepository;
    private UnityOfMeasureRepository unityOfMeasureRepository;
    private IngredientRepository ingredientRepository;
    private RecipeRepository recipeRepository;

    //faz a injeção das dependencias via construtora
    public DevBootstrap(CategoryRepository categoryRepository,
            UnityOfMeasureRepository unityOfMeasureRepository,
            IngredientRepository ingredientRepository,
            RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unityOfMeasureRepository = unityOfMeasureRepository;
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        //applicationEvent é o evento da aplicação subir
        initData();
    }

    private void initData() {
        createGuacaMoleRecipe();
    }

    /*
    Método de bootstrap para a receita de Guacamole
     */
    public void createGuacaMoleRecipe() {
        UnityOfMeasure unid = new UnityOfMeasure("Unidade", "A unidade de um item");
        UnityOfMeasure ccha = new UnityOfMeasure("Colher de chá", "Colher pequena de 10ml");
        UnityOfMeasure csopa = new UnityOfMeasure("Colher de sopa", "Colher pequena de 25ml");
        UnityOfMeasure fatia = new UnityOfMeasure("Fatia", "Fatia de um item");
        UnityOfMeasure punhado = new UnityOfMeasure("Punhado", "Punhado de um item");
        UnityOfMeasure cmesa = new UnityOfMeasure("Pitada", "Pitada de um item"); //pinch
        UnityOfMeasure pitada = new UnityOfMeasure("Colher de mesa", "Colher de pau"); //tbspn

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

        Recipe guaca = new Recipe();

        guaca.setDifficulty(Difficulty.MEDIUM);
        guaca.setPrepTime(10);
        guaca.setServings(4);
        guaca.setIngredients(ingr);
        guaca.setCookTime(0);
        guaca.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n"
                + "\n"
                + "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n"
                + "\n"
                + "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n"
                + "\n"
                + "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n"
                + "\n"
                + "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n"
                + "\n"
                + "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n"
                + "\n"
                + "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.");
        guaca.setSource("internet");
        guaca.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/#recipe");

        recipeRepository.save(guaca);

        System.out.println("BOOTSTRAP DE DADOS PARA DESENV - Receita de guacamole adicionada.");
    }

}
