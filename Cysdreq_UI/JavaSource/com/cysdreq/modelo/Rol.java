/**
 * 
 */
package com.cysdreq.modelo;

import java.util.ArrayList;

import com.cysdreq.acciones.TipoAccion;

/**
 * @author Daniel Nanni
 *
 */
public class Rol {

	private String nombre;
	private ArrayList acciones;
	private Boolean esRolSistema;
	private Boolean esRolProyecto;
	
	/**
	 * 
	 */
	public Rol(String nombre, ArrayList tiposAcciones) {
		super();
		this.setNombre(nombre);
		this.setAcciones(tiposAcciones);
	}

	public ArrayList getAcciones() {
		return acciones;
	}

	protected void setAcciones(ArrayList acciones) {
		this.acciones = acciones;
	}

	public String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarAccion(TipoAccion accion) {
		this.getAcciones().add(accion);
	}

	protected Boolean esRolProyecto() {
		return esRolProyecto;
	}

	protected void setRolProyecto(Boolean esRolProyecto) {
		this.esRolProyecto = esRolProyecto;
	}

	protected Boolean esRolSistema() {
		return esRolSistema;
	}

	protected void setRolSistema(Boolean esRolSistema) {
		this.esRolSistema = esRolSistema;
	}
}
