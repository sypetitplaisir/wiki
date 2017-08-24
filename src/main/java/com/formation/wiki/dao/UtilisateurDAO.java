package com.formation.wiki.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.TimeoutException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.formation.wiki.ConnexionManager;
import com.formation.wiki.entity.Utilisateur;

public class UtilisateurDAO {

	private EntityManager em;
	private EntityTransaction tx;

	public UtilisateurDAO() {
		super();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_WIKI");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	public String isUserExist(String login, String mdp) throws SQLException, TimeoutException {

		String role_user = null;
		Query q = em.createQuery(
				"select user from Utilisateur user where user.login = :login and " + "user.password= : mdp");
		q.setParameter("login", login);
		q.setParameter("mdp", mdp);
		Utilisateur user_exist = (Utilisateur) q.getSingleResult();
		if (user_exist != null) {
			role_user = user_exist.getRole().getName();
		}
		return role_user;
		/*
		 * boolean found = false; int count=0; String
		 * request="select * from utilisateur where login='"+login+"'and pass='"
		 * +mdp+"'";
		 * 
		 * try { Connection c = ConnexionManager.getConnexion(); Statement st;
		 * st = c.createStatement(); ResultSet rs = st.executeQuery(request);
		 * while (rs.next()) { count++; } if (count > 0 ) { found = true; } }
		 * catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * System.out.println(count+"count"); return found;
		 */
	}

	// Methode d'ajout d'utilisateur
	public void addUser(Utilisateur user) {
		tx.begin();
		em.persist(user);
		// Suppression d'un objet em.remove(entity);
		// Mise à jour d'un objet em.merge(entity);
		// Récupération d'un objet em.find(entityClass, primaryKey);
		tx.commit();
	}

	public Utilisateur findbyId(int id) {
		Query q = em.createNamedQuery("Utilisateur.findById");
		q.setParameter("id", id);
		Utilisateur user = (Utilisateur) q.getSingleResult();
		return user;
	}

	public void changerEtatUser(Utilisateur user) {
		if (user.getActiver() == false) {
			user.setActiver(true);
		} else {
			user.setActiver(false);
		}
		tx.begin();
		em.merge(user);
		tx.commit();
	}

	public void inscription(Utilisateur user) throws UserAlredyExistException {
		
		try {
			if (isUserExist(user.getLogin(), user.getPassword()) == null) {
				 addUser(user);
			} else {
				throw new UserAlredyExistException();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public List<Utilisateur> getAllUtilisateur() {
		
		Query q= em.createNamedQuery("Utilisateur.findAll");
		return q.getResultList();		
		
	}
	
	public static Utilisateur getuser(int idUser) {

		String request = "select * from utilisateur where idUser=" + idUser;

		Utilisateur u = null;
		try {
			Connection c = ConnexionManager.getConnexion();
			Statement st;
			st = c.createStatement();
			ResultSet rs = st.executeQuery(request);
			if (rs.next()) {
				u = new Utilisateur();
				u.setIdUser(rs.getInt("idUser"));
				u.setLogin(rs.getString("login"));
				u.setPassword(rs.getString("pass"));
				u.setNom(rs.getString("nom"));
				u.setPrenom(rs.getString("prenom"));
				u.setEmail(rs.getString("email"));
				u.setTel(rs.getString("tel"));
				System.out.println(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	public static boolean insertUser(String ilogin, String ipass, String inom, String iprenom, String iemail,
			String itel) {

		// String request="INSERT INTO
		// utilisateur(login,pass,nom,prenom,email,tel) VALUES
		// ('toto1','1234','toto1','titi1','toto@gmail.com','112233445566')";
		String request = "INSERT INTO utilisateur(login,pass,nom,prenom,email,tel) VALUES ('" + ilogin + "','" + ipass
				+ "','" + inom + "','" + iprenom + "','" + iemail + "','" + itel + "')";
		boolean insertOK = false;

		Connection c = ConnexionManager.getConnexion();

		try {
			Statement st = c.createStatement();
			int a = st.executeUpdate(request); // faire mise a jour inserion
			System.out.println("nbr utilisateur inseré avec success : " + a);
			insertOK = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insertOK;

	}
}
