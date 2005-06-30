package cysdreq_ui.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

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

		password = null;
		usuario = null;
		nombre = null;

	}

	public ActionErrors validate(
		ActionMapping mapping,
		HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		// Validate the fields in your form, adding
		// adding each error to this.errors as found, e.g.

		if ((nombre == null) || (nombre.length() == 0)) {
			errors.add("nombre", new org.apache.struts.action.ActionError("error.errors.registrarUsuario.nombreVacio"));
		}
		if ((usuario == null) || (usuario.length() == 0)) {
			errors.add("usuario", new org.apache.struts.action.ActionError("error.errors.registrarUsuario.usuarioVacio"));
		}
		if ((password == null) || (password.length() == 0)) {
			errors.add("password", new org.apache.struts.action.ActionError("error.errors.registrarUsuario.passwordVacio"));
		}
		return errors;

	}
}
