
package fr.mnhn.recolnat.csvParser.dao.persistence;

import fr.mnhn.recolnat.csvParser.persistence.DataManager;;

public abstract class SuperClassDAO<T> {
	protected DataManager dm;

	/** * Set le DataManager. * * @param * DataManager */
	public void setDataManager(DataManager dm) {
		this.dm = dm;
	}

	/** * Retourne le DataManager. * * @return */
	public DataManager getDataManager() {
		return this.dm;
	}

	/**
	 * * Retourne une entité spécifiée par sa clé primaire. * * @param pk * Clé
	 * primager * @return * T
	 */
	public abstract T get(int pk);
}
