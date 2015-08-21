package ar.edu.um.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
    static EntityManagerFactory emf = null;
    static EntityManager em = null;
    
    public static EntityManager getEntityManager() {
        if(em == null) {
        	emf = Persistence.createEntityManagerFactory("Twitt");
            em = emf.createEntityManager();
        }
        return em;
     }

}
