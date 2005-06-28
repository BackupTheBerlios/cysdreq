/**
 * 
 */
package com.cysdreq.modelo.flow;

import java.util.ArrayList;

import com.cysdreq.modelo.Miembro;
import com.cysdreq.modelo.req.Requerimiento;
import com.cysdreq.tareas.AdministradorDeTareas;

/**
 * @author Daniel Nanni
 *
 */
public class Transicion {

	private static AdministradorDeTareas administrador;

	private TipoEstado tipoEstadoDestino;
	private ArrayList tareas;

	/**
	 * 
	 */
	public Transicion() {
		super();
	}

	public void ejecutar(Requerimiento requerimiento, Miembro miembro) {
		Estado nuevoEstado = this.getEstadoDestino(miembro);
		requerimiento.cambiarEstado(nuevoEstado);
		this.ejecutarTareas();
	}

	private void ejecutarTareas() {
		// TODO Auto-generated method stub
		
	}

	private Estado getEstadoDestino(Miembro miembro) {
		return tipoEstadoDestino.nuevoEstado(miembro);
	}
}
