/**
 * 
 */
package com.cysdreq.modelo.flow;

import java.util.ArrayList;

import com.cysdreq.modelo.Miembro;

/**
 * @author Daniel Nanni
 *
 */
public class Estado {

	private TipoEstado tipo;

	/**
	 * Propiedades locales a este estado
	 */
	private ArrayList propiedades;

	private Miembro responsable; // Indica quién tiene asignado el requerimiento 
								 // en un momento dado (en este estado)

	/**
	 * 
	 */
	public Estado() {
		super();
	}

	/**
	 * 
	 */
	public Estado(TipoEstado tipo,
				  Miembro responsable,
				  ArrayList propiedades) {
		super();
		this.setTipo(tipo);
		this.setResponsable(responsable);
		this.setPropiedades(propiedades);
	}

	public ArrayList getPropiedades() {
		return propiedades;
	}

	private void setPropiedades(ArrayList propiedades) {
		this.propiedades = propiedades;
	}

	public Miembro getResponsable() {
		return responsable;
	}

	public void setResponsable(Miembro responsable) {
		this.responsable = responsable;
	}

	public TipoEstado getTipo() {
		return tipo;
	}

	protected void setTipo(TipoEstado tipo) {
		this.tipo = tipo;
	}

}
