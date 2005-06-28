/*
 * Created on 18/06/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.cysdreq.loader;

import java.util.Properties;

import javax.jdo.JDOHelper;
import javax.jdo.JDOUserException;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

/**
 * @author Nacirita
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SessionManager {

	public static String ROOT_OBJECT_ID = "CYSDREQ";
	private static PersistenceManagerFactory pmfactory;
	
	private static ThreadLocal session = new ThreadLocal();

	/**
	 * Notify the manager that the current thread is starting to work in
	 * transaction mode.
	 */
	public static void beginTransaction() throws JDOUserException {
		System.out.println("Intentando beginTransaction");
		PersistenceManager pm = SessionManager.getPmfactory().getPersistenceManager();
		Transaction t = pm.currentTransaction();
		t.begin();
		session.set(pm);
		System.out.println("Finalizando beginTransaction");
	}

	/**
	 * Commit the current transaction.
	 */
	public static void commit() throws JDOUserException {
		System.out.println("Intentando commit");
		PersistenceManager pm = (PersistenceManager) session.get();
		Transaction t = pm.currentTransaction();
		session.set(null);
		t.commit();
		pm.close();
		System.out.println("Finalizando commit");
	}

	/**
	 * Rollback the current transaction.
	 */
	public static void rollback() throws JDOUserException {
		System.out.println("Intentando rollback");
		PersistenceManager pm = (PersistenceManager) session.get();
		Transaction t = pm.currentTransaction();
		session.set(null);
		t.rollback();
		pm.close();
		System.out.println("Finalizando rollback");
	}

	public static PersistenceManager getSession() throws JDOUserException {
		return (PersistenceManager) session.get();
	}

	public static Transaction getTransaction() throws JDOUserException {
		PersistenceManager pm = (PersistenceManager) session.get();
		return pm.currentTransaction();
	}

	public static PersistenceManagerFactory getPmfactory() {
		if (pmfactory == null) {
			Properties properties = new Properties();

			//este es el nombre de la clase que se usa para instanciar los
			//persistenceManagers.
			properties.setProperty("javax.jdo.PersistenceManagerFactoryClass",
					"com.poet.jdo.PersistenceManagerFactories");
		
			//esta es la ubicación del archivo de la base de datos.
			properties.setProperty("javax.jdo.option.ConnectionURL",
				//	"fastobjects://LOCAL/Cysdreq.j1");
			        "fastobjects://LOCAL/c:\\Cysdreq.j1");

			setPmfactory(JDOHelper.getPersistenceManagerFactory(properties));
		}
		return pmfactory;
	}

	/**
	 * @param factory
	 */
	private static void setPmfactory(PersistenceManagerFactory factory) {
		pmfactory = factory;
	}

}
