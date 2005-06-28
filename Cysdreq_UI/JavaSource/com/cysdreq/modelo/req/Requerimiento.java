/**
 * 
 */
package com.cysdreq.modelo.req;

import java.util.ArrayList;

import com.cysdreq.modelo.Miembro;
import com.cysdreq.modelo.flow.Estado;
import com.cysdreq.modelo.flow.Transicion;

/**
 * @author Daniel Nanni
 *
 */
public class Requerimiento {

	private TipoRequerimiento tipo;
	private Estado estadoActual;
	private Miembro propietario;

	/**
	 * Propiedades comunes a todos los estados del requerimiento,
	 * se guardan en el estado para poder mantener la historia de 
	 * cómo fueron cambiando
	 */
	private ArrayList propiedades;

	public Requerimiento() {
		super();
	}

	/**
	 * @param propiedades2 
	 * @param list 
	 * 
	 */
	public Requerimiento(Estado estadoInicial,
						 Miembro propietario,
						 ArrayList propiedades) {
		super();
		this.setEstadoActual(estadoInicial);
		this.setPropietario(propietario);
		this.setPropiedades(propiedades);
	}

	public Estado getEstadoActual() {
		return estadoActual;
	}

	public void setEstadoActual(Estado estadoActual) {
		this.estadoActual = estadoActual;
	}

	public Miembro getPropietario() {
		return propietario;
	}

	protected void setPropietario(Miembro propietario) {
		this.propietario = propietario;
	}

	public TipoRequerimiento getTipo() {
		return tipo;
	}

	protected void setTipo(TipoRequerimiento tipo) {
		this.tipo = tipo;
	}

	public void cambiarEstado(Estado nuevoEstado) {
		this.setEstadoActual(nuevoEstado);
	}

	public void ejecutarTransicion(Transicion transicion, Miembro miembro) {
		transicion.ejecutar(this, miembro);
	}

	protected ArrayList getPropiedades() {
		return propiedades;
	}

	protected void setPropiedades(ArrayList propiedades) {
		this.propiedades = propiedades;
	}

}
