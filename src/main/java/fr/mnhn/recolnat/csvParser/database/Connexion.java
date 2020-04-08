package fr.mnhn.recolnat.csvParser.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

	public static void main2(String[] args) {

        try {
        	String url = "jdbc:oracle:thin:@cimaprod.mnhn.fr:1515/cimaprod.mnhn.fr";
        	String user = "RECOLNATEST";
        		
        	Connection conn = DriverManager.getConnection(url, user, "essaiwp2");

            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
            
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
