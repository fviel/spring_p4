/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.recipe.controllers;

import com.fernando.recipe.entities.Category;
import com.fernando.recipe.entities.UnityOfMeasure;
import com.fernando.recipe.repositories.CategoryRepository;
import com.fernando.recipe.repositories.UnityOfMeasureRepository;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Fernando
 */
@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnityOfMeasureRepository unityOfMeasureRepository;

    //faz a injeção das dependencias via construtora
    public IndexController(CategoryRepository categoryRepository, UnityOfMeasureRepository unityOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unityOfMeasureRepository = unityOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        String p1 = "Comida brasileira";
        String p2 = "um copinho fervendo";
        try {

            Optional<Category> categoryOptional = categoryRepository.findByDescription(p1);
            Optional<UnityOfMeasure> unityOfMeasureOptional = unityOfMeasureRepository.findByDescription(p2);

            System.out.println("[" + categoryOptional.get().getIdCategory() + "]Category: " + categoryOptional.get().getDescription());
            System.out.println("[" + unityOfMeasureOptional.get().getIdUom() + "]Unity of measure: " + unityOfMeasureOptional.get().getDescription());
        } catch (NoSuchElementException nsee) {
            System.out.println("Elemento não encontrado: " + nsee.getCause());
        }
        
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("uoms", unityOfMeasureRepository.findAll());

        return "index";
    }

}
