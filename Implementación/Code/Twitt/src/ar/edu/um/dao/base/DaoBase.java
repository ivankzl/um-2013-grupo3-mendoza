package ar.edu.um.dao.base;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DaoBase {
	
	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * @param entityManager the entityManager to set
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void runQuery(){
		entityManager.createNamedQuery("name").getResultList();
	}
	

}
