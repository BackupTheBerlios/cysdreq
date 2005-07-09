/*
 * Created on 09/07/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.cysdreq.acciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.cysdreq.acciones.proyecto.AgregarMiembro;
import com.cysdreq.acciones.proyecto.AgregarRequerimiento;
import com.cysdreq.acciones.proyecto.AgregarRolProyecto;
import com.cysdreq.acciones.proyecto.AgregarTipoRequerimiento;
import com.cysdreq.acciones.sistema.AgregarProyecto;
import com.cysdreq.acciones.sistema.AgregarRolSistema;
import com.cysdreq.acciones.sistema.AgregarUsuario;

/**
 * @author Nacirita
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TipoAccionManager {

	/**
	 * 
	 */
	private TipoAccionManager() {
		super();
	}

	public static ArrayList getAccionesProyecto() {
		ArrayList acciones = new ArrayList();
		acciones.add(new AgregarMiembro());
		acciones.add(new AgregarRequerimiento());
		acciones.add(new AgregarRolProyecto());
		acciones.add(new AgregarTipoRequerimiento());

		return acciones;
	}

	public static ArrayList getAccionesSistema() {
		ArrayList acciones = new ArrayList();
		acciones.add(new AgregarProyecto());
		acciones.add(new AgregarRolSistema());
		acciones.add(new AgregarUsuario());

		return acciones;
	}

	public static HashMap getAccionesProyectoMap() {
		HashMap acciones = new HashMap();
		
		Iterator iter = getAccionesProyecto().iterator();
		while (iter.hasNext()) {
			TipoAccion tipoAccion = (TipoAccion) iter.next();
			acciones.put(tipoAccion.getName(), tipoAccion);
		}

		return acciones;
	}

	public static HashMap getAccionesSistemaMap() {
		HashMap acciones = new HashMap();

		Iterator iter = getAccionesSistema().iterator();
		while (iter.hasNext()) {
			TipoAccion tipoAccion = (TipoAccion) iter.next();
			acciones.put(tipoAccion.getName(), tipoAccion);
		}

		return acciones;
	}

	public static TipoAccion getAccionSistema(String nombreAccion) {
		return (TipoAccion) getAccionesSistemaMap().get(nombreAccion);
	}

	public static TipoAccion getAccionProyecto(String nombreAccion) {
		return (TipoAccion) getAccionesProyectoMap().get(nombreAccion);
	}

}
