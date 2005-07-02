/**
 * 
 */
package com.cysdreq.acciones.proyecto;

import java.util.ArrayList;
import java.util.HashMap;

import com.cysdreq.acciones.TipoAccion;
import com.cysdreq.modelo.Miembro;
import com.cysdreq.modelo.Proyecto;
import com.cysdreq.modelo.Usuario;
import com.cysdreq.util.PersistentArrayList;

/**
 * @author Daniel Nanni
 *
 */
public class AgregarMiembro extends TipoAccion {

	/**
	 * 
	 */
	public AgregarMiembro() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.cysdreq.acciones.TipoAccion#ejecutar(java.lang.Object, java.util.HashMap)
	 */
	public void ejecutar(Object receptor, HashMap parametros) {
		Proyecto proyecto = (Proyecto) receptor;
		Usuario usuario = (Usuario) parametros.get("usuario");
		PersistentArrayList roles = (PersistentArrayList) parametros.get("roles");
		ArrayList copiaRoles = (ArrayList) roles.getWrappedArrayList().clone();
		Miembro miembro = new Miembro(usuario, copiaRoles);
		proyecto.agregarMiembro(miembro);
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
		return (tipoAccion != null && tipoAccion instanceof AgregarMiembro);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		Class c = AgregarMiembro.class;
		return c.getName().hashCode();
	}

	/* (non-Javadoc)
	 * @see com.cysdreq.acciones.TipoAccion#getName()
	 */
	public String getName() {
		return "Agregar Miembro";
	}


}
