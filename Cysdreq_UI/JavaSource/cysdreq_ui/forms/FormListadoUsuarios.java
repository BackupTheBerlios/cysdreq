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

import cysdreq_ui.actions.LogonAction;
import cysdreq_ui.bean.ListadoUsuariosBean;
import cysdreq_ui.bean.UserBean;

/**
 * Form bean for a Struts application.
 * Users may access 3 fields on this form:
 * <ul>
 * <li>login - [your comment here]
 * <li>roles - [your comment here]
 * <li>nombre - [your comment here]
 * </ul>
 * @version 	1.0
 * @author
 */
public class FormListadoUsuarios extends ActionForm {

	private String login = null;
	private String roles = null;
	private String nombre = null;
	private ArrayList usuariosReales = new ArrayList();

	/**
	 * Get login
	 * @return String
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Set login
	 * @param <code>String</code>
	 */
	public void setLogin(String l) {
		this.login = l;
	}

	/**
	 * Get roles
	 * @return String
	 */
	public String getRoles() {
		return roles;
	}

	/**
	 * Set roles
	 * @param <code>String</code>
	 */
	public void setRoles(String r) {
		this.roles = r;
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

		login = null;
		roles = null;
		nombre = null;

		HttpSession session = request.getSession();
		UserBean userBean = (UserBean) session.getAttribute(LogonAction.USER_KEY);

		try {
			// obtiene la transacción asociada al administrador de persistencia.
			SessionManager.beginTransaction();
	
			Cysdreq cysdreq = Cysdreq.getPersistentInstance();
			Proyecto proyecto = cysdreq.getProyecto(userBean.getNombreProyecto());
			//setNombreProyecto(proyecto.getNombre());
					
			
			// arma el ArrayList de usuarios
			ArrayList usuariosExistentes = cysdreq.getUsuarios();
			usuariosReales = new ArrayList();
			
			Iterator iterator = usuariosExistentes.iterator();
			while (iterator.hasNext()) {
				Usuario usuario = (Usuario) iterator.next();
				
				usuariosReales.add(new ListadoUsuariosBean(usuario.getNombre(), usuario.getUsuario(),getStringRoles(usuario.getRoles()),"pepe"));
			}
				
			SessionManager.commit();
			
		} catch (Throwable t) {
			SessionManager.rollback();
			t.printStackTrace();
			System.out.println("Error al recuperar los usuarios del sistema");
		}
	}

	public ActionErrors validate(
		ActionMapping mapping,
		HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		// Validate the fields in your form, adding
		// adding each error to this.errors as found, e.g.

		// if ((field == null) || (field.length() == 0)) {
		//   errors.add("field", new org.apache.struts.action.ActionError("error.field.required"));
		// }
		return errors;

	}
	/**
	 * @return
	 */
	public ArrayList getUsuariosReales() {
		return usuariosReales;
	}

	/**
	 * @param list
	 */
	public void setUsuariosReales(ArrayList list) {
		usuariosReales = list;
	}
	
	public String getStringRoles(ArrayList roles){
		
		String stringRoles = "";
		
		Iterator iterator = roles.iterator();
		while (iterator.hasNext()) {
			Rol rol = (Rol) iterator.next();
			stringRoles = stringRoles + rol.getNombre() + ", ";

		}
		if (stringRoles.length() > 0){
			stringRoles = stringRoles.substring(0, stringRoles.length()-3);
		
		}
		
		return stringRoles;
	}
	
	
}
