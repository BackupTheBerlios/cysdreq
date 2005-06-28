/**
 * 
 */
package com.cysdreq.acciones;

import java.util.HashMap;


/**
 * @author Daniel Nanni
 *
 */
public interface TipoAccion {

	public void ejecutar(Object receptor, HashMap parametros);
	public boolean esAccionProyecto();
	public boolean esAccionSistema();
	
}
