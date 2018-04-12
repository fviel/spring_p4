/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.recipe.entities;

import com.fernando.recipe.enums.Difficulty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recipe")
    private Integer idRecipe;
    
    @Column(name="title")
    private String title;

    @NotNull
    @Column(name = "prep_time")
    private Integer prepTime;

    @NotNull
    @Column(name = "cook_time")
    private Integer cookTime;

    @NotNull
    @Column(name = "servings")
    private Integer servings;

    @NotNull
    @Column(name = "source", length=120)
    private String source;

    @NotNull
    @Column(name = "url", length=120)
    private String url;

    @NotNull
    @Column(name = "directions", length=4096, columnDefinition = "TEXT")
    private String directions;
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_hr_insert", updatable=false)
    private Date dtHrInsert;
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_hr_update")
    private Date dtHrUpdate;

    @Lob
    private Byte[] image;
    
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private List<Ingredient> ingredients;
        
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_notes")
    private Notes notes;
    
    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "id_recipe"),
            inverseJoinColumns = @JoinColumn(name = "id_category"))
    private Set<Category> categories;
    
    @Version
    private Long version;
    //-------------------------------------

    @PrePersist
    public void setInsertTime(){
        this.dtHrInsert = new Date();
        this.dtHrUpdate = new Date();
    }
    
    @PreUpdate
    public void setUpdateTime(){
        this.dtHrUpdate = new Date();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }    
    
    public Date getDtHrInsert() {
        return dtHrInsert;
    }

    public void setDtHrInsert(Date dtHrInsert) {
        this.dtHrInsert = dtHrInsert;
    }

    public Date getDtHrUpdate() {
        return dtHrUpdate;
    }

    public void setDtHrUpdate(Date dtHrUpdate) {
        this.dtHrUpdate = dtHrUpdate;
    }    
    
    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
    
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
        
        //autoseta que cada ingrediente pertence a recipe:
        for(Ingredient i:ingredients){
            i.setRecipe(this);
        }
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
        return "Recipe{" + "idRecipe=" + idRecipe + ", title=" + title + ", prepTime=" + prepTime + ", cookTime=" + cookTime + ", servings=" + servings + ", source=" + source + ", url=" + url + ", directions=" + directions + ", dtHrInsert=" + dtHrInsert + ", dtHrUpdate=" + dtHrUpdate + ", image=" + image + ", difficulty=" + difficulty + ", ingredients=" + ingredients + ", notes=" + notes + ", categories=" + categories + ", version=" + version + '}';
    }
}
