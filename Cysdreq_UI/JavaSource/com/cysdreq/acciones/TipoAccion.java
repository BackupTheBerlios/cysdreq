/**
 * 
 */
package com.cysdreq.acciones;

import java.util.HashMap;


/**
 * @author Daniel Nanni
 *
 */
public abstract class TipoAccion {

	public abstract void ejecutar(Object receptor, HashMap parametros);
	public abstract boolean esAccionProyecto();
	public abstract boolean esAccionSistema();

	public abstract boolean equals(Object obj);
	public abstract int hashCode();
	public abstract String getName();

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return getName();
	}

}
