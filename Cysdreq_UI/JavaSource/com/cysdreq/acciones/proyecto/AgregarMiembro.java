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

/**
 * @author Daniel Nanni
 *
 */
public class AgregarMiembro implements TipoAccion {

	private static AgregarMiembro instancia;
	/**
	 * 
	 */
	private AgregarMiembro() {
		super();
	}

	/**
	 * Implementación del Singleton
	 */
	public static AgregarMiembro getInstance() {
		if (instancia == null)
			instancia = new AgregarMiembro();
		return instancia;
	}

	/* (non-Javadoc)
	 * @see com.cysdreq.acciones.TipoAccion#ejecutar(java.lang.Object, java.util.HashMap)
	 */
	public void ejecutar(Object receptor, HashMap parametros) {
		Proyecto proyecto = (Proyecto) receptor;
		Usuario usuario = (Usuario) parametros.get("usuario");
		ArrayList roles = (ArrayList) parametros.get("roles");
		ArrayList copiaRoles = (ArrayList) roles.clone();
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

}
