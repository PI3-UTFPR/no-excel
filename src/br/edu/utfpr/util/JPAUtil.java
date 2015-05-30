package br.edu.utfpr.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public final class JPAUtil {
	
	private static String PERSISTENCE_UNIT = "noexcelPU";
	
	private static ThreadLocal<EntityManager> threadEntityManager =
			new ThreadLocal<EntityManager>();
	
	private static EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	private JPAUtil() {}    
 
    public static void beginTransaction(){
    	EntityManager entityManager = threadEntityManager.get();    	
    	
    	if (entityManager == null) {
    		entityManager = getEntityManager();
    	}
    	
        entityManager.getTransaction().begin();
    }
     
    public static void commit(){
    	EntityManager entityManager = threadEntityManager.get();    	
    	
    	if (entityManager == null) {
    		entityManager = getEntityManager();
    	}
    	
    	EntityTransaction transaction = entityManager.getTransaction();
    	
    	if(transaction != null && transaction.isActive()){
    		entityManager.getTransaction().commit();
    	}        
    }
         
    public static void rollBack(){
    	EntityManager entityManager = threadEntityManager.get();    	
    	
    	if (entityManager == null) {
    		entityManager = getEntityManager();
    	}
    	
    	EntityTransaction transaction = entityManager.getTransaction();
    	
    	if(transaction != null && transaction.isActive()){
    		entityManager.getTransaction().rollback();
    	}
    }    
	
	public static EntityManager getEntityManager() {		
		if (entityManagerFactory == null) {
			entityManagerFactory =
				Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		}		
		
		EntityManager entityManager = threadEntityManager.get();
		
		if (entityManager == null || !entityManager.isOpen()) {
			entityManager = entityManagerFactory.createEntityManager();
			JPAUtil.threadEntityManager.set(entityManager);
		}
		
		return entityManager;
	}
	
	public static void closeEntityManager() {
		EntityManager em = threadEntityManager.get();
		
		if (em != null) {		
			em.close();			
			threadEntityManager.set(null);
		}
	}
	
	public static void closeEntityManagerFactory() {		
		closeEntityManager();
		entityManagerFactory.close();		
	}	
}


