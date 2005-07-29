/*
 * Created on 14/06/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.cysdreq.loader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.cysdreq.acciones.TipoAccionManager;
import com.cysdreq.acciones.proyecto.AgregarRequerimiento;
import com.cysdreq.acciones.proyecto.AgregarTipoRequerimiento;
import com.cysdreq.modelo.Cysdreq;
import com.cysdreq.modelo.Miembro;
import com.cysdreq.modelo.Proyecto;
import com.cysdreq.modelo.Rol;
import com.cysdreq.modelo.Usuario;
import com.cysdreq.modelo.req.Requerimiento;
import com.cysdreq.modelo.req.TipoRequerimiento;
import com.cysdreq.util.PersistentArrayList;
import com.cysdreq.util.PersistentMap;
import com.poet.jdo.PersistenceManagers;
import com.poet.jdo.admin.DatabaseAdministration;

/**
 * @author Nacirita
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Loader {

	private static final String NOMBRE_REQUERIMIENTO1 = "Desarrollo";

	private static final String ESTADO1 = "Análisis de impacto";
	private static final String ESTADO2 = "Desarrollo";
	private static final String ESTADO3 = "Testing";

	private static final String PROP1 = "Nombre";
	private static final String PROP2 = "Descripción";
	private static final String PROP3 = "Hora";
	private static final String PROP4 = "Detalles";
	private static final String PROP5 = "Aclaraciones";
	private static final String PROP6 = "Problemas encontrados";
	private static final String PROP7 = "Resultado";

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
				
			} catch (Throwable t) {
				t.printStackTrace();
				SessionManager.rollback();
				throw t;
			} finally {
				try {
					//finaliza la transacción.
					SessionManager.commit();
				} catch (Throwable t){}
			}

			try {
				System.out.println("Inicializando DB.");
				SessionManager.beginTransaction();

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
				t.printStackTrace();
				SessionManager.rollback();
				throw t;
			} finally {
				try {
					//finaliza la transacción.
					SessionManager.commit();
				} catch (Throwable t){}
			}
		} finally {
			try {
				//finaliza la transacción.
				SessionManager.commit();
			} catch (Throwable t) {}
		}
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
		ArrayList roles = new ArrayList();
		roles.add(rolSistema);
		roles.add(rolProyecto);
		
		Usuario usuario = new Usuario("root user", "root", "nousar", roles);

		cysdreq.agregarUsuario(usuario);

		System.out.println("Se agregó data de inicialización básica");
	}

	/**
	 * 
	 */
	public static void initTestData(Cysdreq cysdreq) throws Exception {
		// Agrega roles de genericos al sistema
		Rol rolSistema = new Rol("generico sistema", TipoAccionManager.getAccionesSistema());
		Rol rolProyecto = new Rol("generico proyectos", TipoAccionManager.getAccionesProyecto());
		cysdreq.agregarRol(rolSistema);
		cysdreq.agregarRol(rolProyecto);

		Rol rolSistema2 = new Rol("administrador", TipoAccionManager.getAccionesSistema());
		Rol rolProyecto2 = new Rol("proyect lider", TipoAccionManager.getAccionesProyecto());
		cysdreq.agregarRol(rolSistema2);
		cysdreq.agregarRol(rolProyecto2);
		
		// Agrega un usuario test con un rol generico al sistema
		ArrayList roles = new ArrayList();
		roles.add(rolSistema);

		Usuario usuario = new Usuario("test user", "test", "test", roles);
		cysdreq.agregarUsuario(usuario);

		// Agrega un proyecto al sistema
		Proyecto proyecto = new Proyecto("Proyecto de Prueba");
		cysdreq.agregarProyecto(proyecto);

		cysdreq.agregarProyecto(new Proyecto("Lumina Lance"));

		ArrayList roles2 = new ArrayList();
		roles2.add(rolSistema2);
		Usuario usuario2 = new Usuario("Carlos", "Lopez", "lopez", roles2);
		cysdreq.agregarUsuario(usuario2);
				
		roles = new ArrayList();
		roles.add(rolProyecto2);
		Miembro miembro = new Miembro(usuario, roles);
		proyecto.agregarMiembro(miembro);

		// Agrega un miembro al proyecto con roles genericos (de proyecto)
		roles = new ArrayList();
		roles.add(rolProyecto);
		Miembro miembro2 = new Miembro(usuario2, roles);
		proyecto.agregarMiembro(miembro2);
		
		// Alta de un tipo de requerimiento	
		PersistentArrayList estados = new PersistentArrayList(Arrays.asList(new String[] {ESTADO1, ESTADO2, ESTADO3}));
		PersistentArrayList propiedades = new PersistentArrayList(Arrays.asList(new String[] {PROP1, PROP2, PROP3}));

		PersistentArrayList estadosSiguientes = new PersistentArrayList(3); 
		estadosSiguientes.add(new PersistentArrayList(Arrays.asList(new String[] {ESTADO2, ESTADO3}))); 
		estadosSiguientes.add(new PersistentArrayList(Arrays.asList(new String[] {ESTADO3}))); 
		estadosSiguientes.add(new PersistentArrayList(Arrays.asList(new String[] {ESTADO1, ESTADO2}))); 
		
		PersistentArrayList propiedadesDeEstados = new PersistentArrayList(3); 
		propiedadesDeEstados.add(new PersistentArrayList(Arrays.asList(new String[] {PROP4, PROP5}))); 
		propiedadesDeEstados.add(new PersistentArrayList(Arrays.asList(new String[] {PROP6}))); 
		propiedadesDeEstados.add(new PersistentArrayList(Arrays.asList(new String[] {PROP7}))); 

		HashMap params = new HashMap(5);
		params.put("nombre", NOMBRE_REQUERIMIENTO1);
		params.put("estados", estados);
		params.put("propiedades", propiedades);
		params.put("estadosSiguientes", estadosSiguientes);
		params.put("propiedadesDeEstados", propiedadesDeEstados);

		cysdreq.ejecutarAccion(new AgregarTipoRequerimiento(), proyecto, params);

		TipoRequerimiento tipo = proyecto.getTipoRequerimiento(NOMBRE_REQUERIMIENTO1);

		// alta de un requerimiento
		PersistentMap propiedadesGenerales = new PersistentMap();
		propiedadesGenerales.put(PROP1, "Valor de prueba 1");
		propiedadesGenerales.put(PROP2, "Valor de prueba 2");
		propiedadesGenerales.put(PROP3, "Valor de prueba 3");

		PersistentMap propiedadesEstado = new PersistentMap();
		propiedadesEstado.put(PROP4, "Valor de prueba 4");
		propiedadesEstado.put(PROP5, "Valor de prueba 5");

		params = new HashMap(5);
		params.put("tipoRequerimiento", tipo);
		params.put("propietario", miembro);
		params.put("responsable", miembro2);
		params.put("propiedadesGenerales", propiedadesGenerales);
		params.put("propiedadesEstado", propiedadesEstado);
		ArrayList roles3 = new ArrayList();
		roles3.add(rolProyecto2);
		Miembro miembro3 = new Miembro(usuario, roles3);
		proyecto.agregarMiembro(miembro3);		
		cysdreq.ejecutarAccion(new AgregarRequerimiento(), proyecto, params);

		System.out.println("Se agregó data de inicialización para testing");
	}

}
