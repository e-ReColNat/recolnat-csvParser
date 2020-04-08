package fr.mnhn.recolnat.csvParser.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

public class DataManager {

    private EntityManagerFactory emf = null;
    private EntityManager        em;

    /**
     * Constructeur de la classe DataManager
     * 
     * @param EntityManagerFactory
     *            emf
     */
    public DataManager( EntityManagerFactory emf ) {
        this.emf = emf;
    }

    /**
     * Retourne un EntityManager
     * 
     * @return EntityManager
     */
    public EntityManager getEntityManager() {
        if ( em == null || !em.isOpen() ) {
            em = emf.createEntityManager();
        }
        return em;
    }

    /**
     * Retourne un EntityManager
     * 
     * @return EntityManager
     */
    @SuppressWarnings( { "unchecked", "rawtypes" } )
    public EntityManager getEntityManager( String schema ) {
        if ( em == null || !em.isOpen() ) {
            Map map = new HashMap();
            map.put( "schema", schema );
            map.put( "privateDataAvailable", true );
            em = emf.createEntityManager( map );
        }
        return em;
    }

    /**
     * Ferme le manager des entités gérées
     */
    public void closeEntityManager() {
        if ( em != null && em.isOpen() )
            em.close();
    }

    /**
     * Efface le contexte de persistence, toutes les entités gérées seront
     * détachées.
     */
    public void clearInstance() {
        getEntityManager().clear();
    }

    /**
     * Création d'un objet de type T
     * 
     * @param t
     * @return T
     * @throws EntityExistsException
     * @throws PersistenceException
     */
    public <T> T create( T t ) throws EntityExistsException, PersistenceException {
        getEntityManager().persist( t );
        return t;
    }

    /**
     * Commence une transaction
     */
    public void createTransactional() {
        getEntityManager().getTransaction().begin();
    }

    /**
     * Commit une transaction
     */
    public void closeTransactional() {
        getEntityManager().getTransaction().commit();
    }

    /**
     * Supprime l'entité du contexte de persistence, l'entité gérée sera détaché
     * 
     * @param t
     */
    public void detach( Object t ) {
        getEntityManager().detach( t );
    }

    /**
     * Mise à jour de l'objet de type T
     * 
     * @param t
     * @return T
     * @throws PersistenceException
     */
    public <T> T edit( final T t ) throws PersistenceException {
        return getEntityManager().merge( t );
    }

    /**
     * Recherche d'un objet de class entityClass et de clé primaire pk
     * 
     * @param entityClass
     * @param pk
     * @return T
     */
    public <T> T find( Class<T> entityClass, Object pk ) {
        return getEntityManager().find( entityClass, pk );
    }

    /**
     * Synchronise le contexte de persistence avec la base de données
     */
    public void flush() {
        getEntityManager().flush();
    }

    /**
     * Retourne l'objet transaction
     */
    public EntityTransaction getTransaction() {
        return getEntityManager().getTransaction();
    }

    /**
     * Indique si la transaction est active
     */
    public boolean isActive() {
        return getEntityManager().getTransaction().isActive();
    }

    /**
     * Met à jour l'état de l'instance à partir de la base de données
     * 
     * @param t
     */
    public void refresh( Object t ) {
        getEntityManager().refresh( t );
    }

    /**
     * Supprime un objet de type T
     * 
     * @param t
     * @throws PersistenceException
     */
    public <T> void remove( final T t ) throws PersistenceException {
        getEntityManager().remove( getEntityManager().merge( t ) );
    }

    /**
     * Rollback
     */
    public void rollback() {
        if ( getEntityManager().getTransaction().isActive() )
            getEntityManager().getTransaction().rollback();
    }

}
