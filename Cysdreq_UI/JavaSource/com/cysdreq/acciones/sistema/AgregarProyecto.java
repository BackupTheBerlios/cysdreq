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
public class AgregarProyecto extends TipoAccion {

	/**
	 * 
	 */
	public AgregarProyecto() {
		super();
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

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object tipoAccion) {
		return (tipoAccion != null && tipoAccion instanceof AgregarProyecto);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		Class c = AgregarProyecto.class;
		return c.getName().hashCode();
	}

}
