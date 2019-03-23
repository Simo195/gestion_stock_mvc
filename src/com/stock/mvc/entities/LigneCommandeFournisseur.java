package com.stock.mvc.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneCommandeFournisseur implements Serializable {

	@Id
	@GeneratedValue
	private Long IdLigneCdeFrs;
	
	@ManyToOne
	@JoinColumn(name="IdArticle")
	private Article article;
	
	@ManyToOne
	@JoinColumn(name="IdCommandeFournisseur")
	private CommandeFournisseur commandeFournisseur;

	public Long getIdLigneCommandeFournisseur() {
		return IdLigneCdeFrs;
	}

	public void setIdLigneCommandeFournisseur(Long id) {
		this.IdLigneCdeFrs = id;
	}

	public Long getIdLigneCdeFrs() {
		return IdLigneCdeFrs;
	}

	public void setIdLigneCdeFrs(Long idLigneCdeFrs) {
		IdLigneCdeFrs = idLigneCdeFrs;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public CommandeFournisseur getCommandeFournisseur() {
		return commandeFournisseur;
	}

	public void setCommandeFournisseur(CommandeFournisseur commandeFournisseur) {
		this.commandeFournisseur = commandeFournisseur;
	}
	 
	
	
}
