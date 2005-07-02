/**
 * 
 */
package com.cysdreq.acciones.proyecto;

import java.util.HashMap;

import com.cysdreq.acciones.TipoAccion;
import com.cysdreq.modelo.Proyecto;
import com.cysdreq.modelo.Rol;
import com.cysdreq.util.PersistentArrayList;

/**
 * @author Daniel Nanni
 *
 */
public class AgregarRolProyecto extends TipoAccion {

	/**
	 * 
	 */
	public AgregarRolProyecto() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.cysdreq.acciones.TipoAccion#ejecutar(java.lang.Object, java.util.HashMap)
	 */
	public void ejecutar(Object receptor, HashMap parametros) {
		Proyecto proyecto = (Proyecto) receptor;
		String nombre = (String) parametros.get("nombreRol");
		PersistentArrayList tiposAcciones = (PersistentArrayList) parametros.get("tiposDeAcciones");
		
		proyecto.agregarRol(new Rol(nombre, tiposAcciones.getWrappedArrayList()));
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
		return (tipoAccion != null && tipoAccion instanceof AgregarRolProyecto);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		Class c = AgregarRolProyecto.class;
		return c.getName().hashCode();
	}

	/* (non-Javadoc)
	 * @see com.cysdreq.acciones.TipoAccion#getName()
	 */
	public String getName() {
		return "Agregar Rol Proyecto";
	}

}
