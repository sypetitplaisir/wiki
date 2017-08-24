package com.formation.wiki.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.formation.wiki.ConnexionManager;
import com.formation.wiki.entity.Article;
import com.formation.wiki.entity.Statut;
import com.formation.wiki.entity.Utilisateur;

public class ArticleDAO {

	private EntityManager em;
	private EntityTransaction tx;

	public ArticleDAO() {
		super();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_WIKI");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}
	
	
	public void addArticle(Article article) {
		tx.begin();
		em.persist(article);
		// Suppression d'un objet em.remove(entity);
		// Mise à jour d'un objet em.merge(entity);
		// Récupération d'un objet em.find(entityClass, primaryKey);
		tx.commit();
	}
	
	public void modifyArticle(Article article) {
		tx.begin();
		em.merge(article);
		tx.commit();
	}
	
	public void deleteArticle(Article article) {
		tx.begin();
		em.remove(article);
		tx.commit();
	}
	
	public Article articleFindbyId(int id) {
		Query q = em.createNamedQuery("Article.findById");
		q.setParameter("id", id);
		Article article = (Article) q.getSingleResult();
		return article;
	}
	
	public List<Article> articleFindbyTitle(String title) {
		Query q = em.createNamedQuery("Article.findByTitle");
		q.setParameter("title", title);
		return q.getResultList();
	}
	
	public List<Article> articlefindbyTitle(String keywords) {
		Query q = em.createNamedQuery("Article.findByKeywords");
		q.setParameter("keywords", keywords);
		return q.getResultList();
	}
	
	public List<Article> getAllArticle() {
		Query q= em.createNamedQuery("Article.findAll");
		return q.getResultList();		
	}
	
	public void changerStatut (Article article, Statut s) {

		article.setStatut(s);
		tx.begin();
		em.merge(article);
		tx.commit();
		
	}
	
	public static boolean AjouterArticle(String inom, String icontenu, int idUser) throws TimeoutException{

		boolean insertOK=false;
		
		String request = "INSERT INTO article(nom,contenu,idUser) VALUES ('" + inom + "','" + icontenu + "','" + idUser
				+ "')";

		Connection c = ConnexionManager.getConnexion();

		try {
			Statement st = c.createStatement();
			int a = st.executeUpdate(request); // faire mise a jour inserion
			insertOK = true;
			System.out.println("nbr article inseré avec success : " + a);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insertOK;

	}

	// Recuperer All Liste d'articles
	public static List<Article> RecupererListeArticle() {

		String request = "select * from article";

		List<Article> listArticle = null;

		// recuperqtion de la connexion
		Connection c = ConnexionManager.getConnexion();
		try {
			// recuperation du statement
			// objet qui va nous permettre d'excuter des requetes SQL
			Statement st = c.createStatement();

			// int a = st.executeUpdate(request); // faire mise a jour inserion
			// System.out.println("nbr Client inseré avec success : "+a);

			ResultSet rs = st.executeQuery(request);
			listArticle = new ArrayList<Article>();

			while (rs.next()) {
				Article a = new Article();
/*
				a.setIdArticle(rs.getInt("idArticle"));
				a.setNom(rs.getString("nom"));
				a.setContenu(rs.getString("contenu"));
				a.setIdUser(rs.getInt("idUser"));
*/
				listArticle.add(a);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listArticle;
	}

	// Recuperer Liste d'articles by ID
	public static List<Article> RecupererListeArticleByID(int idArticle) {

		String request = "select * from article where idArticle=" + idArticle;

		List<Article> listArticle = null;

		// recuperqtion de la connexion
		Connection c = ConnexionManager.getConnexion();
		try {
			// recuperation du statement
			// objet qui va nous permettre d'excuter des requetes SQL
			Statement st = c.createStatement();

			// int a = st.executeUpdate(request); // faire mise a jour inserion
			// System.out.println("nbr Client inseré avec success : "+a);

			ResultSet rs = st.executeQuery(request);
			listArticle = new ArrayList<Article>();

			while (rs.next()) {
				Article a = new Article();
/*
				a.setIdArticle(rs.getInt("idArticle"));
				a.setNom(rs.getString("nom"));
				a.setContenu(rs.getString("contenu"));
				a.setIdUser(rs.getInt("idUser"));
*/
				listArticle.add(a);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listArticle;
	}
	
	// Recuperer Liste d'articles by Name
		public static List<Article> RecupererListeArticleByName(String iNom) {

			String request = "select * from article where nom="+"'"+iNom+"'";

			List<Article> listArticle = null;

			// recuperqtion de la connexion
			Connection c = ConnexionManager.getConnexion();
			try {
				// recuperation du statement
				// objet qui va nous permettre d'excuter des requetes SQL
				Statement st = c.createStatement();

				// int a = st.executeUpdate(request); // faire mise a jour inserion
				// System.out.println("nbr Client inseré avec success : "+a);

				ResultSet rs = st.executeQuery(request);
				listArticle = new ArrayList<Article>();

				while (rs.next()) {
					Article a = new Article();
/*
					a.setIdArticle(rs.getInt("idArticle"));
					a.setNom(rs.getString("nom"));
					a.setContenu(rs.getString("contenu"));
					a.setIdUser(rs.getInt("idUser"));
*/
					listArticle.add(a);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return listArticle;
		}
		

		// Supprimer l'article by idArticle
		
		public static boolean SupprimerArticle(int idArticle) throws ArticleNotExistException {

			boolean supprimeOK=false;
			String request = "DELETE FROM article WHERE idArticle="+idArticle;

			// recuperqtion de la connexion
			Connection c = ConnexionManager.getConnexion();
			try {
				// recuperation du statement
				// objet qui va nous permettre d'excuter des requetes SQL
				Statement st = c.createStatement();

				int a = st.executeUpdate(request); // faire mise a jour inserion
				
				if (a > 0) {
					supprimeOK=true;
					System.out.println(a+": mise a jour supprimer"+idArticle+" : article a supprimé");
				} else {
					throw new ArticleNotExistException();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return supprimeOK;
		}
		
}
