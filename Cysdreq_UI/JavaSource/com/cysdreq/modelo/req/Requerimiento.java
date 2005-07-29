/**
 * 
 */
package com.cysdreq.modelo.req;

import java.util.ArrayList;
import java.util.Iterator;

import com.cysdreq.modelo.Cysdreq;
import com.cysdreq.modelo.Miembro;
import com.cysdreq.modelo.flow.Estado;
import com.cysdreq.modelo.flow.Transicion;
import com.cysdreq.util.PersistentMap;

/**
 * @author Daniel Nanni
 *
 */
public class Requerimiento {

	private int id;
	private TipoRequerimiento tipo;
	private Estado estadoActual;
	private Miembro propietario;

	// Propiedades comunes a todos los estados del requerimiento
	private ArrayList propiedades;

	public Requerimiento() {
		super();
	}

	/**
	 * @param propiedades2 
	 * @param list 
	 * 
	 */
	public Requerimiento(Estado estadoInicial,
						 Miembro propietario,
						 ArrayList propiedades) {
		super();
		this.setEstadoActual(estadoInicial);
		this.setPropietario(propietario);
		this.setPropiedades(propiedades);

		// Setea el próximo Id a usar
		Cysdreq cysdreq = Cysdreq.getPersistentInstance();
		int nextId = cysdreq.getNumeradores().getNextId(Requerimiento.class.getName());
		this.setId(nextId);
	}

	public Estado getEstadoActual() {
		return estadoActual;
	}

	public void setEstadoActual(Estado estadoActual) {
		this.estadoActual = estadoActual;
	}

	public Miembro getPropietario() {
		return propietario;
	}

	protected void setPropietario(Miembro propietario) {
		this.propietario = propietario;
	}

	public TipoRequerimiento getTipo() {
		return tipo;
	}

	protected void setTipo(TipoRequerimiento tipo) {
		this.tipo = tipo;
	}

	public void cambiarEstado(Estado nuevoEstado) {
		this.setEstadoActual(nuevoEstado);
	}

	public void ejecutarTransicion(Transicion transicion, Miembro miembro) {
		transicion.ejecutar(this, miembro);
	}

	protected ArrayList getPropiedades() {
		return propiedades;
	}

	protected void setPropiedades(ArrayList propiedades) {
		this.propiedades = propiedades;
	}

	public int getId() {
		return id;
	}

	public void setId(int i) {
		id = i;
	}

	/**
	 * @param propiedadesGenerales
	 */
	public void setPropiedadesGenerales(PersistentMap propiedadesGenerales) {
		Iterator iter = getPropiedades().iterator();
		while (iter.hasNext()) {
			Propiedad propiedad = (Propiedad) iter.next();
			
			String key = propiedad.getTipo().getNombre();
			String valor = (String) propiedadesGenerales.get(key);
			if (valor == null) {
				valor = "";
			}
			propiedad.setValor(valor);
		}
	}

	/**
	 * @param propiedadesEstado
	 */
	public void setPropiedadesEstadoActual(PersistentMap propiedadesEstado) {
		Iterator iter = getEstadoActual().getPropiedades().iterator();
		while (iter.hasNext()) {
			Propiedad propiedad = (Propiedad) iter.next();
			
			String key = propiedad.getTipo().getNombre();
			String valor = (String) propiedadesEstado.get(key);
			if (valor == null) {
				valor = "";
			}
			propiedad.setValor(valor);
		}
	}

}
