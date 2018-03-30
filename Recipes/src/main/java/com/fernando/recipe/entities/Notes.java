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
@Table(name = "tb_notes"/*, schema = "recipe"*/)
public class Notes  implements Serializable {

    private static final long serialVersionUID = 3783093145423408126L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_notes")
    private int idNotes;

    @Column(name = "notes")
    private String notes;

}
