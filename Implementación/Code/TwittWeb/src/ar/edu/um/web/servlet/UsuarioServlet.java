/**
 * $Author:  $
 * 
 * Revision History
 * $Log: LoginServlet.java,v $ *
 *
 */
package ar.edu.um.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ar.edu.um.dominio.MensajeDominio;
import ar.edu.um.dominio.UsuarioDominio;
import ar.edu.um.entidad.Mensaje;
import ar.edu.um.entidad.Usuario;
 
/**
 * LoginServlet ofrece los métodos para manejar mensajes
 * 
 * $Id: $
 * 
 */
@WebServlet(
        description = "Usuario Servlet",
        urlPatterns = { "/UsuarioServlet" }
        )
public class UsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;    
     
     
    public void init() throws ServletException {

    }
 
     
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
    	String accion = request.getParameter("accion");
        
    	if(accion.equals("Ingresar")){
	        String user = request.getParameter("usuario");
	        String pwd = request.getParameter("clave");
	        HttpSession session = request.getSession(true);
	        
	        log("User="+user+"::password="+pwd);
	        UsuarioDominio usuDominio = new UsuarioDominio();
	        Usuario usuario = usuDominio.iniciarSesion(user, pwd);
	        
	        if(usuario != null){
	        	//Se agrega el usuario a la sesión para la seguridad
	            session.setAttribute("usuario", usuario.getNombreUsuario());
	            
	            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Mensajes/Tablon.jsp");
	            MensajeServlet mensajeServlet = new MensajeServlet();
	            mensajeServlet.visualizarTablon(usuario, request, response, rd);
	        }else{
	            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
	            PrintWriter out= response.getWriter();
	            out.println("<font color=red>Usuario o Clave incorrectos</font>");
	            rd.include(request, response);             
	        }
    	}else if(accion.equals("Salir")){
    		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
    		cerrarSesion(request, response, rd);
    	}
         
    }
    
    public void cerrarSesion(HttpServletRequest request, HttpServletResponse response, RequestDispatcher rd) throws ServletException, IOException{
		request.getSession().setAttribute("usuario", null);		
        rd.include(request, response); 
    }
 
}