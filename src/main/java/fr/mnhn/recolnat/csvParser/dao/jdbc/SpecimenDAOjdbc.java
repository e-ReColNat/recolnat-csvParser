package fr.mnhn.recolnat.csvParser.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.mnhn.recolnat.csvParser.entity.impl.Specimen;

public class SpecimenDAOjdbc extends SuperClassDAOjdbc<Specimen> {

	public Specimen find(String catalogNumber, String institutionCode, String collectionCode) {
		Specimen s = null;
		try {
            ResultSet result = this .connect
                                    .createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT * FROM Specimen WHERE catalognumber = " + catalogNumber
                                                + " AND institutioncode = " + institutionCode
                                                + " AND collectioncode = " + collectionCode
                                             );
            if(result.first())
            		s = new Specimen(result.getString("CATALOGNUMBER"),
            				result.getString("INSTITUTIONCODE"),
            				result.getString("COLLECTIONCODE"),
            				result.getString("DISPOSITION")
            				);
            
		    } catch (SQLException e) {
		            e.printStackTrace();
		    }
		   return s;

	}
	
	
	public Specimen update(Specimen s) {
		try {
			
                this .connect	
                     .createStatement(
                    	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE
                     ).executeUpdate(
                    	"UPDATE Specimens SET COLLECTIONCODE = '" + s.getCollectionCode() + "'" +
                    	" WHERE CATALOGNUMBER = '" + s.getCatalogNumber() + "'"
                     );
			
			s = this.find(s.getCatalogNumber(), s.getInstitutionCode(), s.getCollectionCode());
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	    
	    return s;
	}

//	@Override
//	public void delete(Specimen obj) {
//		try {
//			
//                this    .connect
//                    	.createStatement(
//                             ResultSet.TYPE_SCROLL_INSENSITIVE, 
//                             ResultSet.CONCUR_UPDATABLE
//                        ).executeUpdate(
//                             "DELETE FROM langage WHERE lan_id = " + obj.getId()
//                        );
//			
//	    } catch (SQLException e) {
//	            e.printStackTrace();
//	    }
//	}


}
