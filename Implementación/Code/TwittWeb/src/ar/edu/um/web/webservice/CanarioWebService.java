/**
 * $Author:  $
 * 
 * Revision History
 * $Log: CanarioWebService.java,v $ *
 *
 */
package ar.edu.um.web.webservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ar.edu.um.dominio.MensajeDominio;
import ar.edu.um.dominio.UsuarioDominio;
import ar.edu.um.entidad.Mensaje;
import ar.edu.um.entidad.Usuario;

/**
 * CanarioWebService ofrece los métodos para acceder al sistema en forma de API
 * 
 * $Id: $
 * 
 */
@Path("CanarioWebService")
public class CanarioWebService {
    
	/**
     * visualizarTablon: Busca mensajes en la DB relacionados a un usuario
     * 
     * @param Usuario
     *            - Usuario a buscar
     * @param String
     *            - Clave del usuario
     *            
     * @return List<Mensaje>
     * 			  - Lista de Mensajes en formato xml. Null cuando el usuario o clave son incorrectos
     */
	@GET  
    @Path("/visualizarTablon/usuario={usuario}&clave={clave}")  
    @Produces(MediaType.APPLICATION_XML)
	public List<Mensaje> visualizarTablon(@PathParam("usuario") String nombreUsuario,@PathParam("clave") String clave){
		UsuarioDominio usuarioDominio = new UsuarioDominio();
		Usuario usuario = usuarioDominio.iniciarSesion(nombreUsuario, clave);		
		
		if(usuario != null){			
			MensajeDominio mensajeDominio = new MensajeDominio();
			return mensajeDominio.visualizarTablon(usuario);
		}else
			return null;
		
	}

}
