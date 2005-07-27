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
	private String valor;

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

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
