/**
 * 
 */
package com.cysdreq.modelo;

import java.util.ArrayList;
import java.util.Iterator;

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
	public Proyecto() {
		super();
	}

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

	public ArrayList getRoles() {
		if (roles == null)
			roles = new ArrayList();		
		return roles;
	}

	public void setRoles(ArrayList roles) {
		this.roles = roles;
	}

	public ArrayList getTiposRequerimientos() {
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
	
	public Rol getRolPorNombre(String nombreRol){
		
		Iterator iter = this.getRoles().iterator();
		while (iter.hasNext()) {
			Rol rol = (Rol) iter.next();
			if (rol.getNombre().equals(nombreRol)){
				return rol;
			}	
		}
		
		return null;
					
	}
	public TipoRequerimiento getTipoRequerimiento(String nombreTipo){
		
		Iterator iter = this.getTiposRequerimientos().iterator();
		while (iter.hasNext()) {
			TipoRequerimiento tipoRequerimiento = (TipoRequerimiento) iter.next();
			if (tipoRequerimiento.getNombre().equals(nombreTipo)){
				return tipoRequerimiento;
			}	
		}
		
		return null;
					
	}

	/**
	 * @param usuario
	 * @return
	 */
	public Miembro getMiembro(Usuario usuario) {

		Iterator iter = this.getMiembros().iterator();
		while (iter.hasNext()) {
			Miembro miembro = (Miembro) iter.next();
			if (miembro.getUsuario().getUsuario().equals(usuario.getUsuario())){
				return miembro;
			}	
		}
		
		return null;		
		
	}
	
}
