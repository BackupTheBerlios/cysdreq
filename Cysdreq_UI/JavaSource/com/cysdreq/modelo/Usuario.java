/**
 * 
 */
package com.cysdreq.modelo;

import java.util.ArrayList;

/**
 * @author Daniel Nanni
 *
 */ 
public class Usuario {

	private String nombre;
	private String usuario;
	private String password;
	private ArrayList roles;

	/**
	 * 
	 */
	public Usuario() {
		super();
	}

	/**
	 * Crea un usuario con nombre, usuario y password iguales
	 */
	public Usuario(String nombre, String usuario, String password) {
		super();
		this.setNombre(nombre);
		this.setUsuario(usuario);
		this.setPassword(password);
	}

	public String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected ArrayList getRoles() {
		return roles;
	}

	protected void setRoles(ArrayList roles) {
		this.roles = roles;
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param string
	 */
	public void setPassword(String string) {
		password = string;
	}

	/**
	 * @param string
	 */
	public void setUsuario(String string) {
		usuario = string;
	}

}
