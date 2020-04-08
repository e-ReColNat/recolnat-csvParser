package fr.mnhn.recolnat.csvParser.bean;

import java.sql.Timestamp;

import com.opencsv.bean.CsvBindByName;

public class SpecimenBean {
	
	@CsvBindByName(column = "Objecttype")
	private String 		objectType;
	
	@CsvBindByName(column = "Barcodeboxdatamatrix")
	private String 		barcodeBoxDataMatrix;
	
	@CsvBindByName(column = "Barcodecoverdatamatrix")
	private String 		barcodeCoverDataMatrix;
	
	@CsvBindByName(column = "Barcode")
	private String 		barcode;
	
	@CsvBindByName(column = "Herbariumname")
	private String 		herbariumName;
	
	@CsvBindByName(column = "Institutioncode")
	private String 		institutionCode;
	
	@CsvBindByName(column = "Collectioncode")
	private String 		collectionCode;
	
	@CsvBindByName(column = "Sheettype")
	private String 		sheettype;
	
	@CsvBindByName(column = "Token")
	private String 		token;
	
	@CsvBindByName(column = "Location")
	private String 		location;
	
	@CsvBindByName(column = "Scanneridentification")
	private String 		scannerIdentification;
	
	//@CsvBindByName(column = "Daytimeoriginal")
	private Timestamp 	daytimeOriginal;
	
	@CsvBindByName(column = "Imagesourcepublic")
	private String 		imageSourcePublic;
	
	@CsvBindByName(column = "Imagesource")
	private String 		imageSource;
	
	@CsvBindByName(column = "Collector")
	private String		collector;
	
	@CsvBindByName(column = "Collectionname")
	private String		collectionName;
	
	@CsvBindByName(column = "CollectionTB_ID")
    private Long		collectionTBid;
    
	@CsvBindByName(column = "Family")
    private String 		family;
    
	@CsvBindByName(column = "Genus")
    private String		genus;
    
	@CsvBindByName(column = "Species")
    private String 		species;
    
	@CsvBindByName(column = "Authorship")
    private String		authorship;
    
	@CsvBindByName(column = "Fullscientificname")
    private String 		fullscientificname;
    
	public String getObjectType() {
		return objectType;
	}
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	public String getBarcodeBoxDataMatrix() {
		return barcodeBoxDataMatrix;
	}
	public void setBarcodeBoxDataMatrix(String barcodeBoxDataMatrix) {
		this.barcodeBoxDataMatrix = barcodeBoxDataMatrix;
	}
	public String getBarcodeCoverDataMatrix() {
		return barcodeCoverDataMatrix;
	}
	public void setBarcodeCoverDataMatrix(String barcodeCoverDataMatrix) {
		this.barcodeCoverDataMatrix = barcodeCoverDataMatrix;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getHerbariumName() {
		return herbariumName;
	}
	public void setHerbariumName(String herbariumName) {
		this.herbariumName = herbariumName;
	}
	public String getInstitutionCode() {
		return institutionCode;
	}
	public void setInstitutionCode(String institutionCode) {
		this.institutionCode = institutionCode;
	}
	public String getCollectionCode() {
		return collectionCode;
	}
	public void setCollectionCode(String collectionCode) {
		this.collectionCode = collectionCode;
	}
	public String getSheettype() {
		return sheettype;
	}
	public void setSheettype(String sheettype) {
		this.sheettype = sheettype;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getScannerIdentification() {
		return scannerIdentification;
	}
	public void setScannerIdentification(String scannerIdentification) {
		this.scannerIdentification = scannerIdentification;
	}
	public Timestamp getDaytimeOriginal() {
		return daytimeOriginal;
	}
	public void setDaytimeOriginal(Timestamp daytimeOriginal) {
		this.daytimeOriginal = daytimeOriginal;
	}
	public String getImageSourcePublic() {
		return imageSourcePublic;
	}
	public void setImageSourcePublic(String imageSourcePublic) {
		this.imageSourcePublic = imageSourcePublic;
	}
	public String getImageSource() {
		return imageSource;
	}
	public void setImageSource(String imageSource) {
		this.imageSource = imageSource;
	}
	public String getCollector() {
		return collector;
	}
	public void setCollector(String collector) {
		this.collector = collector;
	}
	public String getCollectionName() {
		return collectionName;
	}
	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}
	public Long getCollectionTBid() {
		return collectionTBid;
	}
	public void setCollectionTBid(Long collectionTBid) {
		this.collectionTBid = collectionTBid;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public String getGenus() {
		return genus;
	}
	public void setGenus(String genus) {
		this.genus = genus;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getAuthorship() {
		return authorship;
	}
	public void setAuthorship(String authorship) {
		this.authorship = authorship;
	}
	public String getFullscientificname() {
		return fullscientificname;
	}
	public void setFullscientificname(String fullscientificname) {
		this.fullscientificname = fullscientificname;
	}
    
	@Override
	public String toString() {
		return "SpecimenBean [barcode=" + barcode + ", herbariumName=" + herbariumName + ", institutionCode="
				+ institutionCode + ", collectionCode=" + collectionCode + ", family=" + family + ", species=" + species
				+ ", fullscientificname=" + fullscientificname + "]";
	}
    
}
