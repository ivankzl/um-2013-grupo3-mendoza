package ar.edu.um.dao;

// Generated Feb 2, 2014 7:21:27 PM by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ar.edu.um.dao.base.DaoBase;
import ar.edu.um.entidad.Mensaje;
import ar.edu.um.entidad.Tema;
import ar.edu.um.entidad.Usuario;

/**
 * Home object for domain model class Mensaje.
 * @see ar.edu.um.entidad.Mensaje
 * @author Hibernate Tools
 */
@Stateless
public class MensajeDao extends DaoBase{

	private static final Log log = LogFactory.getLog(MensajeDao.class);
	
	public MensajeDao(EntityManager em) {
		this.entityManager = em;
	}

	public void insertar(Mensaje transientInstance) {
		log.debug("persisting Mensaje instance");
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

	public void eliminar(Mensaje persistentInstance) {
		log.debug("removing Mensaje instance");
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

	public Mensaje actualizar(Mensaje detachedInstance) {
		log.debug("merging Mensaje instance");
		try {
			entityManager.getTransaction().begin();
			Mensaje result = entityManager.merge(detachedInstance);
			entityManager.getTransaction().commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Mensaje encontrarPorID(int id) {
		log.debug("getting Mensaje instance with id: " + id);
		try {
			Mensaje instance = entityManager.find(Mensaje.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
    /**
     * buscarTemaDelMomento: Busca mensajes en la DB relacionados a un usuario
     * 
     * @param Usuario
     *            - Usuario a buscar
     *            
     * @return List<Mensaje>
     * 			  - Lista de Mensajes
	 */
	public ArrayList<Mensaje> buscarMensajesTablon(Usuario usuario){
		ArrayList<Mensaje> mensajesTablon = null;
		List<Integer> idsUsuarios= new ArrayList<Integer>();
		idsUsuarios.add(usuario.getIdusuario());
		for(int i=0; i<usuario.getUsuariosSeguidos().size(); i++)
			idsUsuarios.add(((Usuario)usuario.getUsuariosSeguidos().toArray()[0]).getIdusuario());
		
		mensajesTablon = (ArrayList<Mensaje>) getEntityManager().createNamedQuery("Mensaje.mostrarMensajesTablon").
				setParameter("usuarios",idsUsuarios).setParameter("idUsuario",usuario.getIdusuario()).
				getResultList();
		return mensajesTablon;
	}
	
	 /**
     * visualizarMenciones: Busca mensajes en la DB relacionados a un usuario mencionado
     * 
     * @param Usuario
     *            - Usuario a buscar
     *            
     * @return List<Mensaje>
     * 			  - Lista de Mensajes
	 */
	public ArrayList<Mensaje> visualizarMenciones(Usuario usuario){
		ArrayList<Mensaje> mensajes = null;
		mensajes = (ArrayList<Mensaje>) getEntityManager().createNamedQuery("Mensaje.visualizarMenciones").
				setParameter("idUsuario",usuario.getIdusuario()).getResultList();
		return mensajes;
	}
	
	 /**
     * verMensajesPrivados: Busca mensajes  privados en la DB relacionados a un usuario
     * 
     * @param Usuario
     *            - Usuario a buscar
     *            
     * @return List<Mensaje>
     * 			  - Lista de Mensajes
	 */
	public ArrayList<Mensaje> verMensajesPrivados(Usuario usuario){
		ArrayList<Mensaje> mensajes = null;
		mensajes = (ArrayList<Mensaje>) getEntityManager().createNamedQuery("Mensaje.verMensajesPrivados").
				setParameter("idUsuario",usuario.getIdusuario()).getResultList();
		return mensajes;
	}
	
	 /**
     * buscarMensajePorTema: Busca mensajes relacionados con un tema
     * 
     * @param Tema
     *            - Tema a buscar
     *            
     * @return List<Mensaje>
     * 			  - Lista de Mensajes
	 */
	public ArrayList<Mensaje> buscarMensajesPorTema(Tema tema){
		ArrayList<Mensaje> mensajes = null;
		mensajes = (ArrayList<Mensaje>) getEntityManager().createNamedQuery("Mensaje.buscarMensajePorTema").
				setParameter("tema",tema.getNombre()).getResultList();
		return mensajes;
	}
	
	 /**
     * buscarMensajesPorUsuario: Busca mensajes en la DB relacionados a un usuario
     * 
     * @param Usuario
     *            - Usuario a buscar
     *            
     * @return List<Mensaje>
     * 			  - Lista de Mensajes
	 */
	public ArrayList<Mensaje> buscarMensajesPorUsuario(Usuario usuario){
		ArrayList<Mensaje> mensajes = null;
		mensajes = (ArrayList<Mensaje>) getEntityManager().createNamedQuery("Mensaje.buscarMensajesPorUsuario").
				setParameter("idUsuario",usuario.getIdusuario()).getResultList();
		return mensajes;
	}
}
