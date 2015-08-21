package ar.edu.um.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.um.dominio.MensajeDominio;
import ar.edu.um.entidad.Mensaje;
import ar.edu.um.entidad.Usuario;

/**
 * Servlet class MensajeServlet
 */
@WebServlet("/MensajeServlet")
public class MensajeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MensajeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("accion");
		
		if(accion.equals("Salir")){
			
			UsuarioServlet usuarioServlet = new UsuarioServlet();
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
			usuarioServlet.cerrarSesion(request, response, rd);
		}
	}
	
	public void visualizarTablon(Usuario usuario, HttpServletRequest request, HttpServletResponse response, RequestDispatcher rd) throws ServletException, IOException{
        MensajeDominio mensajeDominio = new MensajeDominio();
        List<Mensaje>  mensajes = mensajeDominio.visualizarTablon(usuario);
        
        request.setAttribute("usuario", usuario);
        request.setAttribute("mensajes", mensajes);
        rd.include(request, response);
	}

}
