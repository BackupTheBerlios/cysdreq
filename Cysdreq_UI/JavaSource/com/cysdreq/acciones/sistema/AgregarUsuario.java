/**
 * 
 */
package com.cysdreq.acciones.sistema;

import java.util.ArrayList;
import java.util.HashMap;

import com.cysdreq.acciones.TipoAccion;
import com.cysdreq.modelo.Cysdreq;
import com.cysdreq.modelo.Usuario;
import com.cysdreq.util.PersistentArrayList;

/**
 * @author Daniel Nanni
 *
 */
public class AgregarUsuario extends TipoAccion {

	/**
	 * 
	 */
	public AgregarUsuario() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.cysdreq.acciones.TipoAccion#ejecutar(java.lang.Object, java.util.HashMap)
	 */
	public void ejecutar(Object receptor, HashMap parametros) {
		Cysdreq sistema = (Cysdreq) receptor;
		String nombre = (String) parametros.get("nombreUsuario");
		String usuario = (String) parametros.get("usuario");
		String password = (String) parametros.get("password");
		PersistentArrayList roles = (PersistentArrayList) parametros.get("roles");
		ArrayList copiaRoles = (ArrayList) roles.getWrappedArrayList().clone();
				
		sistema.agregarUsuario(new Usuario(nombre, usuario, password, copiaRoles));
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

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object tipoAccion) {
		return (tipoAccion != null && tipoAccion instanceof AgregarUsuario);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		Class c = AgregarUsuario.class;
		return c.getName().hashCode();
	}

	/* (non-Javadoc)
	 * @see com.cysdreq.acciones.TipoAccion#getName()
	 */
	public String getName() {
		return "Agregar Usuario";
	}

}
