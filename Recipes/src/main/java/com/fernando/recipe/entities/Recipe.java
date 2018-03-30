/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.recipe.entities;

import com.fernando.recipe.enums.Difficulty;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Fernando
 */
@Entity
@Table(name = "tb_recipe")
public class Recipe implements Serializable {

    private static final long serialVersionUID = 3793145423408126L;

    /*@Id
	@SequenceGenerator(name = "RECIPE_ID_SEQ", sequenceName = "tb_recipe_id_seq", schema = "recipe", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RECIPE_ID_SEQ")
	@Column(name = "id_recipe")
	private Integer idRecipe;*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_recipe")
    private Integer idRecipe;

    @Column(name = "prep_time")
    private Integer prepTime;

    @Column(name = "cook_time")
    private Integer cookTime;

    @Column(name = "servings")
    private Integer servings;

    @Column(name = "source")
    private String source;

    @Column(name = "url")
    private String url;

    @Column(name = "directions")
    private String directions;

    @Lob
    private Byte[] image;
    
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private List<Ingredient> ingredients;
    
    
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;
    
    //-------------------------------------

    public Integer getIdRecipe() {
        return idRecipe;
    }

    public void setIdRecipe(Integer idRecipe) {
        this.idRecipe = idRecipe;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public Recipe() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idRecipe);
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
        final Recipe other = (Recipe) obj;
        if (!Objects.equals(this.idRecipe, other.idRecipe)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Recipe{" + "idRecipe=" + idRecipe + ", prepTime=" + prepTime + ", cookTime=" + cookTime + ", servings=" + servings + ", source=" + source + ", url=" + url + ", directions=" + directions + ", image=" + image + ", difficulty=" + difficulty + ", ingredients=" + ingredients + ", notes=" + notes + '}';
    }
}
