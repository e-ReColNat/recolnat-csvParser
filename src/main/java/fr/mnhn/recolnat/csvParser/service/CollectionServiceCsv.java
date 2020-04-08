package fr.mnhn.recolnat.csvParser.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import fr.mnhn.recolnat.csvParser.bean.SpecimenBean;

public class CollectionServiceCsv {
	
	public static List<SpecimenBean> getCollectionFromCsv(String fileName) throws IOException {
	    //Date now = new Date(System.currentTimeMillis());
	    
	    List<SpecimenBean> specimens = null;
	    
	    // Hashmap to map CSV data to bean attributes. 
        Map<String, String> mapping = new HashMap<String, String>();
        
        mapping.put("Objecttype", "objectType"); 
        mapping.put("Barcodeboxdatamatrix", "barcodeBoxDataMatrix"); 
        mapping.put("Barcodecoverdatamatrix", "barcodeCoverDataMatrix"); 
        mapping.put("Barcode", "barcode"); 
        mapping.put("Herbariumname", "herbariumName");
        mapping.put("institutionCode", "InstitutionCode"); 
        mapping.put("CollectionCode", "collectionCode"); 
        mapping.put("Sheettype", "sheettype"); 
        mapping.put("Token", "token"); 
        mapping.put("Herbariumname", "herbariumName");
        mapping.put("Location", "location"); 
        mapping.put("Scanneridentification", "scannerIdentification"); 
        mapping.put("Daytimeoriginal", "daytimeOriginal"); 
        mapping.put("Imagesourcepublic", "imageSourcePublic"); 
        mapping.put("Imagesource", "imageSource");
        mapping.put("Collector", "collector"); 
        mapping.put("CollectionName", "collectionName"); 
        mapping.put("CollectionTB_ID", "collectionTBid");
        mapping.put("Family", "family"); 
        mapping.put("Genus", "genus"); 
        mapping.put("Species", "species"); 
        mapping.put("Authorship", "authorship"); 
        mapping.put("Fullscientificname", "fullscientificname");

        Path myPath = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(myPath,StandardCharsets.UTF_8)) {

            // HeaderColumnNameTranslateMappingStrategy for Specimen class 
            //HeaderColumnNameTranslateMappingStrategy<SpecimenBean> strategy = new HeaderColumnNameTranslateMappingStrategy<SpecimenBean>(); 
            
            HeaderColumnNameMappingStrategy<SpecimenBean> strategy = new HeaderColumnNameMappingStrategy<SpecimenBean>();
            strategy.setType(SpecimenBean.class); 
            //strategy.setColumnMapping(mapping); 
            
            @SuppressWarnings({ "unchecked", "rawtypes" })
			CsvToBean<SpecimenBean> csvToBean = new CsvToBeanBuilder(br)
                    .withType(SpecimenBean.class)
                    .withMappingStrategy(strategy)
                    .withSeparator('	')
                    .build();
            
            specimens = csvToBean.parse();
            
            specimens.forEach(System.out::println);
        }
        
		return specimens;
	}

}
