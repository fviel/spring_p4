/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.recipe.repositories;

import com.fernando.recipe.entities.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Fernando
 */
public interface CategoryRepository extends CrudRepository<Category, Integer>{
    
}
