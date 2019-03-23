package com.stock.mvc.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class MvtStk implements Serializable {

	public static final int ENTREE = 1;
		
	public static final int SORTIE = 2;
	
	@Id
	@GeneratedValue
	private Long IdMvtStk;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateMvt;

	private BigDecimal quantite;
	
	private int TypeMvt;
	
	@ManyToOne
	@JoinColumn(name="IdArticle")
	private Article article;
	
	public Long getIdMvtStk() {
		return IdMvtStk;
	}

	public void setIdMvtStk(Long idMvtStk) {
		this.IdMvtStk = idMvtStk;
	}

	public Date getDateMvt() {
		return dateMvt;
	}

	public void setDateMvt(Date dateMvt) {
		this.dateMvt = dateMvt;
	}

	public BigDecimal getQuantite() {
		return quantite;
	}

	public void setQuantite(BigDecimal quantite) {
		this.quantite = quantite;
	}

	public int getTypeMvt() {
		return TypeMvt;
	}

	public void setTypeMvt(int typeMvt) {
		TypeMvt = typeMvt;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	
	 
	
	
}
