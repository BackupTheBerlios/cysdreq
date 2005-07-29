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
import com.cysdreq.util.PersistentMap;

/**
 * @author Daniel Nanni
 *
 */
public class AgregarRequerimiento extends TipoAccion {

	/**
	 * 
	 */
	public AgregarRequerimiento() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.cysdreq.acciones.TipoAccion#ejecutar(java.lang.Object, java.util.HashMap)
	 */
	public void ejecutar(Object receptor, HashMap parametros) {
		Proyecto proyecto = (Proyecto) receptor;
		TipoRequerimiento tipo = (TipoRequerimiento) parametros.get("tipoRequerimiento");
		Miembro propietario = (Miembro) parametros.get("propietario");
		Miembro responsable = (Miembro) parametros.get("responsable");
		PersistentMap propiedadesGenerales = (PersistentMap) parametros.get("propiedadesGenerales");
		PersistentMap propiedadesEstado = (PersistentMap) parametros.get("propiedadesEstado");

		Requerimiento req = tipo.nuevoRequerimiento(propietario, responsable);
		
		req.setPropiedadesGenerales(propiedadesGenerales);
		req.setPropiedadesEstadoActual(propiedadesEstado);
		
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

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object tipoAccion) {
		return (tipoAccion != null && tipoAccion instanceof AgregarRequerimiento);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		Class c = AgregarRequerimiento.class;
		return c.getName().hashCode();
	}

	/* (non-Javadoc)
	 * @see com.cysdreq.acciones.TipoAccion#getName()
	 */
	public String getName() {
		return "Agregar Requerimiento";
	}

}
