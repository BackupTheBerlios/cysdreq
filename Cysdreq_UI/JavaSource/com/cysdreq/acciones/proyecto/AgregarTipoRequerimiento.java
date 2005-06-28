/**
 * 
 */
package com.cysdreq.acciones.proyecto;

import java.util.HashMap;

import com.cysdreq.acciones.TipoAccion;
import com.cysdreq.modelo.Proyecto;
import com.cysdreq.modelo.req.TipoRequerimiento;

/**
 * @author Daniel Nanni
 *
 */
public class AgregarTipoRequerimiento implements TipoAccion {

	private static AgregarTipoRequerimiento instancia;
	/**
	 * 
	 */
	private AgregarTipoRequerimiento() {
		super();
	}

	/**
	 * Implementación del Singleton
	 */
	public static AgregarTipoRequerimiento getInstance() {
		if (instancia == null)
			instancia = new AgregarTipoRequerimiento();
		return instancia;
	}

	/* (non-Javadoc)
	 * @see com.cysdreq.acciones.TipoAccion#ejecutar(java.lang.Object, java.util.HashMap)
	 */
	public void ejecutar(Object receptor, HashMap parametros) {
		Proyecto proyecto = (Proyecto) receptor;
		// El tipo de requerimiento (con sus propiedades y estados) debe
		// ser creado en la UI
		TipoRequerimiento tipo = (TipoRequerimiento) parametros.get("tipoRequerimiento");
		
		proyecto.agregarTipoRequerimiento(tipo);
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
