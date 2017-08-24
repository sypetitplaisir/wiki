package com.formation.wiki;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionManager {

	public static String url = "jdbc:mysql://localhost:3306/wiki1";
	public static String user = "root";
	public static String password = "";

	public static Connection getConnexion() {
		Connection con = null;
		try {
			// pour charger driver JDBC
			Class.forName("com.mysql.jdbc.Driver");
			// pour recuperer une connexion
			con = DriverManager.getConnection(url, user, password);
			//System.out.println("connexion etablit avec success");

		} catch (ClassNotFoundException e) {
			System.out.println("Error los du chargement du driver");
		} catch (SQLException e) {
			System.out.println("Error los de la connexion à la BDD");
		}
		return con;
	}
}
