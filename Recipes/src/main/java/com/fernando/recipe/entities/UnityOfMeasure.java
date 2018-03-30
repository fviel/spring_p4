/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.recipe.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author fviel
 */
@Entity
@Table(name = "tb_uom")
public class UnityOfMeasure implements Serializable {

    private static final long serialVersionUID = 3783093145423426L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_uom")
    private int idUom;
    
    @Column(name = "uom")
    private String uom;

    public int getIdUom() {
        return idUom;
    }

    public void setIdUom(int idUom) {
        this.idUom = idUom;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public UnityOfMeasure(int idUom, String uom) {
        this.idUom = idUom;
        this.uom = uom;
    }

    public UnityOfMeasure() {
    }    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.idUom;
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
        final UnityOfMeasure other = (UnityOfMeasure) obj;
        if (this.idUom != other.idUom) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UnityOfMeasure{" + "idUom=" + idUom + ", uom=" + uom + '}';
    }
}
