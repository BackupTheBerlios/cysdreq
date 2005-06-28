/**
 * 
 */
package com.cysdreq.acciones.proyecto;

import java.util.HashMap;

import com.cysdreq.acciones.TipoAccion;
import com.cysdreq.modelo.Miembro;
import com.cysdreq.modelo.Proyecto;
import com.cysdreq.modelo.req.Requerimiento;
import com.cysdreq.modelo.req.TipoRequerimiento;

/**
 * @author Daniel Nanni
 *
 */
public class AgregarRequerimiento implements TipoAccion {

	private static AgregarRequerimiento instancia;
	/**
	 * 
	 */
	private AgregarRequerimiento() {
		super();
	}

	/**
	 * Implementación del Singleton
	 */
	public static AgregarRequerimiento getInstance() {
		if (instancia == null)
			instancia = new AgregarRequerimiento();
		return instancia;
	}

	/* (non-Javadoc)
	 * @see com.cysdreq.acciones.TipoAccion#ejecutar(java.lang.Object, java.util.HashMap)
	 */
	public void ejecutar(Object receptor, HashMap parametros) {
		Proyecto proyecto = (Proyecto) receptor;
		TipoRequerimiento tipo = (TipoRequerimiento) parametros.get("tipoRequerimiento");
		Miembro propietario = (Miembro) parametros.get("propietario");
		Miembro responsable = (Miembro) parametros.get("responsable");
		
		Requerimiento req = tipo.nuevoRequerimiento(propietario, responsable);
		
		proyecto.agregarRequerimiento(req);
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
