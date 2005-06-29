/**
 * 
 */
package com.cysdreq.modelo.req;

/**
 * @author Daniel Nanni
 *
 */
public class Propiedad {

	private TipoPropiedad tipo;
	private Object valor;

	/**
	 * 
	 */
	public Propiedad() {
		super();
	}

	/**
	 * 
	 */
	public Propiedad(TipoPropiedad tipo) {
		super();
		this.setTipo(tipo);
	}

	protected TipoPropiedad getTipo() {
		return tipo;
	}

	protected void setTipo(TipoPropiedad tipo) {
		this.tipo = tipo;
	}

	public Object getValor() {
		return valor;
	}

	public void setValor(Object valor) {
		this.valor = valor;
	}

}
