package ar.edu.um.dao;

// Generated Feb 2, 2014 7:21:27 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ar.edu.um.dao.base.DaoBase;
import ar.edu.um.entidad.Usuario;

/**
 * Home object for domain model class Usuario.
 * @see ar.edu.um.entidad.Usuario
 * @author Hibernate Tools
 */
@Stateless
public class UsuarioDao extends DaoBase{

	private static final Log log = LogFactory.getLog(UsuarioDao.class);
	
	public UsuarioDao(EntityManager em) {
		this.entityManager = em;
	}

	public void insertar(Usuario transientInstance) {
		log.debug("persisting Usuario instance");
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

	public void eliminar(Usuario persistentInstance) {
		log.debug("removing Usuario instance");
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

	public Usuario actualizar(Usuario detachedInstance) {
		log.debug("merging Usuario instance");
		try {
			entityManager.getTransaction().begin();
			Usuario result = entityManager.merge(detachedInstance);
			entityManager.getTransaction().commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Usuario encontrarPorID(int id) {
		log.debug("getting Usuario instance with id: " + id);
		try {
			Usuario instance = entityManager.find(Usuario.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	/**
     * iniciarSesion: Loguea un usuario en el sistema
     * 
     * @param Usuario
     *            - Usuario que realizó la acción
     * @param Clave
     * 			  - Clave del usuario
     *            
     * @return Usuario logueado
     */	
	public Usuario iniciarSesion(String nombreUsuario, String clave){
		Usuario usuario = null;
		try{
			usuario = (Usuario) entityManager.createNamedQuery("Usuario.loguearUsuario")
					.setParameter("nombreUsuario", nombreUsuario).setParameter("clave", clave)
					.getSingleResult();				
		}catch(NoResultException nrEx){
			log.error("Error al iniciar sesión para usuario: " + nombreUsuario);
		}
		
		return usuario;
	}
	
	/**
     * buscarUsuariosPorNombre: buscar un usuario por nombre
     * 
     * @param nombreUsuario
     *            - Nombre de usuario a buscar
     * @return Lista de usuarios encontrados
     */	
	public List<Usuario> buscarUsuariosPorNombre(String nombreUsuario){
		List<Usuario> usuario = null;
		try{
			usuario = entityManager.createNamedQuery("Usuario.buscarUsuarioPorNombre")
					.setParameter("nombreUsuario", nombreUsuario)
					.getResultList();				
		}catch(NoResultException nrEx){
			log.error("Error al buscar usuario: " + nombreUsuario);
		}
		
		return usuario;
	}
}
