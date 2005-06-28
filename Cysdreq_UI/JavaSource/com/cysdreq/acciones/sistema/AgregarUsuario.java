/**
 * 
 */
package com.cysdreq.acciones.sistema;

import java.util.HashMap;

import com.cysdreq.acciones.TipoAccion;
import com.cysdreq.modelo.Cysdreq;
import com.cysdreq.modelo.Usuario;

/**
 * @author Daniel Nanni
 *
 */
public class AgregarUsuario implements TipoAccion {

	private static AgregarUsuario instancia;
	/**
	 * 
	 */
	public AgregarUsuario() {
		super();
	}

	/**
	 * Implementación del Singleton
	 */
	public static AgregarUsuario getInstance() {
		if (instancia == null)
			instancia = new AgregarUsuario();
		return instancia;
	}

	/* (non-Javadoc)
	 * @see com.cysdreq.acciones.TipoAccion#ejecutar(java.lang.Object, java.util.HashMap)
	 */
	public void ejecutar(Object receptor, HashMap parametros) {
		Cysdreq sistema = (Cysdreq) receptor;
		String nombre = (String) parametros.get("nombreUsuario");
		String usuario = (String) parametros.get("usuario");
		String password = (String) parametros.get("password");
		
		sistema.agregarUsuario(new Usuario(nombre, usuario, password));
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
