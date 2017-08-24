package com.formation.wiki.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
	@NamedQuery(name="Article.findAll", query="SELECT a FROM Article a")
	,@NamedQuery(name="Article.findById",query="SELECT a FROM Article a WHERE a.id = :id")
	,@NamedQuery(name="Article.findByTitle",query="SELECT a FROM Article a WHERE a.title = :title")
	,@NamedQuery(name="Article.findByKeywords",query="SELECT a FROM Article a WHERE a.keywords = :keywords")
})


public class Article implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String title;
	private String keywords;
	
	@Temporal(TemporalType.DATE)
	private Date publishDate;
	private String content;
	
	@Lob
	@Column(name="PHOTO")
	private Serializable photo;
	
	/*
	private int idArticle;
	private String nom;
	private String contenu;
	private int idUser;
	*/
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Utilisateur user;
	
	@OneToMany(fetch=FetchType.LAZY)
	private List<Commentaire> commentaires;
	
	@OneToOne
	private Statut statut;

	public Article() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeyworkds(String keyworkds) {
		this.keywords = keyworkds;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Serializable getPhoto() {
		return photo;
	}

	public void setPhoto(Serializable photo) {
		this.photo = photo;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
	

	/*
	public Article(int idArticle, String nom, String contenu, int idUser) {
		super();
		this.idArticle = idArticle;
		this.nom = nom;
		this.contenu = contenu;
		this.idUser = idUser;
	}

	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", nom=" + nom + ", contenu=" + contenu + ", idUser=" + idUser + "]";
	}
*/
	
	
}
