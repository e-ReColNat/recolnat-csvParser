package fr.mnhn.recolnat.csvParser.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionOracleSQL {
	/**
	 * URL de connection
	 */
	private static String url = "jdbc:oracle:thin:@cimaprod.mnhn.fr:1515/cimaprod.mnhn.fr";
	/**
	 * Nom du user
	 */
	private static String user = "RECOLNATEST";
	/**
	 * Mot de passe du user
	 */
	private static String passwd = "essaiwp2";
	/**
	 * Objet Connection
	 */
	private static Connection connect;
	
	/**
	 * Méthode qui va nous retourner notre instance
	 * et la créer si elle n'existe pas...
	 * @return
	 */
	public static Connection getInstance(){
		if(connect == null){
			try {
				connect = DriverManager.getConnection(url, user, passwd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return connect;	
	}	

}
