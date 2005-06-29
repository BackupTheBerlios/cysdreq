/*
 * Created on 29/06/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.cysdreq.modelo;

import java.util.ArrayList;

/**
 * @author Nacirita
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class HistoriaObjeto {

	private Object objeto;
	private ArrayList historia;

	/**
	 * 
	 */
	public HistoriaObjeto() {
		super();
	}

	/**
	 * @param receptor
	 */
	public HistoriaObjeto(Object receptor) {
		super();
		setObjeto(receptor);
	}

	/**
	 * @return
	 */
	public ArrayList getHistoria() {
		if (historia==null) {
			historia = new ArrayList();
		}
		return historia;
	}

	/**
	 * @return
	 */
	public Object getObjeto() {
		return objeto;
	}

	/**
	 * @param list
	 */
	protected void setHistoria(ArrayList list) {
		historia = list;
	}

	/**
	 * @param object
	 */
	protected void setObjeto(Object object) {
		objeto = object;
	}

}
