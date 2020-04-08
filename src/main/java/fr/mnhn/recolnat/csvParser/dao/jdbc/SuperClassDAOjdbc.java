package fr.mnhn.recolnat.csvParser.dao.jdbc;

import java.sql.Connection;

public abstract class SuperClassDAOjdbc<T> {
	
	public Connection connect = ConnectionOracleSQL.getInstance();
	
	/**
	 * Permet de mettre à jour les données d'une entrée dans la base 
	 * @param obj
	 */
	public abstract T update(T obj);
	
	/**
	 * Permet la suppression d'une entrée de la base
	 * @param obj
	 */
	//public abstract void delete(T obj);

}
