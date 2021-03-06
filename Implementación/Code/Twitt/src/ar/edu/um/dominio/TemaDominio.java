/**
 * $Author:  $
 * 
 * Revision History
 * $Log: TemaDominio.java,v $ *
 *
 */
package ar.edu.um.dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.edu.um.dao.TemaDao;
import ar.edu.um.entidad.Tema;
import ar.edu.um.util.PersistenceUtil;

/**
 * TemaDominio ofrece los métodos para manejar temas
 * 
 * $Id: $
 * 
 */
public class TemaDominio {
	
    /**
     * crearTema: Crea temas en la DB
     * 
     * @param Tema
     *            - Tema a crear
     * 
     */
	public void crearTema(Tema tema){
		TemaDao temaDao = new TemaDao(PersistenceUtil.getEntityManager());
		temaDao.persist(tema);
	}
	
    /**
     * eliminarTema: Elimina temas en la DB
     * 
     * @param Tema
     *            - Tema a eliminar
     * 
     */
	public void eliminarTema(Tema tema){
		TemaDao temaDao = new TemaDao(PersistenceUtil.getEntityManager());
		temaDao.remove(tema);		
	}
	
    /**
     * buscarTemaDelMomento: Muestra los temas más mencionados en la última semana
     * 
     * @return List<Tema>
     * 			  - Lista de temas
     * 
     */
	public List<Tema> buscarTemasDelMomento(){
		ArrayList<Tema> temasDelMomento = null;
		TemaDao temaDao = new TemaDao(PersistenceUtil.getEntityManager());
		temasDelMomento = temaDao.buscarTemasDelMomento();
		return temasDelMomento;
	}
	
    /**
     * buscarTemaPorFechas: Muestra los temas más mencionados entre 2 fechas
     * 
     * @param Date
     *            - Fecha de inicio de la busqueda
     * @param Date
     *            - Fecha de fin de la busqueda
     *            
     * @return List<Tema>
     * 			  - Lista de temas
     * 
     */
	public List<Tema> buscarTemasPorFechas(Date fechaInicio, Date fechaFin){
		ArrayList<Tema> temas = null;
		TemaDao temaDao = new TemaDao(PersistenceUtil.getEntityManager());
		temas = temaDao.buscarTemasPorFechas(fechaInicio, fechaFin);
		return temas;
	}
	
    /**
     * enviarMail: Envia un mail con los temas más mencionados en la última semana
     * 
     */
	public void enviarMail(){
		
	}

}
