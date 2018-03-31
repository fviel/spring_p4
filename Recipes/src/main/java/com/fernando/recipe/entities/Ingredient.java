/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.recipe.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fernando.recipe.entities.UnityOfMeasure;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author fviel
 */
@Entity
@Table(name = "tb_ingredient")
public class Ingredient implements Serializable {

    private static final long serialVersionUID = 3593145423408126L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_ingredient")
    private int idIngredient;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "amount")
    private BigDecimal amount;
    
    @OneToOne
    @JoinColumn(name = "fk_uom")
    private UnityOfMeasure uom;
    
    @ManyToOne
    @JoinColumn(name = "fk_recipe")
    private Recipe recipe;

    public int getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(int idIngredient) {
        this.idIngredient = idIngredient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public UnityOfMeasure getUom() {
        return uom;
    }

    public void setUom(UnityOfMeasure uom) {
        this.uom = uom;
    }

    public Ingredient(int idIngredient, String description, BigDecimal amount, UnityOfMeasure uom) {
        this.idIngredient = idIngredient;
        this.description = description;
        this.amount = amount;
        this.uom = uom;
    }

    public Ingredient() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.idIngredient;
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
        final Ingredient other = (Ingredient) obj;
        if (this.idIngredient != other.idIngredient) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ingredient{" + "idIngredient=" + idIngredient + ", description=" + description + ", amount=" + amount + ", uom=" + uom + '}';
    }
}
