package com.formation.wiki.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.formation.wiki.ConnexionManager;
import com.formation.wiki.entity.Article;
import com.formation.wiki.entity.Commentaire;

public class CommentaireDAO {

	// Ajouter Commentaire
	public static boolean AjouterCommentaire(String icontenu, int idUser, int idArticle) {

		boolean insertOK=false;
		String request = "INSERT INTO commentaire(contenu,idUser,idArticle) VALUES ('" + icontenu + "','" + idUser
				+ "','" + idArticle + "')";

		Connection c = ConnexionManager.getConnexion();

		try {
			Statement st = c.createStatement();
			int a = st.executeUpdate(request); // faire mise a jour inserion
			insertOK=true;
			System.out.println("nbr commentaire inseré avec success : " + a);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insertOK; 
	}

	// Recuperer list de commenatire par article
	public static List<Commentaire> RecupererListeCommentaireParArticle(int idArticle) {

		String request = "select * from commentaire where idArticle="+ idArticle;

		List<Commentaire> listCommentaire = null;

		// recuperqtion de la connexion
		Connection c = ConnexionManager.getConnexion();
		try {
			// recuperation du statement
			// objet qui va nous permettre d'excuter des requetes SQL
			Statement st = c.createStatement();

			// int a = st.executeUpdate(request); // faire mise a jour inserion
			// System.out.println("nbr Client inseré avec success : "+a);

			ResultSet rs = st.executeQuery(request);
			listCommentaire = new ArrayList<Commentaire>();

			while (rs.next()) {
				Commentaire co = new Commentaire();
/*
				co.setIdCommentaire(rs.getInt("idCommentaire"));
				co.setContenu(rs.getString("contenu"));
				co.setIdArticle(rs.getInt("idArticle"));
				co.setIdUser(rs.getInt("idUser"));
*/
				listCommentaire.add(co);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCommentaire;
	}

	// Supprimer commentaire by idCommentaire

	public static boolean SupprimerCommentaire(int idCommentaire) throws CommentaireNotExistException{

		boolean supprimeOK=false;
		String request = "DELETE FROM commentaire WHERE idCommentaire=" + idCommentaire;

		// recuperqtion de la connexion
		Connection c = ConnexionManager.getConnexion();
		try {
			// recuperation du statement
			// objet qui va nous permettre d'excuter des requetes SQL
			Statement st = c.createStatement();

			int a = st.executeUpdate(request); // faire mise a jour inserion
			if (a > 0) {
				System.out.println(a+": mise a jour"+idCommentaire + " : commentaire a supprimé");
				supprimeOK=true;
			} else {
				throw new CommentaireNotExistException();
			}
				

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return supprimeOK;
	}
}
