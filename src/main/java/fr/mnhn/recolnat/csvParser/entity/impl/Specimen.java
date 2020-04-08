package fr.mnhn.recolnat.csvParser.entity.impl;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.mnhn.recolnat.csvParser.entity.ISpecimen;

@Entity
@Cacheable( false )
@Table( name = "SPECIMENS" )
@NamedQueries( {
    @NamedQuery(
            name = "Specimen.findAllSpecimens",
            query = "SELECT s FROM Specimen s " 
            		+ "ORDER BY s.modificationDate DESC" ),
    @NamedQuery(
            name = "Specimen.findByCollectionCode",
            query = "SELECT s FROM Specimen s " 
            		+ "WHERE s.collectionCode=:collectionCode "
            		+ "ORDER BY s.modificationDate DESC" )})
public class Specimen implements ISpecimen, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column( name = "OCCURRENCEID" )
    private byte[] occurence;
    
    @Temporal(TemporalType.DATE)
    @Column( name = "MODIFIED" )
    private Date modificationDate;
    
    @Column( name = "COLLECTIONCODE" )
    private String collectionCode;
    
    @Column( name = "INSTITUTIONCODE" )
    private String institutionCode;
    
    @Column( name = "CATALOGNUMBER" )
    private String catalogNumber;
    
    @Column( name = "DISPOSITION" )
    private String disposition;

    // --------------------------------------------------------------
    // Getters
    // --------------------------------------------------------------
    public byte[] getOccurence() {
        return occurence;
    }

    public Date getModificationDate() {
        return modificationDate;
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
	
	public String getCatalogNumber() {
		return catalogNumber;
	}
	
	public void setCatalogNumber(String catalogNumber) {
		this.catalogNumber = catalogNumber;
	}

    // --------------------------------------------------------------
    // 
    // --------------------------------------------------------------
    @Override
    public int hashCode() {
        int hash = 0;
        hash += ( occurence != null ? occurence.hashCode() : 0 );
        return hash;
    }

    @Override
    public boolean equals( Object object ) {
        if ( !( object instanceof Specimen ) ) {
            return false;
        }
        Specimen other = (Specimen) object;
        if ( ( this.occurence == null && other.occurence != null ) || ( this.occurence != null && !this.occurence.equals( other.occurence ) ) ) {
            return false;
        }
        return true;
    }
    
    public Specimen(String collectionCode, 
    		String institutionCode, 
    		String catalogNumber, 
    		String disposition) {
    			this.collectionCode = collectionCode;
    			this.institutionCode = institutionCode;
    			this.catalogNumber = catalogNumber;
    			this.disposition = disposition;
    }

    @Override
    public String toString() {
        return "[ catalog number = " + catalogNumber + " institution code = " + institutionCode + " ]";
    }

	@Override
	public int getPk() {
		// TODO Auto-generated method stub
		return 0;
	}
}
