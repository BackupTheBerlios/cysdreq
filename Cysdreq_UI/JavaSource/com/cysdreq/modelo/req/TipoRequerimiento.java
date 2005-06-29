/**
 * 
 */
package com.cysdreq.modelo.req;

import java.util.ArrayList;
import java.util.Iterator;

import com.cysdreq.modelo.Miembro;
import com.cysdreq.modelo.flow.Estado;
import com.cysdreq.modelo.flow.TipoEstado;

/**
 * @author Daniel Nanni
 *
 */
public class TipoRequerimiento {

	private String nombre;
	private ArrayList tiposDeEstados; // Todos los estados del workflow
	private TipoEstado tipoEstadoInicial; // El estado inicial de este tipo de requerimiento
	private ArrayList tiposPropiedades;

	/**
	 * 
	 */
	public TipoRequerimiento() {
		super();
	}

	/**
	 * 
	 */
	public TipoRequerimiento(String nombre,
							 ArrayList tiposDeEstados,
							 TipoEstado estadoInicial,
							 ArrayList tiposPropiedades) {
		super();
		this.setNombre(nombre);
		this.setTiposDeEstados(tiposDeEstados);
		this.setTipoEstadoInicial(estadoInicial);
		this.setTiposPropiedades(tiposPropiedades);
	}

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoEstado getTipoEstadoInicial() {
		return tipoEstadoInicial;
	}

	public void setTipoEstadoInicial(TipoEstado tipoEstadoInicial) {
		this.tipoEstadoInicial = tipoEstadoInicial;
	}

	protected ArrayList getTiposDeEstados() {
		return tiposDeEstados;
	}

	protected void setTiposDeEstados(ArrayList tiposDeEstados) {
		this.tiposDeEstados = tiposDeEstados;
	}

	public void agregarTipoEstado(TipoEstado tipoEstado, boolean esInicial) {
		this.getTiposDeEstados().add(tipoEstado);
		if (esInicial) {
			this.setTipoEstadoInicial(tipoEstado);
		}
	}

	public void sacarTipoEstado(TipoEstado tipoEstado) {
		this.getTiposDeEstados().remove(tipoEstado);
		if (this.getTipoEstadoInicial() == tipoEstado) {
			this.setTipoEstadoInicial(null);
		}
	}

	public ArrayList getTiposPropiedades() {
		return tiposPropiedades;
	}

	protected void setTiposPropiedades(ArrayList tiposPropiedades) {
		this.tiposPropiedades = tiposPropiedades;
	}

	public Requerimiento nuevoRequerimiento(Miembro propietario, Miembro responsable) {
		Estado estadoInicial = this.getTipoEstadoInicial().nuevoEstado(responsable);
		ArrayList propiedades = generarPropiedades(this.getTiposPropiedades());
		Requerimiento req = new Requerimiento(estadoInicial, propietario, propiedades);

		return req;
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
