package cysdreq_ui.forms;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.cysdreq.loader.SessionManager;
import com.cysdreq.modelo.Cysdreq;
import com.cysdreq.modelo.Proyecto;
import com.cysdreq.modelo.Rol;
import com.cysdreq.modelo.Usuario;
import com.cysdreq.util.PersistentArrayList;

import cysdreq_ui.actions.LogonAction;
import cysdreq_ui.bean.RolBean;
import cysdreq_ui.bean.UserBean;
import cysdreq_ui.bean.UsuarioBean;

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
	private ArrayList usuarios = null;
	private ArrayList roles = null;
	private String nombreProyecto = null;
	private String nombreUsuarioSeleccionado = null; 
			
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

	public void reset(ActionMapping mapping, HttpServletRequest request) {

		// Reset values are provided as samples only. Change as appropriate.
		
		rolesSeleccionados = null;
		nombreUsuarioSeleccionado = "";

		HttpSession session = request.getSession();
		UserBean userBean = (UserBean) session.getAttribute(LogonAction.USER_KEY);

		try {
			// obtiene la transacción asociada al administrador de persistencia.
			SessionManager.beginTransaction();
	
			Cysdreq cysdreq = Cysdreq.getPersistentInstance();
			Proyecto proyecto = cysdreq.getProyecto(userBean.getNombreProyecto());
			setNombreProyecto(proyecto.getNombre());
					
			// arma el ArrayList de roles
			ArrayList rolesExistentes = proyecto.getRoles();
			roles = new ArrayList();
			
			Iterator iter = rolesExistentes.iterator();
			while (iter.hasNext()) {
				Rol rol = (Rol) iter.next();
				
				roles.add(new RolBean(rol));
			}
			
			// arma el ArrayList de usuarios
			ArrayList usuariosExistentes = cysdreq.getUsuarios();
			usuarios = new ArrayList();
			
			Iterator iterator = usuariosExistentes.iterator();
			while (iterator.hasNext()) {
				Usuario usuario = (Usuario) iterator.next();
				
				usuarios.add(new UsuarioBean(usuario));
			}
				
			SessionManager.commit();
			
		} catch (Throwable t) {
			SessionManager.rollback();
			t.printStackTrace();
			System.out.println("Error al recuperar los roles del proyecto");
		}
	}

	public ActionErrors validate(
		ActionMapping mapping,
		HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		// Validate the fields in your form, adding
		// adding each error to this.errors as found, e.g.

		if ((nombreUsuarioSeleccionado == null) || (nombreUsuarioSeleccionado.length() == 0)) {
			errors.add("nombre", new org.apache.struts.action.ActionError("errors.agregarMiembro.nombreVacio"));
		}
		return errors;

	}

	public ArrayList getRoles() {
		return roles;
	}

	public ArrayList getUsuarios() {
		return usuarios;
	}

	/**
	 * @return
	 */
	public PersistentArrayList getRolesPersistentesSeleccionados() {
	
		try {
			Cysdreq cysdreq = Cysdreq.getPersistentInstance();
			Proyecto proyecto = cysdreq.getProyecto(getNombreProyecto());
			String[] rolesSeleccionados = this.getRolesSeleccionados();
			PersistentArrayList roles = new PersistentArrayList(rolesSeleccionados.length);
		
			// recorro los roles y las meto en un PersistentArrayList
			for (int i = 0; i < rolesSeleccionados.length; i++) {
				String nombreRol = rolesSeleccionados[i];
			
				// obtener el rol dado el nombre.
				Rol rol = proyecto.getRolPorNombre(nombreRol);
			
				roles.add(rol);
			}
			return roles;
		} catch (Throwable t) {
			SessionManager.rollback();
			t.printStackTrace();
			System.out.println("Error al recuperar los roles del proyecto");
		}

		return null;
	}
	/**
	 * @return
	 */
	public String getNombreProyecto() {
		return nombreProyecto;
	}

	/**
	 * @param string
	 */
	public void setNombreProyecto(String string) {
		nombreProyecto = string;
	}

	/**
	 * @return
	 */
	public String getNombreUsuarioSeleccionado() {
		return nombreUsuarioSeleccionado;
	}

	/**
	 * @param string
	 */
	public void setNombreUsuarioSeleccionado(String string) {
		nombreUsuarioSeleccionado = string;
	}

}