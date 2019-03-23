	package com.stock.mvc.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category implements Serializable {

	@Id
	@GeneratedValue
	private Long IdCategory;
	
	private String code;
	
	private String Designation;
	
	@OneToMany(mappedBy="category")
	private List<Article> articles;

	public Category() {
		
	}
	
	public Long getIdCategory() {
		return IdCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.IdCategory = idCategory;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	 
	
	
}
