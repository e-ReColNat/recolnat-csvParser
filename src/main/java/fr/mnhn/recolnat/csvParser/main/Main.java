package fr.mnhn.recolnat.csvParser.main;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import fr.mnhn.recolnat.csvParser.bean.SpecimenBean;
import fr.mnhn.recolnat.csvParser.entity.impl.Specimen;
import fr.mnhn.recolnat.csvParser.service.CollectionServiceCsv;
import fr.mnhn.recolnat.csvParser.service.CollectionServiceJdbc;
import fr.mnhn.recolnat.csvParser.service.SpecimenService;

public class Main {
    
    public static void main(String[] args) {

        // String csvFile = "/home/quentinwable/Documents/CSV_CLF_2015/Ravel/RAVEL_CP1_20150911_BATCH_0006.csv";
        
        List<Specimen> specimens = CollectionServiceJdbc.getCollectionFromDb("JUN");
        
        System.out.println("start get coll");
        for (Specimen s : specimens) {
        	System.out.println(s);
        }
        System.out.println("end get coll");
    }
    
    public static void main_persistence(String[] args) {

        String csvFile = "/home/quentinwable/Documents/CSV_CLF_2015/Ravel/RAVEL_CP1_20150911_BATCH_0006.csv";

//    	List<Specimen> specimens = SpecimenService.retrieveSpecimens("JUN");
    	
//    	List<Specimen> specimens = SpecimenService.retrieveAllSpecimens();
//    	
//    	System.out.println("number of specimen : " + specimens.size());
    	
//    	for (Specimen s : specimens) {
//    		System.out.println(" " + s.getCatalogNumber());
//    	}
    	
        try {
			List<SpecimenBean> specimensCsv = CollectionServiceCsv.getCollectionFromCsv(csvFile);
			List<Specimen> specimensDb = SpecimenService.retrieveAllSpecimens();
	        Hashtable<String, SpecimenBean> specimensDelta = null;
			specimensDelta = SpecimenService.compareSpecimens(specimensCsv, specimensDb);
			
			System.out.println(" size specimens : " + specimensDb.size());
			
			while (specimensDelta.entrySet().iterator().hasNext()) {
				System.out.println(" delta : ");
				System.out.println(specimensDelta.entrySet().iterator().next());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
