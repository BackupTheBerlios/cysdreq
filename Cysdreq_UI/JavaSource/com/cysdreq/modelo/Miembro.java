/**
 * 
 */
package com.cysdreq.modelo;

import java.util.ArrayList;
import java.util.Iterator;

import com.cysdreq.acciones.TipoAccion;

/**
 * @author Daniel Nanni
 *
 */
public class Miembro {

	private Usuario usuario;
	private ArrayList roles;

	/**
	 * 
	 */
	public Miembro(Usuario usuario, ArrayList roles) {
		super();
		this.setUsuario(usuario);
		this.setRoles(roles);
	}

	public ArrayList getRoles() {
		return roles;
	}

	protected void setRoles(ArrayList roles) {
		this.roles = roles;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	protected void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Devuelve una colección de las acciones permitidas
	 * para el miembro según sus roles
	 * 
	 * @return
	 */
	public ArrayList getAcciones() {
		ArrayList acciones = new ArrayList();
		Rol rol;
		TipoAccion accion;

		Iterator i = this.getRoles().iterator();
		while (i.hasNext()) {
			rol = (Rol) i.next();
			Iterator j = rol.getAcciones().iterator();
			while (j.hasNext()) {
				accion = (TipoAccion) j.next();
				if (!acciones.contains(accion))
					acciones.add(accion);
			}
		}
		
		return acciones;
	}
	
	public boolean puedeEjecutar(TipoAccion accion) {
		return getAcciones().contains(accion);
	}
}
