package ar.edu.um.dao;

// Generated Feb 2, 2014 7:21:27 PM by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ar.edu.um.dao.base.DaoBase;
import ar.edu.um.entidad.Tema;

/**
 * Home object for domain model class Tema.
 * @see ar.edu.um.entidad.Tema
 * @author Hibernate Tools
 */
@Stateless
public class TemaDao extends DaoBase{

	private static final Log log = LogFactory.getLog(TemaDao.class);
	
	public TemaDao(EntityManager em) {
		this.entityManager = em;
	}

	public void persist(Tema transientInstance) {
		log.debug("persisting Tema instance");
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

	public void remove(Tema persistentInstance) {
		log.debug("removing Tema instance");
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

	public Tema merge(Tema detachedInstance) {
		log.debug("merging Tema instance");
		try {
			entityManager.getTransaction().begin();
			Tema result = entityManager.merge(detachedInstance);
			entityManager.getTransaction().commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Tema findById(int id) {
		log.debug("getting Tema instance with id: " + id);
		try {
			Tema instance = entityManager.find(Tema.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
    /**
     * buscarTemaDelMomento: Muestra los temas más mencionados en la última semana
     * 
     * @return List<Tema>
     * 			  - Lista de temas
	 * 
	 */
	public ArrayList<Tema> buscarTemasPorFechas(Date fechaInicio, Date fechaFin){
		ArrayList<Tema> temasDelMomento = null;
		temasDelMomento = (ArrayList<Tema>) getEntityManager().createNamedQuery("Tema.buscarTemaPorFechas").getResultList();
		return temasDelMomento;
	}
	
    /**
     * buscarTemaDelMomento: Muestra los temas más mencionados en la última semana
     * 
     * @return List<Tema>
     * 			  - Lista de temas
	 * 
	 */
	public ArrayList<Tema> buscarTemasDelMomento(){
		ArrayList<Tema> temasDelMomento = null;
		temasDelMomento = (ArrayList<Tema>) getEntityManager().createNamedQuery("Tema.mostrarTemasDelMomento").getResultList();
		return temasDelMomento;
	}
}
