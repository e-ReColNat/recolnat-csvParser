package fr.mnhn.recolnat.csvParser.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.mnhn.recolnat.csvParser.entity.impl.Specimen;

public class CollectionDAOjdbc extends SuperClassDAOjdbc<Specimen> {

	public List<Specimen> find(String collectionCode) {
		List<Specimen> specimens = new ArrayList<Specimen>();
		try {
            ResultSet result = this .connect
                                    .createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT * FROM Specimens WHERE COLLECTIONCODE = '" + collectionCode + "'"

                                             );

            while(result.next()){
        		Specimen s = new Specimen(result.getString("COLLECTIONCODE"),
        				result.getString("INSTITUTIONCODE"),
        				result.getString("CATALOGNUMBER"),
					    result.getString("DISPOSITION")
        				);
        		specimens.add(s);
            }
            result.close();
         }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
         }finally{
            try{
                 this .connect.close();
            }catch(SQLException se){
            	se.printStackTrace();
            }
         }
		return specimens;
	}

	@Override
	public Specimen update(Specimen obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
//	public Specimen update(Specimen s) {
//		try {
//			
//                this .connect	
//                     .createStatement(
//                    	ResultSet.TYPE_SCROLL_INSENSITIVE, 
//                        ResultSet.CONCUR_UPDATABLE
//                     ).executeUpdate(
//                    	"UPDATE Specimens SET COLLECTIONCODE = '" + s.getCollectionCode() + "'" +
//                    	" WHERE CATALOGNUMBER = '" + s.getCatalogNumber() + "'"
//                     );
//			
//			s = this.find(s.getCatalogNumber(), s.getInstitutionCode(), s.getCollectionCode());
//	    } catch (SQLException e) {
//	            e.printStackTrace();
//	    }
//	    
//	    return s;
//	}

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
