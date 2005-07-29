/*
 * Created on 27/07/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.cysdreq.util;

import java.util.HashMap;

/**
 * @author Nacirita
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Numeradores {

	private HashMap numeradores;

	/**
	 * 
	 */
	public Numeradores() {
		super();
	}

	/**
	 * @return
	 */
	private HashMap getNumeradores() {
		if (numeradores == null) {
			numeradores = new HashMap();
		}
		return numeradores;
	}

	/**
	 * @param map
	 */
	private void setNumeradores(HashMap map) {
		numeradores = map;
	}

	public int getNextId(String nombreNumerador) {
		Numerador numerador = (Numerador) getNumeradores().get(nombreNumerador);
		return numerador.getNextId();
	}

	public int getCurrentId(String nombreNumerador) {
		Numerador numerador = (Numerador) getNumeradores().get(nombreNumerador);
		return numerador.getCurrentId();
	}

	public void agregarNumerador(String nombreNumerador, int idInicial) {
		getNumeradores().put(nombreNumerador, new Numerador(nombreNumerador, idInicial));
	}

	public void agregarNumerador(String nombreNumerador) {
		getNumeradores().put(nombreNumerador, new Numerador(nombreNumerador));
	}

}
