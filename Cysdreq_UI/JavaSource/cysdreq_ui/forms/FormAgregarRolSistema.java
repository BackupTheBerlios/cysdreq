package cysdreq_ui.forms;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.cysdreq.acciones.proyecto.AgregarMiembro;
import com.cysdreq.acciones.proyecto.AgregarRequerimiento;
import com.cysdreq.acciones.proyecto.AgregarRolProyecto;
import com.cysdreq.acciones.proyecto.AgregarTipoRequerimiento;
import com.cysdreq.acciones.sistema.AgregarProyecto;
import com.cysdreq.acciones.sistema.AgregarRolSistema;
import com.cysdreq.acciones.sistema.AgregarUsuario;

import cysdreq_ui.bean.TipoAccionBean;

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

	private String[] accionesSeleccionadas = null;
	private String nombre = null;

	/**
	 * Get acciones
	 * @return String[]
	 */
	public String[] getAccionesSeleccionadas() {
		return accionesSeleccionadas;
	}

	/**
	 * Set acciones
	 * @param <code>String[]</code>
	 */
	public void setAccionesSeleccionadas(String[] a) {
		this.accionesSeleccionadas = a;
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

		accionesSeleccionadas = null;
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

	public ArrayList getAcciones() {
		ArrayList acciones = new ArrayList();
		acciones.add(new TipoAccionBean(new AgregarMiembro()));
		acciones.add(new TipoAccionBean(new AgregarRequerimiento()));
		acciones.add(new TipoAccionBean(new AgregarRolProyecto()));
		acciones.add(new TipoAccionBean(new AgregarTipoRequerimiento()));
		acciones.add(new TipoAccionBean(new AgregarProyecto()));
		acciones.add(new TipoAccionBean(new AgregarRolSistema()));
		acciones.add(new TipoAccionBean(new AgregarUsuario()));

		return acciones;
	}
}
