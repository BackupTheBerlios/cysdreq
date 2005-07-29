/*
 * Created on 27/07/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.cysdreq.util;

/**
 * @author Nacirita
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Numerador {

	private String nombre;
	private int currentId;

	/**
	 * 
	 */
	public Numerador() {
		super();
	}

	/**
	 * 
	 */
	public Numerador(String nombre) {
		super();
		setNombre(nombre);
		setCurrentId(1);
	}

	/**
	 * 
	 */
	public Numerador(String nombre, int nextId) {
		super();
		setNombre(nombre);
		setCurrentId(nextId);
	}

	/**
	 * @return
	 */
	public synchronized int getNextId() {
		int result = currentId;
		setCurrentId(result + 1);
		return result;
	}

	/**
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param string
	 */
	private void setCurrentId(int id) {
		currentId = id;
	}

	/**
	 * @param string
	 */
	private void setNombre(String string) {
		nombre = string;
	}

	/**
	 * @return
	 */
	public synchronized int getCurrentId() {
		return currentId;
	}

}
