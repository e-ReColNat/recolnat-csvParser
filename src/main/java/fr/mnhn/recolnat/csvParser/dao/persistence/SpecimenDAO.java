package fr.mnhn.recolnat.csvParser.dao.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import fr.mnhn.recolnat.csvParser.entity.impl.Specimen;


public class SpecimenDAO extends SuperClassDAO<Specimen> {
	private static final Logger logger = Logger.getLogger(Specimen.class.getName());

	/**
	 * * Retourne le specimen spécifié par sa clé primaire. 
	 * * @param pk * Clé
	 * * @return un specimen
	 */
	@Override
	public Specimen get(int pk) {
		return (dm != null ? dm.find(Specimen.class, pk) : null);
	}

	/**
	 * * Retourne une liste de specimen en fonction des parametres suivants :
	 * * @param institutionCode
	 * * @param collectionCode
	 * * @param catalogNumber
	 * * @return Une liste de clé primaire de specimen.
	 */
	public List<Integer> getSpecimen(String institutionCode, String collectionCode, String catalogNumber) {
		List<Integer> specimens = new ArrayList<Integer>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT s.occurenceid ");
		sql.append(" FROM SPECIMENS s ");
		sql.append(" WHERE s.INSTITUTIONCODE=:institutionCode AND s.CATALOGNUMBER:=catalogNumber ");
		//sql.append(filter.getOrderByClause());
		TypedQuery<Integer> query = dm.getEntityManager().createQuery(sql.toString(), Integer.class);
		query.setParameter("institutionCode", institutionCode);
		query.setParameter("catalogNumber", catalogNumber);
		specimens = query.getResultList();
		return specimens;
	}


	/**
	 * * Retourne la liste de tous les articles. * * @return * une liste d'articles
	 */
	public List<Specimen> findAllSpecimens() {
		List<Specimen> specimens = null;
		try {
			TypedQuery<Specimen> query = dm.getEntityManager().createNamedQuery("Specimen.findAllSpecimens",
					Specimen.class);
			//query.setParameter("type", ISpecimen.TYPE_ARTICLE);
			//query.setMaxResults(24);
			specimens = query.getResultList();
		} catch (PersistenceException e) {
			logger.log(Level.SEVERE, "Une erreur est survenue lors la récupération de la liste des specimens.", e);
		}
		return specimens;
	}


	/**
	 * * Retourne la liste des derniers articles d'un utilisateur. * * @return * une
	 * liste d'articles
	 */
	public List<Specimen> findByCollectionCode(String collectionCode) {
		List<Specimen> specimens = null;
		try {
			TypedQuery<Specimen> query = dm.getEntityManager().createNamedQuery("Specimen.findByCollectionCode", Specimen.class);
			//query.setParameter("type", ISpecimen.TYPE_ARTICLE);
			query.setParameter("collectionCode", collectionCode);
			query.setMaxResults(3);
			specimens = query.getResultList();
			//System.out.println("here");
		} catch (PersistenceException e) {
			logger.log(Level.SEVERE,
					"Une erreur est survenue lors la récupération de la liste des derniers specimen par collection code ="
							+ collectionCode + ".",
					e);
		}
		return specimens;
	}
}
