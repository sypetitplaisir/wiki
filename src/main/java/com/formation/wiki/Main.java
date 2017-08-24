package com.formation.wiki;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import com.formation.wiki.dao.ArticleDAO;
import com.formation.wiki.dao.CommentaireDAO;
import com.formation.wiki.dao.UtilisateurDAO;
import com.formation.wiki.entity.Article;
import com.formation.wiki.entity.Commentaire;
import com.formation.wiki.entity.Utilisateur;

public class Main {

	public static void testUtilisateur() {

		Utilisateur u = new Utilisateur();
		UtilisateurDAO uDAO = new UtilisateurDAO();
		Role r = new Role();
		u.setLogin("david");
		u.setPassword("1234");
		u.setNom("david");
		u.setPrenom("manon");
		u.setActiver(true);
		u.setEmail("ace@gmail.com");
		
		u.setRole();
		uDAO.addUser(u);
		
	}

	public static void main(String[] args) throws SQLException, TimeoutException {

		testUtilisateur();
		
		/*
		 * if (UtilisateurDAO.isUserExist("toto5","1234")) {
		 * System.out.println("UserExist"); } else {
		 * System.out.println("NOT Exist"); }
		 * 
		 * UtilisateurDAO.getuser(1); UtilisateurDAO.getuser(2);
		 * UtilisateurDAO.getuser(3);
		 * 
		 * //UtilisateurDAO.insertUser("toto5","1234","toto5","titi5",
		 * "titi5@gmail.com","112233445566");
		 * //UtilisateurDAO.insertUser("toto5","1234","toto5","titi5",
		 * "titi5@gmail.com","112233445566");
		 * 
		 * // Ajouter Article //ArticleDAO.AjouterArticle("PremiereArticle",
		 * "Contenu de la premiere article", 1);
		 * //ArticleDAO.AjouterArticle("DeuxiemeArticle",
		 * "Contenu de la deuxeme article", 2);
		 * 
		 * // recuperer all lists de l'article
		 * System.out.println("All list de l'article"); List<Article>
		 * listAllArticle = ArticleDAO.RecupererListeArticle();
		 * 
		 * for(Article a: listAllArticle ) { System.out.println(a); }
		 * 
		 * // recuperer article by Id
		 * System.out.println("List de l'article by ID"); List<Article>
		 * listArticleById = ArticleDAO.RecupererListeArticleByID(3);
		 * 
		 * for(Article b: listArticleById ) { System.out.println(b); }
		 * 
		 * // recuperer article by Name
		 * 
		 * System.out.println("List de l'article by Name"); List<Article>
		 * listArticleByName =
		 * ArticleDAO.RecupererListeArticleByName("DeuxiemeArticle");
		 * 
		 * for(Article c: listArticleByName ) { System.out.println(c); }
		 * 
		 * // supperimer l'article //ArticleDAO.SupprimerArticle(3);
		 * 
		 * 
		 * // Ajouter Commentaire
		 * //CommentaireDAO.AjouterCommentaire("mycommentaire", 2, 2);
		 * 
		 * 
		 * // recuperer all list de commentaire
		 * System.out.println("List de Commentaire"); List<Commentaire>
		 * listCommentaire =
		 * CommentaireDAO.RecupererListeCommentaireParArticle(2);
		 * for(Commentaire co: listCommentaire ) { System.out.println(co); }
		 * 
		 * // supperimer commentaire //CommentaireDAO.SupprimerArticle(4);
		 */
	}
}
