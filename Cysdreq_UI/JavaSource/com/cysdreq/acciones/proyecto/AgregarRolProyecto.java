/**
 * 
 */
package com.cysdreq.acciones.proyecto;

import java.util.ArrayList;
import java.util.HashMap;

import com.cysdreq.acciones.TipoAccion;
import com.cysdreq.modelo.Proyecto;
import com.cysdreq.modelo.Rol;

/**
 * @author Daniel Nanni
 *
 */
public class AgregarRolProyecto implements TipoAccion {

	private static AgregarRolProyecto instancia;
	/**
	 * 
	 */
	private AgregarRolProyecto() {
		super();
	}

	/**
	 * Implementación del Singleton
	 */
	public static AgregarRolProyecto getInstance() {
		if (instancia == null)
			instancia = new AgregarRolProyecto();
		return instancia;
	}

	/* (non-Javadoc)
	 * @see com.cysdreq.acciones.TipoAccion#ejecutar(java.lang.Object, java.util.HashMap)
	 */
	public void ejecutar(Object receptor, HashMap parametros) {
		Proyecto proyecto = (Proyecto) receptor;
		String nombre = (String) parametros.get("nombreRol");
		ArrayList tiposAcciones = (ArrayList) parametros.get("tiposDeAcciones");
		
		proyecto.agregarRol(new Rol(nombre, tiposAcciones));
	}

	/* (non-Javadoc)
	 * @see com.cysdreq.acciones.TipoAccion#esAccionProyecto()
	 */
	public boolean esAccionProyecto() {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.cysdreq.acciones.TipoAccion#esAccionSistema()
	 */
	public boolean esAccionSistema() {
		return false;
	}

}
