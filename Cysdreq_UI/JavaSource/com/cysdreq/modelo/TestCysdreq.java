/**
 * 
 */
package com.cysdreq.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.cysdreq.acciones.proyecto.AgregarMiembro;
import com.cysdreq.acciones.sistema.AgregarProyecto;
import com.cysdreq.loader.Loader;

/**
 * @author Daniel Nanni
 *
 */
public class TestCysdreq {

	/**
	 * 
	 */
	public TestCysdreq() {
		super();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Loader.init();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main2(String[] args) {
		Cysdreq sistema = Cysdreq.getInstance();
		
		// Agrega un proyecto
		HashMap pars = new HashMap();
		pars.put("nombreProyecto", "IBM issue tracking");
	/*	sistema.ejecutarAccion(AgregarProyecto.getInstance(), sistema, pars);

		// Agrega un proyecto
		pars.put("nombreProyecto", "Medife issue tracking");
		sistema.ejecutarAccion(AgregarProyecto.getInstance(), sistema, pars);

		// Agrega un miembro
		Proyecto p = (Proyecto) sistema.getProyectos().get(0);
		HashMap pars2 = new HashMap();
		pars2.put("usuario", new Usuario("Dani", "dani", "dani"));
		pars2.put("roles", new ArrayList());
		sistema.ejecutarAccion(AgregarMiembro.getInstance(), p, pars2);

		// Mostrar
		for (Iterator iter = sistema.getProyectos().iterator(); iter.hasNext();) {
			Proyecto element = (Proyecto) iter.next();
			System.out.println(element.getNombre());
		}*/
	}

}
