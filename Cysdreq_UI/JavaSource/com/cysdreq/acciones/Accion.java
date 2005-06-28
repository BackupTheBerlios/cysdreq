/**
 * 
 */
package com.cysdreq.acciones;

import java.util.HashMap;

/**
 * @author Daniel Nanni
 *
 */
public class Accion {

	private TipoAccion tipo;
	private HashMap parametros;
	private Object receptor;

	/**
	 * 
	 */
	public Accion(TipoAccion tipo, Object receptor, HashMap parametros) {
		super();
		setTipo(tipo);
		setParametros(parametros);
		setReceptor(receptor);
	}

	protected HashMap getParametros() {
		return parametros;
	}

	protected void setParametros(HashMap parametros) {
		this.parametros = parametros;
	}

	protected TipoAccion getTipo() {
		return tipo;
	}

	protected void setTipo(TipoAccion tipo) {
		this.tipo = tipo;
	}

	public void ejecutar() {
		getTipo().ejecutar(receptor, parametros);
	}

	protected Object getReceptor() {
		return receptor;
	}

	protected void setReceptor(Object receptor) {
		this.receptor = receptor;
	}

}
