package ar.edu.um.dao;

// Generated Feb 2, 2014 7:21:27 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ar.edu.um.dao.base.DaoBase;
import ar.edu.um.entidad.TipoUsuario;

/**
 * Home object for domain model class TipoUsuario.
 * @see ar.edu.um.entidad.TipoUsuario
 * @author Hibernate Tools
 */
@Stateless
public class TipoUsuarioDao extends DaoBase{

	private static final Log log = LogFactory.getLog(TipoUsuarioDao.class);

	public TipoUsuarioDao(EntityManager em) {
		this.entityManager = em;
	}

	public void persist(TipoUsuario transientInstance) {
		log.debug("persisting TipoUsuario instance");
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

	public void remove(TipoUsuario persistentInstance) {
		log.debug("removing TipoUsuario instance");
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

	public TipoUsuario merge(TipoUsuario detachedInstance) {
		log.debug("merging TipoUsuario instance");
		try {
			entityManager.getTransaction().begin();
			TipoUsuario result = entityManager.merge(detachedInstance);
			entityManager.getTransaction().commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TipoUsuario findById(int id) {
		log.debug("getting TipoUsuario instance with id: " + id);
		try {
			TipoUsuario instance = entityManager.find(TipoUsuario.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
