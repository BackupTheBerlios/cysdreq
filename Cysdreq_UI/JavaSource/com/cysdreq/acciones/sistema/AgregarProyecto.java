/**
 * 
 */
package com.cysdreq.acciones.sistema;

import java.util.HashMap;

import com.cysdreq.acciones.TipoAccion;
import com.cysdreq.modelo.Cysdreq;
import com.cysdreq.modelo.Proyecto;

/**
 * @author Daniel Nanni
 *
 */
public class AgregarProyecto implements TipoAccion {

	private static AgregarProyecto instancia;
	/**
	 * 
	 */
	private AgregarProyecto() {
		super();
	}

	/**
	 * Implementación del Singleton
	 */
	public static AgregarProyecto getInstance() {
		if (instancia == null)
			instancia = new AgregarProyecto();
		return instancia;
	}
	
	/* (non-Javadoc)
	 * @see com.cysdreq.acciones.TipoAccion#ejecutar(java.util.HashMap)
	 */
	public void ejecutar(Object receptor, HashMap parametros) {
		Cysdreq sistema = (Cysdreq) receptor;
		String nombre = (String) parametros.get("nombreProyecto");
		
		sistema.agregarProyecto(new Proyecto(nombre));
	}

	public boolean esAccionProyecto() {
		return false;
	}

	public boolean esAccionSistema() {
		return true;
	}

}
