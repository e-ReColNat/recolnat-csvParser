package fr.mnhn.recolnat.csvParser.service;

import java.util.List;

import fr.mnhn.recolnat.csvParser.dao.jdbc.CollectionDAOjdbc;
import fr.mnhn.recolnat.csvParser.entity.impl.Specimen;

public class CollectionServiceJdbc {
	
	public static List<Specimen> getCollectionFromDb(String collectionCode) {
		List<Specimen> specimens = null;
		
		CollectionDAOjdbc colDAO = new CollectionDAOjdbc();
		
		specimens = colDAO.find(collectionCode);
		
		return specimens;
	}
	
	
	
}
