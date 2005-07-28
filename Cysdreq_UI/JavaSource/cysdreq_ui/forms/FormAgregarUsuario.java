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
 * Users may access 3 fields on this form:
 * <ul>
 * <li>password - [your comment here]
 * <li>usuario - [your comment here]
 * <li>nombre - [your comment here]
 * </ul>
 * @version 	1.0
 * @author
 */
public class FormAgregarUsuario extends ActionForm {

	private String password = null;
	private String usuario = null;
	private String nombre = null;
	private String[] rolesSeleccionados = null;
	private ArrayList roles = null;	
	
	/**
	 * Get password
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set password
	 * @param <code>String</code>
	 */
	public void setPassword(String p) {
		this.password = p;
	}

	/**
	 * Get usuario
	 * @return String
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Set usuario
	 * @param <code>String</code>
	 */
	public void setUsuario(String u) {
		this.usuario = u;
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
		

		HttpSession session = request.getSession();
		UserBean userBean = (UserBean) session.getAttribute(LogonAction.USER_KEY);

		try {
			// obtiene la transacción asociada al administrador de persistencia.
			SessionManager.beginTransaction();
	
			Cysdreq cysdreq = Cysdreq.getPersistentInstance();
					
			// arma el ArrayList de roles
			ArrayList rolesExistentes = cysdreq.getRoles();
			roles = new ArrayList();
			
			Iterator iter = rolesExistentes.iterator();
			while (iter.hasNext()) {
				Rol rol = (Rol) iter.next();
				
				roles.add(new RolBean(rol));
			}
		
			SessionManager.commit();
			
		} catch (Throwable t) {
			SessionManager.rollback();
			t.printStackTrace();
			System.out.println("Error al recuperar los roles del sistema");
		}
	}

	public ArrayList getRoles() {
		return roles;
	}
		
	public void setRolesSeleccionados(String[] r) {
		rolesSeleccionados = r;
	}

	public String[] getRolesSeleccionados() {
		return rolesSeleccionados;
	}
	
	public PersistentArrayList getRolesPersistentesSeleccionados() {
	
		try {
			Cysdreq cysdreq = Cysdreq.getPersistentInstance();

			String[] rolesSeleccionados = this.getRolesSeleccionados();
			PersistentArrayList roles = new PersistentArrayList(rolesSeleccionados.length);
		
			// recorro los roles y las meto en un PersistentArrayList
			for (int i = 0; i < rolesSeleccionados.length; i++) {
				String nombreRol = rolesSeleccionados[i];
				// obtener el rol dado el nombre.
				Rol rol = cysdreq.getRolPorNombre(nombreRol);
			
				roles.add(rol);
			}
			return roles;
		} catch (Throwable t) {
			t.printStackTrace();
			SessionManager.rollback();
			System.out.println("Error al recuperar los roles de sistema");
		}

		return null;
	}
	
	public ActionErrors validate(
		ActionMapping mapping,
		HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		// Validate the fields in your form, adding
		// adding each error to this.errors as found, e.g.

		if ((nombre == null) || (nombre.length() == 0)) {
			errors.add("nombre", new org.apache.struts.action.ActionError("errors.registrarUsuario.nombreVacio"));
		}
		if ((usuario == null) || (usuario.length() == 0)) {
			errors.add("usuario", new org.apache.struts.action.ActionError("errors.registrarUsuario.usuarioVacio"));
		}
		if ((password == null) || (password.length() == 0)) {
			errors.add("password", new org.apache.struts.action.ActionError("errors.registrarUsuario.passwordVacio"));
		}
		return errors;

	}
}
