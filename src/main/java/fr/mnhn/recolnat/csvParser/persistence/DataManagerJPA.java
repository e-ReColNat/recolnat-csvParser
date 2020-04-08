package fr.mnhn.recolnat.csvParser.persistence;

import java.util.logging.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataManagerJPA {

    private static DataManagerJPA dataManagerJPA = null;
    private EntityManagerFactory  emf            = null;

    private static final Logger   logger         = Logger.getLogger( DataManagerJPA.class.getName() );

    /**
     * Constructeur de la classe DataManagerJPA
     */
    private DataManagerJPA() {
        emf = createFactory( "specimenPU" );;
    }

    /**
     * Retourne un singleton
     * 
     * @return DataManagerJPA
     */
    public final static DataManagerJPA getInstance() {
        if ( dataManagerJPA == null ) {
            synchronized ( DataManagerJPA.class ) {
                if ( dataManagerJPA == null ) {
                    dataManagerJPA = new DataManagerJPA();
                    logger.info( "Initialisation du service CollectionService via le mapping" );
                }
            }
        }
        return dataManagerJPA;
    }

    /**
     * Création d'un EntityManagerFactory pour le contexte de persistence
     * désigné par son nom
     * 
     * @param persistenceUnitName
     * @return EntityManagerFactory
     */
    private EntityManagerFactory createFactory( String persistenceUnitName ) {
        EntityManagerFactory emf = null;

        try {
            emf = Persistence.createEntityManagerFactory( persistenceUnitName );
        } catch ( NullPointerException e ) {
            logger.severe( "Une erreur s'est produite lors de la création d'un EntityManagerFactory." );
            emf = null;
        }

        return emf;
    }

    /**
     * Retourne l'EntityManagerFactory du contexte de persistence
     * 
     * @return EntityManagerFactory
     */
    public EntityManagerFactory emf() {
        return emf;
    }

    /**
     * Ferme et supprime l'EntityManagerFactory
     */
    public void removeFactory( EntityManagerFactory emf ) {
        if ( emf != null && emf.isOpen() ) {
            emf.close();
            emf = null;
        }
    }

    /**
     * Ferme et supprime les EntityManagerFactory
     */
    public void removeFactories() {
        if ( emf != null && emf.isOpen() ) {
            emf.close();
            emf = null;
        }
    }

}
