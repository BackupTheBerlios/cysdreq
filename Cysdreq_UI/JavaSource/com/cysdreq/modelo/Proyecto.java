/**
 * 
 */
package com.cysdreq.modelo;

import java.util.ArrayList;

import com.cysdreq.modelo.req.Requerimiento;
import com.cysdreq.modelo.req.TipoRequerimiento;

/**
 * @author Daniel Nanni
 *
 */
public class Proyecto {

	private String nombre;
	private ArrayList roles;
	private ArrayList miembros;
	private ArrayList requerimientos;
	private ArrayList tiposRequerimientos;
	
	/**
	 * 
	 */
	public Proyecto(String nombre) {
		super();
		this.setNombre(nombre);
	}

	protected ArrayList getMiembros() {
		if (miembros == null)
			miembros = new ArrayList();
		return miembros;
	}

	protected void setMiembros(ArrayList miembros) {
		this.miembros = miembros;
	}

	protected ArrayList getRequerimientos() {
		if (requerimientos == null)
			requerimientos = new ArrayList();		
		return requerimientos;
	}

	protected void setRequerimientos(ArrayList requerimientos) {
		this.requerimientos = requerimientos;
	}

	protected ArrayList getRoles() {
		if (roles == null)
			roles = new ArrayList();		
		return roles;
	}

	protected void setRoles(ArrayList roles) {
		this.roles = roles;
	}

	protected ArrayList getTiposRequerimientos() {
		if (tiposRequerimientos == null)
			tiposRequerimientos = new ArrayList();		
		return tiposRequerimientos;
	}

	protected void setTiposRequerimientos(ArrayList tiposRequerimientos) {
		this.tiposRequerimientos = tiposRequerimientos;
	}

	public void agregarRol(Rol rol) {
		this.getRoles().add(rol);
	}

	public String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarMiembro(Miembro miembro) {
		this.getMiembros().add(miembro);
	}

	public void agregarRequerimiento(Requerimiento req) {
		this.getRequerimientos().add(req);
	}
	
	public void agregarTipoRequerimiento(TipoRequerimiento tipo) {
		this.getTiposRequerimientos().add(tipo);
	}
}
