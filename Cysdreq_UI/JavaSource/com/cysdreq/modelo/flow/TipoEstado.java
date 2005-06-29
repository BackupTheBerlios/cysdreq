/**
 * 
 */
package com.cysdreq.modelo.flow;

import java.util.ArrayList;
import java.util.Iterator;

import com.cysdreq.modelo.Miembro;
import com.cysdreq.modelo.req.TipoPropiedad;

/**
 * @author Daniel Nanni
 *
 */
public class TipoEstado {

	private String nombre;
	private ArrayList transiciones;
	private ArrayList tiposPropiedades;

	/**
	 * 
	 */
	public TipoEstado() {
		super();
	}

	/**
	 * 
	 */
	public TipoEstado(String nombre) {
		super();
		this.setNombre(nombre);
		this.setTransiciones(new ArrayList());
		this.setTiposPropiedades(new ArrayList());
	}

	public String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList getTransiciones() {
		return transiciones;
	}

	protected void setTransiciones(ArrayList proximosEstados) {
		this.transiciones = proximosEstados;
	}

	public ArrayList getTiposPropiedades() {
		return tiposPropiedades;
	}

	protected void setTiposPropiedades(ArrayList tiposPropiedades) {
		this.tiposPropiedades = tiposPropiedades;
	}

	public Estado nuevoEstado(Miembro responsable) {
		ArrayList propiedades = generarPropiedades(this.getTiposPropiedades());
		return new Estado(this, responsable, propiedades);
	}

	private ArrayList generarPropiedades(ArrayList tiposDePropiedades) {
		ArrayList propiedades = new ArrayList();

		Iterator tipos = tiposDePropiedades.iterator();
		while (tipos.hasNext()) {
			TipoPropiedad tipo = (TipoPropiedad) tipos.next();
			propiedades.add(tipo.nuevaPropiedad());
		}
		
		return propiedades;
	}
}
