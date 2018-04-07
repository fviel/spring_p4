/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.recipe.repositories;

import com.fernando.recipe.entities.Ingredient;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Fernando
 */
public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
    
}
