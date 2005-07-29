/**
 * 
 */
package com.cysdreq.modelo.flow;

import java.util.ArrayList;

import com.cysdreq.modelo.Miembro;
import com.cysdreq.modelo.req.Requerimiento;

/**
 * @author Daniel Nanni
 *
 */
public class Transicion {

	private TipoEstado tipoEstadoDestino;

	public Transicion() {
		super();
	}

	/**
	 * 
	 */
	public Transicion(TipoEstado tipo) {
		super();
		setTipoEstadoDestino(tipo);
	}

	public void ejecutar(Requerimiento requerimiento, Miembro miembro) {
		Estado nuevoEstado = this.getEstadoDestino(miembro);
		requerimiento.cambiarEstado(nuevoEstado);
	}

	private Estado getEstadoDestino(Miembro miembro) {
		return tipoEstadoDestino.nuevoEstado(miembro);
	}
	/**
	 * @return
	 */
	public TipoEstado getTipoEstadoDestino() {
		return tipoEstadoDestino;
	}

	/**
	 * @param estado
	 */
	public void setTipoEstadoDestino(TipoEstado estado) {
		tipoEstadoDestino = estado;
	}

}
