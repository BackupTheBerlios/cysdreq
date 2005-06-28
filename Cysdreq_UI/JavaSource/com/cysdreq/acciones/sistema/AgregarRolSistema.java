/**
 * 
 */
package com.cysdreq.acciones.sistema;

import java.util.ArrayList;
import java.util.HashMap;

import com.cysdreq.acciones.TipoAccion;
import com.cysdreq.modelo.Cysdreq;
import com.cysdreq.modelo.Rol;

/**
 * @author Daniel Nanni
 *
 */
public class AgregarRolSistema implements TipoAccion {

	private static AgregarRolSistema instancia;
	/**
	 * 
	 */
	public AgregarRolSistema() {
		super();
	}

	/**
	 * Implementación del Singleton
	 */
	public static AgregarRolSistema getInstance() {
		if (instancia == null)
			instancia = new AgregarRolSistema();
		return instancia;
	}

	/* (non-Javadoc)
	 * @see com.cysdreq.acciones.TipoAccion#ejecutar(java.lang.Object, java.util.HashMap)
	 */
	public void ejecutar(Object receptor, HashMap parametros) {
		Cysdreq sistema = (Cysdreq) receptor;
		String nombre = (String) parametros.get("nombreRol");
		ArrayList tiposAcciones = (ArrayList) parametros.get("tiposDeAcciones");
		
		sistema.agregarRol(new Rol(nombre, tiposAcciones));
	}

	/* (non-Javadoc)
	 * @see com.cysdreq.acciones.TipoAccion#esAccionProyecto()
	 */
	public boolean esAccionProyecto() {
		return false;
	}

	/* (non-Javadoc)
	 * @see com.cysdreq.acciones.TipoAccion#esAccionSistema()
	 */
	public boolean esAccionSistema() {
		return true;
	}

}
