package cysdreq_ui.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

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
public class FormAgregarRolSistema extends ActionForm {

	private String[] acciones = null;
	private String nombre = null;

	/**
	 * Get acciones
	 * @return String[]
	 */
	public String[] getAcciones() {
		return acciones;
	}

	/**
	 * Set acciones
	 * @param <code>String[]</code>
	 */
	public void setAcciones(String[] a) {
		this.acciones = a;
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

		acciones = null;
		nombre = "";

	}

	public ActionErrors validate(
		ActionMapping mapping,
		HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		// Validate the fields in your form, adding
		// adding each error to this.errors as found, e.g.

		if ((nombre == null) || (nombre.length() == 0)) {
			errors.add("nombre", new org.apache.struts.action.ActionError("errors.registrarRolSistema.nombreVacio"));
		}
		return errors;

	}
}
