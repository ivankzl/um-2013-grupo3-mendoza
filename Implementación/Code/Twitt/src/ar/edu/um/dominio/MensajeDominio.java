/**
 * $Author:  $
 * 
 * Revision History
 * $Log: MensajeDominio.java,v $ *
 *
 */
package ar.edu.um.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import ar.edu.um.dao.MensajeDao;
import ar.edu.um.entidad.Mensaje;
import ar.edu.um.entidad.Tema;
import ar.edu.um.entidad.Usuario;
import ar.edu.um.util.PersistenceUtil;

/**
 * MensajeDominio ofrece los métodos para manejar mensajes
 * 
 * $Id: $
 * 
 */
@WebService
public class MensajeDominio {
	
    /**
     * publicarMensaje: Crea mensajes en la DB
     * 
     * @param Mensaje
     *            - Mensaje a crear
     * 
     */
	public void publicarMensaje(Mensaje mensaje){
		MensajeDao mensajeDao = new MensajeDao(PersistenceUtil.getEntityManager());
		mensajeDao.insertar(mensaje);
	}
	
    /**
     * republicarMensaje: Crea mensajes en la DB cuando el mensaje fue inicialmente creado por otro usuario
     * 
     * @param Mensaje
     *            - Mensaje a crear
     * @param Usuario
     * 			  - Usuario creador del mensaje original
     * 
     */
	public void republicarMensaje(Mensaje mensaje, Usuario usuarioRepublicante){
		MensajeDao mensajeDao = new MensajeDao(PersistenceUtil.getEntityManager());
		mensajeDao.insertar(mensaje);
	}
	
    /**
     * modificarMensaje: Modifica mensajes en la DB
     * 
     * @param Mensaje
     *            - Mensaje a modificar
     * 
     */
	public void modificarMensaje (Mensaje mensaje){
		MensajeDao mensajeDao = new MensajeDao(PersistenceUtil.getEntityManager());
		mensajeDao.actualizar(mensaje);
	}
	
    /**
     * eliminarMensaje: Elimina mensajes en la DB
     * 
     * @param Mensaje
     *            - Mensaje a eliminar
     * 
     */
	public void eliminarMensaje(Mensaje mensaje){
		MensajeDao mensajeDao = new MensajeDao(PersistenceUtil.getEntityManager());
		mensajeDao.eliminar(mensaje);
	}
	
    /**
     * visualizarTablon: Busca mensajes en la DB relacionados a un usuario
     * 
     * @param Usuario
     *            - Usuario a buscar
     *            
     * @return List<Mensaje>
     * 			  - Lista de Mensajes
     */
	public ArrayList<Mensaje> visualizarTablon(Usuario usuario){
		ArrayList<Mensaje> mensajes = null;
		MensajeDao mensajeDao = new MensajeDao(PersistenceUtil.getEntityManager());
		mensajes = mensajeDao.buscarMensajesTablon(usuario);		
		return mensajes;
	}
	
    /**
     * visualizarMenciones: Busca mensajes con menciones en la DB relacionados a un usuario
     * 
     * @param Usuario
     *            - Usuario a buscar
     *            
     * @return List<Mensaje>
     * 			  - Lista de Mensajes
     */
	public List<Mensaje> visualizarMenciones(Usuario usuario){
		ArrayList<Mensaje> mensajes = null;
		MensajeDao mensajeDao = new MensajeDao(PersistenceUtil.getEntityManager());
		mensajes = mensajeDao.visualizarMenciones(usuario);
		return mensajes;
	}
	
    /**
     * verMensajesPrivados: Busca mensajes privados en la DB relacionados a un usuario
     * 
     * @param Usuario
     *            - Usuario a buscar
     *            
     * @return List<Mensaje>
     * 			  - Lista de Mensajes
     */
	public List<Mensaje> verMensajesPrivados(Usuario usuario){
		ArrayList<Mensaje> mensajes = null;
		MensajeDao mensajeDao = new MensajeDao(PersistenceUtil.getEntityManager());
		mensajes = mensajeDao.verMensajesPrivados(usuario);
		return mensajes;
	}
	
    /**
     * enviarMensajePrivado: Crea mensajes privados en la DB
     * 
     * @param Mensaje
     *            - Mensaje a crear
     * 
     */
	public void enviarMensajePrivado(Mensaje mensaje){
		MensajeDao mensajeDao = new MensajeDao(PersistenceUtil.getEntityManager());
		mensajeDao.insertar(mensaje);
	}
	
    /**
     * buscarMensajePorTema: Busca mensajes en la DB relacionados a un tema
     * 
     * @param Tema
     *            - Tema a buscar
     *            
     * @return List<Mensaje>
     * 			  - Lista de Mensajes
     */
	public List<Mensaje> buscarMensajesPorTema(Tema tema){
		ArrayList<Mensaje> mensajes = null;
		MensajeDao mensajeDao = new MensajeDao(PersistenceUtil.getEntityManager());
		mensajes=mensajeDao.buscarMensajesPorTema(tema);
		return mensajes;
	}
	
    /**
     * buscarMensajePorUsuario: Busca mensajes en la DB relacionados a un usuario
     * 
     * @param Usuario
     *            - Usuario a buscar
     *            
     * @return List<Mensaje>
     * 			  - Lista de Mensajes
     */
    public List<Mensaje> buscarMensajesPorUsuario(Usuario usuario){
		ArrayList<Mensaje> mensajes = null;
		MensajeDao mensajeDao = new MensajeDao(PersistenceUtil.getEntityManager());
		mensajes = mensajeDao.buscarMensajesPorUsuario(usuario);
		return mensajes;
	}
    

}
