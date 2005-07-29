/**
 * 
 */
package com.cysdreq.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.cysdreq.modelo.flow.TipoEstado;
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
	private HashMap requerimientos;
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

	public ArrayList getMiembros() {
		if (miembros == null)
			miembros = new ArrayList();
		return miembros;
	}

	protected void setMiembros(ArrayList miembros) {
		this.miembros = miembros;
	}

	public HashMap getRequerimientos() {
		if (requerimientos == null)
			requerimientos = new HashMap();		
		return requerimientos;
	}

	protected void setRequerimientos(HashMap requerimientos) {
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
		this.getRequerimientos().put(new Integer(req.getId()), req);
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

	public ArrayList getTiposDeEstados(){

		Set set = new TreeSet();

		Iterator iter = this.getTiposRequerimientos().iterator();	
		while (iter.hasNext()) {
			TipoRequerimiento tipoRequerimiento = (TipoRequerimiento) iter.next();

			Iterator iterator = tipoRequerimiento.getTiposDeEstados().iterator();
			while (iterator.hasNext()){
				TipoEstado tipoEstado = (TipoEstado) iterator.next();
				set.add(tipoEstado.getNombre());
			}	
		}	

		return new ArrayList(Arrays.asList(set.toArray()));
	}
	
	public Requerimiento getRequerimiento(int id) {
		return (Requerimiento) getRequerimientos().get(new Integer(id));
	}
}
