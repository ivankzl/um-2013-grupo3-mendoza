package ar.edu.um.dao;

// Generated Feb 2, 2014 7:21:27 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ar.edu.um.dao.base.DaoBase;
import ar.edu.um.entidad.TipoMensaje;

/**
 * Home object for domain model class TipoMensaje.
 * @see ar.edu.um.entidad.TipoMensaje
 * @author Hibernate Tools
 */
@Stateless
public class TipoMensajeDao extends DaoBase{

	private static final Log log = LogFactory.getLog(TipoMensajeDao.class);
	
	public TipoMensajeDao(EntityManager em) {
		this.entityManager = em;
	}

	public void persist(TipoMensaje transientInstance) {
		log.debug("persisting TipoMensaje instance");
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(transientInstance);
			entityManager.getTransaction().commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TipoMensaje persistentInstance) {
		log.debug("removing TipoMensaje instance");
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(persistentInstance);
			entityManager.getTransaction().commit();
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TipoMensaje merge(TipoMensaje detachedInstance) {
		log.debug("merging TipoMensaje instance");
		try {
			entityManager.getTransaction().begin();
			TipoMensaje result = entityManager.merge(detachedInstance);
			entityManager.getTransaction().commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TipoMensaje findById(int id) {
		log.debug("getting TipoMensaje instance with id: " + id);
		try {
			TipoMensaje instance = entityManager.find(TipoMensaje.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
