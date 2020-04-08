package fr.mnhn.recolnat.csvParser.service;

import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import fr.mnhn.recolnat.csvParser.bean.SpecimenBean;
import fr.mnhn.recolnat.csvParser.dao.persistence.FactoryDAO;
import fr.mnhn.recolnat.csvParser.dao.persistence.SpecimenDAO;
import fr.mnhn.recolnat.csvParser.entity.impl.Specimen;
import fr.mnhn.recolnat.csvParser.persistence.DataManager;
import fr.mnhn.recolnat.csvParser.persistence.DataManagerJPA;

public class SpecimenService {
	
	public static List<Specimen> retrieveSpecimens(String collectionCode) {
	    Date now = new Date(System.currentTimeMillis());
	    EntityManagerFactory emf = DataManagerJPA.getInstance().emf();
	    DataManager dm = new DataManager( emf );
	    List<Specimen> specimens = null; 
		try {
			dm.createTransactional();
			
	        // on recupere les specimens pour une collection donnée
			SpecimenDAO SpecimenDAO = (SpecimenDAO) FactoryDAO.getSpecimenDAO();
			SpecimenDAO.setDataManager( dm );
			specimens = SpecimenDAO.findByCollectionCode(collectionCode);
			dm.closeTransactional();
		} catch (Exception e) {
			System.out.println(" issue : " + e);
		}
		
		return specimens;
	}
	
	public static List<Specimen> retrieveAllSpecimens() {
	    Date now = new Date(System.currentTimeMillis());
	    EntityManagerFactory emf = DataManagerJPA.getInstance().emf();
	    DataManager dm = new DataManager( emf );
	    List<Specimen> specimens = null; 
		try {
			dm.createTransactional();
			
	        // on recupere les specimens pour une collection donnée
			SpecimenDAO SpecimenDAO = (SpecimenDAO) FactoryDAO.getSpecimenDAO();
			SpecimenDAO.setDataManager( dm );
			specimens = SpecimenDAO.findAllSpecimens();
			
			dm.closeTransactional();
		} catch (Exception e) {
			System.out.println(" issue : " + e);
		}
		
		return specimens;
	}
	
	
	
	public static Hashtable<String, SpecimenBean> compareSpecimens(List<SpecimenBean> specimensCol, List<Specimen> specimensDb) {
		Hashtable<String, SpecimenBean> specimensColByKey = new Hashtable<String, SpecimenBean>();
		
		for (SpecimenBean s : specimensCol) {
			if (s.getObjectType() == "Sheet") {
				String key = s.getInstitutionCode() + s.getCollectionCode() + s.getBarcode();
				specimensColByKey.put(key,s);
			}
		}
		
		Hashtable<String, SpecimenBean> specimensDelta = new Hashtable<String, SpecimenBean>();
		
		for (Specimen s : specimensDb) {
				String key = s.getInstitutionCode() + s.getCollectionCode() + s.getCatalogNumber();
				if (specimensColByKey.contains(key)) {
					specimensDelta.put(key, specimensColByKey.get(key));
				}
		}
		
		return specimensDelta;
		
	}
}
