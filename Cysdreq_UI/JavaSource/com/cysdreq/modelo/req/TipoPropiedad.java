/**
 * 
 */
package com.cysdreq.modelo.req;

/**
 * @author Daniel Nanni
 *
 */
public class TipoPropiedad {

	private String nombre;

	/**
	 * 
	 */
	public TipoPropiedad() {
		super();
	}

	/**
	 * 
	 */
	public TipoPropiedad(String nombre) {
		super();
		this.setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Propiedad nuevaPropiedad() {
		return new Propiedad(this);
	}
}
