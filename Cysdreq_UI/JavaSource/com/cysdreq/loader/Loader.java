/*
 * Created on 14/06/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.cysdreq.loader;

import javax.jdo.JDOUserException;

import com.cysdreq.modelo.Cysdreq;
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
				
				// TODO Poner acá datos de inicialización
				cysdreq.agregarUsuario(new Usuario("root user", "root", "nousar"));
				System.out.println("Usuario creado");
	        
				//persiste el objeto root
				try {
					PersistenceManagers.makePersistent(SessionManager.getSession(), cysdreq, SessionManager.ROOT_OBJECT_ID);
					System.out.println("Cysdreq guardado");
				} catch (Throwable e1) {
					e1.printStackTrace();
					throw e1;
				}
				System.out.println("Guardó Cysdreq");
			} catch (Throwable t) {
				t.printStackTrace();
				throw t;
			}
		}
		
		//finaliza la transacción.
		SessionManager.commit();
	}

}
