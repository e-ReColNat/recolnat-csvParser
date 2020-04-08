package fr.mnhn.recolnat.csvParser.dao.persistence;

import fr.mnhn.recolnat.csvParser.entity.impl.Specimen;

public class FactoryDAO {
	
    public static SuperClassDAO<Specimen> getSpecimenDAO() {
        return new SpecimenDAO();
    }


}
