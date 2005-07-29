/**
 * 
 */
package com.cysdreq.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.cysdreq.acciones.Accion;
import com.cysdreq.acciones.TipoAccion;
import com.cysdreq.loader.SessionManager;
import com.cysdreq.modelo.req.Requerimiento;
import com.cysdreq.util.Numeradores;
import com.poet.jdo.PersistenceManagers;

/**
 * @author Daniel Nanni
 *
 */ 
public final class Cysdreq {

	private static Cysdreq instance;

	private ArrayList proyectos;
	private ArrayList usuarios;
	private ArrayList roles;
	private HashMap historialAcciones;
	private Numeradores numeradores;

	/**
	 * This class is a singleton, so the constructor is private 
	 */
	private Cysdreq() {
		super();
		initialize();
	}
	
	/**
	 * 
	 */
	private void initialize() {
		getNumeradores().agregarNumerador(Requerimiento.class.getName());
	}

	public static Cysdreq getInstance() {
		if (instance == null) {
			instance = new Cysdreq();
		}
		return instance;
	}

	/**
	 * Obtiene el objeto unico cysdreq de la BD
	 * 
	 * @return
	 */
	public static Cysdreq getPersistentInstance() {
		return (Cysdreq) PersistenceManagers.findObject(SessionManager.getSession(), SessionManager.ROOT_OBJECT_ID);
	}

	/**
	 * 
	 * @param p
	 */
	public void agregarProyecto(Proyecto p) {
		getProyectos().add(p);
	}

	public ArrayList getProyectos() {
		if (proyectos == null)
			proyectos = new ArrayList();

		return proyectos;
	}

	protected void setProyectos(ArrayList proyectos) {
		this.proyectos = proyectos;
	}

	public ArrayList getUsuarios() {
		if (usuarios == null)
			usuarios = new ArrayList();
		return usuarios;
	}

	protected void setUsuarios(ArrayList usuarios) {
		this.usuarios = usuarios;
	}

	protected HashMap getHistorialAcciones() {
		if (historialAcciones==null) {
			historialAcciones = new HashMap();
		}
		return historialAcciones;
	}

	protected void setHistorialAcciones(HashMap historialAcciones) {
		this.historialAcciones = historialAcciones;
	}

	public void ejecutarAccion(TipoAccion tipo, Object receptor, HashMap parametros) {
		Accion a = new Accion(tipo, receptor, parametros);
		agregarAccionAHistorial(receptor, a);
		a.ejecutar();
	}

	private void agregarAccionAHistorial(Object receptor, Accion accion) {
		HistoriaObjeto historiaObj = (HistoriaObjeto) getHistorialAcciones().get(receptor);
		if (historiaObj == null) {
			historiaObj = new HistoriaObjeto(receptor);
			getHistorialAcciones().put(receptor, historiaObj);
		}
		historiaObj.getHistoria().add(accion);
	}

	public void agregarUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
	}

	public ArrayList getRoles() {
		if (roles == null) {
			roles = new ArrayList();
		}
		return roles;
	}

	protected void setRoles(ArrayList roles) {
		this.roles = roles;
	}

	public void agregarRol(Rol rol) {
		getRoles().add(rol);
	}
	
	public Usuario getUsuario (String login, String password) {
		Usuario usuario = null;
		Iterator i = this.getUsuarios().iterator();
		while (i.hasNext()) {
			usuario = (Usuario) i.next();
		    if (usuario.getUsuario().equals(login) && 
		    usuario.getPassword().equals(password)) {
		    	return usuario;
		    }
		}
		
		return null;
	}
	public Proyecto getProyecto(String nombre) {
		Proyecto proyecto = null;
		Iterator i = this.getProyectos().iterator();
		while (i.hasNext()) {
			proyecto = (Proyecto) i.next();
			if (proyecto.getNombre().equals(nombre)){
				return proyecto;
			}
		}
		
		return null;
	}

	/**
	 * @param string
	 * @return
	 */
	public Usuario getUsuario(String login) {
		Usuario usuario = null;
		Iterator i = this.getUsuarios().iterator();
		while (i.hasNext()) {
			usuario = (Usuario) i.next();
			if (usuario.getUsuario().equals(login)){
				return usuario;
			}
		}
		
		return null;
	}
	public Rol getRolPorNombre(String nombreRol){
		
		Iterator iter = this.getRoles().iterator();
		while (iter.hasNext()) {
			Rol rol = (Rol) iter.next();
			if (rol.getNombre().equals(nombreRol)){
				return rol;
			}	
		}
		
		return null;
					
	}	

	/**
	 * @return
	 */
	public Numeradores getNumeradores() {
		if (numeradores == null) {
			numeradores = new Numeradores(); 
		}
		return numeradores;
	}

	/**
	 * @param numeradores
	 */
	protected void setNumeradores(Numeradores numeradores) {
		this.numeradores = numeradores;
	}

}
