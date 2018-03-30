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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author fviel
 */
@Entity
@Table(name = "tb_notes")
public class Notes  implements Serializable {

    private static final long serialVersionUID = 37830943408126L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_notes")
    private int idNotes;

    @Column(name = "notes")
    private String notes;

    public int getIdNotes() {
        return idNotes;
    }

    public void setIdNotes(int idNotes) {
        this.idNotes = idNotes;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Notes(int idNotes, String notes) {
        this.idNotes = idNotes;
        this.notes = notes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idNotes;
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
        final Notes other = (Notes) obj;
        if (this.idNotes != other.idNotes) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Notes{" + "idNotes=" + idNotes + ", notes=" + notes + '}';
    }
    
    

}
