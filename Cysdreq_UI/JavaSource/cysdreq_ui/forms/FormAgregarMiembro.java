package cysdreq_ui.forms;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.cysdreq.acciones.TipoAccion;
import com.cysdreq.acciones.TipoAccionManager;
import com.cysdreq.acciones.proyecto.AgregarMiembro;
import com.cysdreq.acciones.proyecto.AgregarRequerimiento;
import com.cysdreq.acciones.proyecto.AgregarRolProyecto;
import com.cysdreq.acciones.proyecto.AgregarTipoRequerimiento;
import com.cysdreq.acciones.sistema.AgregarProyecto;
import com.cysdreq.acciones.sistema.AgregarRolSistema;
import com.cysdreq.acciones.sistema.AgregarUsuario;
import com.cysdreq.modelo.Cysdreq;
import com.cysdreq.modelo.Proyecto;
import com.cysdreq.modelo.Rol;
import com.cysdreq.util.PersistentArrayList;

import cysdreq_ui.actions.LogonAction;
import cysdreq_ui.bean.RolBean;
import cysdreq_ui.bean.TipoAccionBean;
import cysdreq_ui.bean.UserBean;

/**
 * Form bean for a Struts application.
 * Users may access 2 fields on this form:
 * <ul>
 * <li>acciones - [your comment here]
 * <li>nombre - [your comment here]
 * </ul>
 * @version 	1.0
 * @author
 */
public class FormAgregarMiembro extends ActionForm {

	private String[] rolesSeleccionados = null;
	private String nombre = null;

	/**
	 * Get acciones
	 * @return String[]
	 */
	public String[] getRolesSeleccionados() {
		return rolesSeleccionados;
	}

	/**
	 * Set acciones
	 * @param <code>String[]</code>
	 */
	public void setRolesSeleccionados(String[] a) {
		this.rolesSeleccionados = a;
	}

	/**
	 * Get nombre
	 * @return String
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Set nombre
	 * @param <code>String</code>
	 */
	public void setNombre(String n) {
		this.nombre = n;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {

		// Reset values are provided as samples only. Change as appropriate.

		rolesSeleccionados = null;
		nombre = "";

	}

	public ActionErrors validate(
		ActionMapping mapping,
		HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		// Validate the fields in your form, adding
		// adding each error to this.errors as found, e.g.

		if ((nombre == null) || (nombre.length() == 0)) {
			errors.add("nombre", new org.apache.struts.action.ActionError("errors.agregarMiembro.nombreVacio"));
		}
		return errors;

	}

	public ArrayList getRoles() {
//		como obtengo la session ??		
//		HttpSession session = request.getSession();
//		UserBean userBean = (UserBean) session.getAttribute(LogonAction.USER_KEY);
		Cysdreq cysdreq = Cysdreq.getPersistentInstance();
//		Proyecto proyecto = cysdreq.getProyecto(userBean.getNombreProyecto());
		Proyecto proyecto = cysdreq.getProyecto("Medife");
		
		ArrayList rolesExistentes = proyecto.getRoles();
		ArrayList roles = new ArrayList();
		
		Iterator iter = rolesExistentes.iterator();
		while (iter.hasNext()) {
			Rol rol = (Rol) iter.next();
			
			roles.add(new RolBean(rol));
		}

		return roles;
	}

	/**
	 * @return
	 */
	public PersistentArrayList getRolesPersistentesSeleccionados() {
	
		String[] rolesSeleccionados = this.getRolesSeleccionados();
			
		PersistentArrayList roles = new PersistentArrayList(rolesSeleccionados.length);

		Cysdreq cysdreq = Cysdreq.getPersistentInstance();		
		Proyecto proyecto = cysdreq.getProyecto("Medife");	

		// recorro los roles y las meto en un PersistentArrayList
		for (int i = 0; i < rolesSeleccionados.length; i++) {
			String nombreRol = rolesSeleccionados[i];
			
			// obtener el rol dado el nombre.
			// manager tambien???
				
			Rol rol = proyecto.getNombreRol(nombreRol);
			
			
			roles.add(rol);
		}

		return roles;
	}
}