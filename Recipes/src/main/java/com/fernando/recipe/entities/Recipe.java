/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.recipe.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Fernando
 */
@Entity
@Table(name = "tb_recipe", schema = "recipe")
public class Recipe {

	@Id
	@SequenceGenerator(name = "RECIPE_ID_SEQ", sequenceName = "tb_recipe_id_seq", schema = "recipe", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RECIPE_ID_SEQ")
	@Column(name = "id_recipe")
	private Integer idRecipe;

	@Column(name="prep_time")
	private Integer prepTime;

	@Column(name="cook_time")
	private Integer cookTime;

	@Column(name="servings")
	private Integer servings;

	@Column(name="source")
	private String source;

	@Column(name="url")
	private String url;

	@Column(name="directions")
	private String directions;

	@Column(name="image")
	private Byte[] image;

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

	public Recipe() {
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 67 * hash + Objects.hashCode(this.idRecipe);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		final Recipe other = (Recipe) obj;
		if(!Objects.equals(this.idRecipe, other.idRecipe)) {
			return false;
		}
		return true;
	}

}
