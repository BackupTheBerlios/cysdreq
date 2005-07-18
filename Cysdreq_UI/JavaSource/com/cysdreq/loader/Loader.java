/*
 * Created on 14/06/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.cysdreq.loader;

import java.util.ArrayList;

import javax.jdo.JDOUserException;

import com.cysdreq.acciones.TipoAccion;
import com.cysdreq.acciones.TipoAccionManager;
import com.cysdreq.acciones.proyecto.*;
import com.cysdreq.acciones.sistema.*;
import com.cysdreq.modelo.Cysdreq;
import com.cysdreq.modelo.Miembro;
import com.cysdreq.modelo.Proyecto;
import com.cysdreq.modelo.Rol;
import com.cysdreq.modelo.Usuario;
import com.poet.jdo.PersistenceManagers;
import com.poet.jdo.admin.DatabaseAdministration;

/**
 * @author Nacirita
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Loader {

	public static void init() throws Throwable {
		try	{
			SessionManager.beginTransaction();
		} catch (Throwable e) {
			//si entra acá es porque la base de datos todavía no existe.
			System.out.println("La base no existe... creando la base");
			//esta línea crea el archivo de la base de datos.
			try {
				DatabaseAdministration.create(SessionManager.getPmfactory().getConnectionURL(), null);
				SessionManager.beginTransaction();
			} catch (Throwable e1) {
				e1.printStackTrace();
				throw e1;
			}
			System.out.println("Base de datos creada.");			
		}

		Cysdreq cysdreq = null;
		try {
			cysdreq = (Cysdreq) PersistenceManagers.findObject(SessionManager.getSession(), SessionManager.ROOT_OBJECT_ID);
			System.out.println("Obtuvo objeto root Cysdreq");
		} catch (Exception e) {
			try {
				System.out.println("Objecto root Cysdreq no existe... creando.");
				// instancia un sistema
				cysdreq = Cysdreq.getInstance();
				System.out.println("Cysdreq instanciado");
				
				// Agrega datos de inicialización
				initBasicData(cysdreq);
				
				// TODO Sacar esto y ponerlo en una página
				// Se puede hacer que cysdreq tenga una variable booleana indicando
				// si ya fue inicializado o no con data de testing
				initTestData(cysdreq);
				
				// persiste el objeto root
				try {
					PersistenceManagers.makePersistent(SessionManager.getSession(), cysdreq, SessionManager.ROOT_OBJECT_ID);
				} catch (Throwable e1) {
					e1.printStackTrace();
					throw e1;
				}
				System.out.println("Cysdreq inicializado");
			} catch (Throwable t) {
				SessionManager.rollback();
				t.printStackTrace();
				throw t;
			}
		}

		//finaliza la transacción.
		SessionManager.commit();
	}

	/**
	 * 
	 */
	private static void initBasicData(Cysdreq cysdreq) throws Exception {
		// Agrega roles de administrador al sistema
		Rol rolSistema = new Rol("administrador sistema", TipoAccionManager.getAccionesSistema());
		Rol rolProyecto = new Rol("administrador proyectos", TipoAccionManager.getAccionesProyecto());
		cysdreq.agregarRol(rolSistema);
		cysdreq.agregarRol(rolProyecto);

		// Agrega un usuario root con roles de administrador al sistema
		Usuario usuario = new Usuario("root user", "root", "nousar");
		ArrayList roles = new ArrayList();
		roles.add(rolSistema);
		roles.add(rolProyecto);
		usuario.setRoles(roles);
		cysdreq.agregarUsuario(usuario);

		System.out.println("Se agregó data de inicialización básica");
	}

	/**
	 * 
	 */
	private static void initTestData(Cysdreq cysdreq) throws Exception {
		// Agrega roles de genericos al sistema
		Rol rolSistema = new Rol("generico sistema", TipoAccionManager.getAccionesSistema());
		Rol rolProyecto = new Rol("generico proyectos", TipoAccionManager.getAccionesProyecto());
		cysdreq.agregarRol(rolSistema);
		cysdreq.agregarRol(rolProyecto);

		// Agrega un usuario test con un rol generico al sistema
		Usuario usuario = new Usuario("test user", "test", "test");
		ArrayList roles = new ArrayList();
		roles.add(rolSistema);
		usuario.setRoles(roles);
		cysdreq.agregarUsuario(usuario);

		// Agrega un proyecto al sistema
		Proyecto proyecto = new Proyecto("Proyecto de Prueba");
		cysdreq.agregarProyecto(proyecto);

		// Agrega un miembro al proyecto con roles genericos (de proyecto)
		roles = new ArrayList();
		roles.add(rolProyecto);
		Miembro miembro = new Miembro(usuario, roles);
		proyecto.agregarMiembro(miembro);

		System.out.println("Se agregó data de inicialización para testing");
	}

}
