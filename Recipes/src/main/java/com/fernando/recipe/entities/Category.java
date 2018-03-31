/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.recipe.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Fernando
 */
@Entity
@Table(name = "tb_category")
public class Category implements Serializable {

    private static final long serialVersionUID = 359314542340812L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_category")
    private int idCategory;

    @Column(name = "department_name")
    private String departmentName;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Category() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.idCategory;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Category other = (Category) obj;
        if (this.idCategory != other.idCategory) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Category{" + "idCategory=" + idCategory + ", departmentName=" + departmentName + ", recipes=" + recipes + '}';
    }
    
    

}
