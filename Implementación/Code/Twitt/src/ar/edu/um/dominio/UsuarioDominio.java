/**
 * $Author:  $
 * 
 * Revision History
 * $Log: UsuarioDominio.java,v $ *
 *
 */
package ar.edu.um.dominio;

import java.util.List;
import java.util.Set;

import javax.jws.WebService;

import ar.edu.um.dao.UsuarioDao;
import ar.edu.um.entidad.Usuario;
import ar.edu.um.util.PersistenceUtil;

/**
 * UsuarioDominio ofrece los métodos para manejar usuarios
 * 
 * $Id: $
 * 
 */
@WebService
public class UsuarioDominio {
	
    /**
     * crearUsuario: Crea usuarios en la DB
     * 
     * @param Usuario
     *            - Usuario a crear
     * 
     */
	public void crearUsuario(Usuario usuario){
		UsuarioDao usuarioDao = new UsuarioDao(PersistenceUtil.getEntityManager());
		usuarioDao.insertar(usuario);
	}
	
    /**
     * verUsuario: Muestra un usuario de la DB
     * 
     * @param Integer
     *            - Id del usuario a mostrar
     * @return Usuario
     * 			  - Usuario encontrado - Null si no se encontró ninguno
     * 
     */
	public Usuario verUsuario(Integer id){
		Usuario usuario = null;
		UsuarioDao usuarioDao = new UsuarioDao(PersistenceUtil.getEntityManager());
		usuarioDao.encontrarPorID(id);
		return usuario;
	}
	
	/**
     * modificarUsuario: Modifica usuarios en la DB
     * 
     * @param Usuario
     *            - Usuario a modificar
     * 
     */
	public void modificarUsuario(Usuario usuario){
		UsuarioDao usuarioDao = new UsuarioDao(PersistenceUtil.getEntityManager());
		usuarioDao.actualizar(usuario);		
	}
	
	/**
     * eliminarUsuario: Elimina usuarios en la DB
     * 
     * @param Usuario
     *            - Usuario a eliminar
     * 
     */	
	public void eliminarUsuario (Usuario usuario){
		UsuarioDao usuarioDao = new UsuarioDao(PersistenceUtil.getEntityManager());
		usuarioDao.eliminar(usuario);
	}
	
    /**
     * consultarSeguidores: Muestra los seguidores de un usuario
     * 
     * @param Usuario
     *            - Usuario sobre el que se desean ver los seguidores
     * @return List<Usuario>
     * 			  - Lista de usuarios seguidores
     * 
     */
	public Set<Usuario> consultarSeguidores(Usuario usuario){
		UsuarioDao usuarioDao = new UsuarioDao(PersistenceUtil.getEntityManager());
		usuarioDao.encontrarPorID(usuario.getIdusuario());
		
		return usuario.getUsuariosSeguidores();
	}
	
    /**
     * consultarSeguidos: Muestra los seguidos de un usuario
     * 
     * @param Usuario
     *            - Usuario sobre el que se desean ver los seguidos
     * @return List<Usuario>
     * 			  - Lista de usuarios seguidos
     * 
     */
	public Set<Usuario> consultarSeguidos(Usuario usuario){		
		UsuarioDao usuarioDao = new UsuarioDao(PersistenceUtil.getEntityManager());
		usuarioDao.encontrarPorID(usuario.getIdusuario());
		
		return usuario.getUsuariosSeguidos();
	}
	
	/**
     * buscarUsuariosPorNombre: Busca usuarios por nombre
     * 
     * @param String
     *            - Nombre del usuario a buscar
     * @return Usuario
     *            - Usuarios encontrados
     * 
     */	
	public List<Usuario> buscarUsuariosPorNombre(String name){
		List<Usuario> usuarios = null;
		UsuarioDao usuarioDao = new UsuarioDao(PersistenceUtil.getEntityManager());
		usuarios = usuarioDao.buscarUsuariosPorNombre(name);
		return usuarios;
	}
	
	/**
     * seguirUsuario: Agrega un usuario a la lista de usuarios seguidos
     * 
     * @param Usuario
     *            - Usuario que realizó la acción
     * @param Usuario
     *            - Usuario a dejar de seguir
     * 
     */	
	public void seguirUsuario(Usuario usuarioActual, Usuario usuarioDejarDeSeguir){
		UsuarioDao usuarioDao = new UsuarioDao(PersistenceUtil.getEntityManager());
		
		usuarioActual.getUsuariosSeguidos().add(usuarioDejarDeSeguir);
		
		usuarioDao.actualizar(usuarioActual);
	}
	
	/**
     * dejarDeSeguirUsuario: Saca un usuario de la lista de usuarios seguidos
     * 
     * @param Usuario
     *            - Usuario que realizó la acción
     * @param Usuario
     *            - Usuario a dejar de seguir
     * 
     */	
	public void dejarDeSeguirUsuario(Usuario usuarioActual, Usuario usuarioDejarDeSeguir){
		UsuarioDao usuarioDao = new UsuarioDao(PersistenceUtil.getEntityManager());
		
		usuarioActual.getUsuariosSeguidos().remove(usuarioDejarDeSeguir);
		
		usuarioDao.actualizar(usuarioActual);
	}
	
	/**
     * iniciarSesion: Loguea un usuario en el sistema
     * 
     * @param Usuario
     *            - Usuario que realizó la acción
     */	
	public Usuario iniciarSesion(String nombreUsuario, String clave){
		UsuarioDao usuarioDao = new UsuarioDao(PersistenceUtil.getEntityManager());
		
		Usuario usuario = usuarioDao.iniciarSesion(nombreUsuario, clave);
		
		return usuario;		
	}
}
