/*
 * Created on 27/07/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.cysdreq.acciones.proyecto;

import java.util.ArrayList;
import java.util.HashMap;

import com.cysdreq.acciones.TipoAccion;
import com.cysdreq.modelo.Proyecto;
import com.cysdreq.modelo.flow.TipoEstado;
import com.cysdreq.modelo.flow.Transicion;
import com.cysdreq.modelo.req.TipoPropiedad;
import com.cysdreq.modelo.req.TipoRequerimiento;
import com.cysdreq.util.PersistentArrayList;

/**
 * @author Nacirita
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ModificarTipoRequerimiento extends TipoAccion {

	/* (non-Javadoc)
	 * @see com.cysdreq.acciones.TipoAccion#ejecutar(java.lang.Object, java.util.HashMap)
	 */
	public void ejecutar(Object receptor, HashMap parametros) {
		Proyecto proyecto = (Proyecto) receptor;

		// Obtiene el tipo de requerimiento que se va a modificar
		TipoRequerimiento tipoReq = (TipoRequerimiento) parametros.get("tipoRequerimiento");

		// Obtiene los nuevos valores
		String nombre = (String) parametros.get("nombre");
		PersistentArrayList estados = (PersistentArrayList) parametros.get("estados");
		PersistentArrayList propiedades = (PersistentArrayList) parametros.get("propiedades");
		PersistentArrayList estadosSiguientes = (PersistentArrayList) parametros.get("estadosSiguientes");
		PersistentArrayList propiedadesDeEstados = (PersistentArrayList) parametros.get("propiedadesDeEstados");

		// Construye un arraylist con las propiedades del estado
		ArrayList tiposPropiedades = new ArrayList();
		for (int i = 0; i < propiedades.size(); i++) {
			String nombrePropiedad = (String) propiedades.get(i);
			TipoPropiedad tipoPropiedad = new TipoPropiedad(nombrePropiedad);
			tiposPropiedades.add(tipoPropiedad);
		}
		
		// Construye un arraylist y un hashmap con los tipos de estados vacíos (solo con su nombre)
		ArrayList tiposDeEstados = new ArrayList();
		HashMap tiposDeEstadosMap = new HashMap();
		for (int i = 0; i < estados.size(); i++) {
			String nombreEstado = (String) estados.get(i);
			TipoEstado tipoEstado = new TipoEstado(nombreEstado);
			tiposDeEstados.add(tipoEstado);
			tiposDeEstadosMap.put(nombreEstado, tipoEstado);
		}
		
		// Recorre los tipos de estados creados
		for (int i = 0; i < tiposDeEstados.size(); i++) {
			TipoEstado tipoEstado = (TipoEstado) tiposDeEstados.get(i);

			// Obtiene los estados siguientes de este tipo de estado
			PersistentArrayList siguientes = (PersistentArrayList) estadosSiguientes.get(i);
			
			// Arma un arraylist de transiciones y se lo setea al tipo de estado
			ArrayList transiciones = new ArrayList();
			for (int j = 0; j < siguientes.size(); j++) {
				String nombreSiguiente = (String) siguientes.get(j);
				TipoEstado estadoSig = (TipoEstado) tiposDeEstadosMap.get(nombreSiguiente);
				
				transiciones.add(new Transicion(estadoSig));
			}
			tipoEstado.setTransiciones(transiciones);

			// Obtiene las propiedades de este tipo de estado
			PersistentArrayList propiedadesEstado = (PersistentArrayList) propiedadesDeEstados.get(i);

			// Arma un arraylist de transiciones y se lo setea al tipo de estado
			ArrayList tiposPropiedadesEstado = new ArrayList();
			for (int j = 0; j < propiedadesEstado.size(); j++) {
				String nombrePropiedad = (String) propiedadesEstado.get(j);
				TipoPropiedad propiedadEstado = new TipoPropiedad(nombrePropiedad);
				
				tiposPropiedadesEstado.add(propiedadEstado);
			}
			tipoEstado.setTiposPropiedades(tiposPropiedadesEstado);
		}

		TipoEstado estadoInicial = (TipoEstado) tiposDeEstados.get(0);
		tipoReq.setNombre(nombre);
		tipoReq.setTiposDeEstados(tiposDeEstados);
		tipoReq.setTipoEstadoInicial(estadoInicial);
		tipoReq.setTiposPropiedades(tiposPropiedades);
	}

	/* (non-Javadoc)
	 * @see com.cysdreq.acciones.TipoAccion#esAccionProyecto()
	 */
	public boolean esAccionProyecto() {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.cysdreq.acciones.TipoAccion#esAccionSistema()
	 */
	public boolean esAccionSistema() {
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object tipoAccion) {
		return (tipoAccion != null && tipoAccion instanceof ModificarTipoRequerimiento);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		Class c = AgregarTipoRequerimiento.class;
		return c.getName().hashCode();
	}

	/* (non-Javadoc)
	 * @see com.cysdreq.acciones.TipoAccion#getName()
	 */
	public String getName() {
		return "Modificar Tipo Requerimiento";
	}

}
