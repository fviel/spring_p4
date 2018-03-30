/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.recipe.entities;

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
@Table(name = "tb_notes", schema = "recipe")
public class Notes {

    @Id
    @SequenceGenerator(name = "NOTES_ID_SEQ", sequenceName = "tb_notes_id_seq", schema = "recipe", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTES_ID_SEQ")
    @Column(name = "id_notes")
    private int idNotes;

    @Column(name = "notes")
    private String notes;

}
