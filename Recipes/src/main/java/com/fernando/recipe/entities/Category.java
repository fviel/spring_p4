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
 * @author Fernando
 */
@Entity
@Table(name = "tb_category"/*, schema = "recipe"*/)
//@Inheritance(strategy = InheritanceType.JOINED)
public class Category {

	@Id
	@SequenceGenerator(name = "CATEGORY_ID_SEQ", sequenceName = "tb_category_id_seq", schema = "recipe", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_ID_SEQ")
	@Column(name = "id_category")
	private int idCategory;

	@Column(name="department_name")
	private String departmentName;

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
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		final Category other = (Category) obj;
		if(this.idCategory != other.idCategory) {
			return false;
		}
		return true;
	}




}
