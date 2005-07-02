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
import com.cysdreq.acciones.proyecto.*;
import com.cysdreq.acciones.sistema.*;
import com.cysdreq.modelo.Cysdreq;
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
		// Agrega un rol de administrador al sistema
		Rol rol = new Rol("administrador", getAcciones());
		cysdreq.agregarRol(rol);

		// Agrega un usuario rool con rol de administrador al sistema
		Usuario usuario = new Usuario("root user", "root", "nousar");
		ArrayList roles = new ArrayList();
		roles.add(rol);
		usuario.setRoles(roles);
		cysdreq.agregarUsuario(usuario);

		System.out.println("Se agregó data de inicialización básica");
	}

	/**
	 * 
	 */
	private static ArrayList getAcciones() throws Exception {

		ArrayList acciones = new ArrayList();
		acciones.add(new AgregarMiembro());
		acciones.add(new AgregarRequerimiento());
		acciones.add(new AgregarRolProyecto());
		acciones.add(new AgregarTipoRequerimiento());
		acciones.add(new AgregarProyecto());
		acciones.add(new AgregarRolSistema());
		acciones.add(new AgregarUsuario());

		return acciones;
	}

}
