package com.stock.mvc.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneCommandeClient implements Serializable {

	@Id
	@GeneratedValue
	private Long IdLigneCdeClt;
	
	@ManyToOne
	@JoinColumn(name="IdArticle")
	private Article article;
	
	@ManyToOne
	@JoinColumn(name="IdCommandeClient")
	private CommandeClient commandeClient;
	
	


	public Long getIdLigneCdeClt() {
		return IdLigneCdeClt;
	}

	public void setIdLigneCdeClt(Long id) {
		this.IdLigneCdeClt = id;
	}
	 
	

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public CommandeClient getCommandeClient() {
		return commandeClient;
	}

	public void setCommandeClient(CommandeClient commandeClient) {
		this.commandeClient = commandeClient;
	}
	
	
}
