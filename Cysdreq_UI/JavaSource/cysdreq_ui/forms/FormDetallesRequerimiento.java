package cysdreq_ui.forms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;

import com.cysdreq.loader.SessionManager;
import com.cysdreq.modelo.Cysdreq;
import com.cysdreq.modelo.Miembro;
import com.cysdreq.modelo.Proyecto;
import com.cysdreq.modelo.req.TipoRequerimiento;

import cysdreq_ui.actions.LogonAction;
import cysdreq_ui.bean.UserBean;

/**
 * Form bean for a Struts application.
 * @version 	1.0
 * @author
 */
public class FormDetallesRequerimiento extends ActionForm {

	private String reqId;
	private String nombreTipo;
	private String estado;
	private String propietario;
	private String responsable;	
	private ArrayList propiedadesGenerales;
	private ArrayList propiedadesEstado;
	private ArrayList estadosSiguientes;
	private String estadoSiguiente;
	private String action;

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
	public String getReqId() {
		return reqId;
	}

	/**
	 * @param i
	 */
	public void setReqId(String i) {
		reqId = i;
	}

	/**
	 * @return
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @return
	 */
	public String getNombreTipo() {
		return nombreTipo;
	}

	/**
	 * @return
	 */
	public String getPropietario() {
		return propietario;
	}

	/**
	 * @return
	 */
	public String getResponsable() {
		return responsable;
	}

	/**
	 * @param string
	 */
	public void setEstado(String string) {
		estado = string;
	}

	/**
	 * @param string
	 */
	public void setNombreTipo(String string) {
		nombreTipo = string;
	}

	/**
	 * @param string
	 */
	public void setPropietario(String string) {
		propietario = string;
	}

	/**
	 * @param string
	 */
	public void setResponsable(String string) {
		responsable = string;
	}

	/**
	 * @param propiedades
	 */
	public void setPropiedadesGenerales(ArrayList propiedades) {
		propiedadesGenerales = propiedades;
	}

	/**
	 * @param propiedadesEstado
	 */
	public void setPropiedadesEstado(ArrayList propiedades) {
		propiedadesEstado = propiedades;
	}

	/**
	 * @param siguientes
	 */
	public void setEstadosSiguientes(ArrayList siguientes) {
		estadosSiguientes = siguientes;
	}

	/**
	 * @return
	 */
	public ArrayList getEstadosSiguientes() {
		return estadosSiguientes;
	}

	/**
	 * @return
	 */
	public ArrayList getPropiedadesEstado() {
		return propiedadesEstado;
	}

	/**
	 * @return
	 */
	public ArrayList getPropiedadesGenerales() {
		return propiedadesGenerales;
	}

	/**
	 * @return
	 */
	public String getEstadoSiguiente() {
		return estadoSiguiente;
	}

	/**
	 * @param string
	 */
	public void setEstadoSiguiente(String string) {
		estadoSiguiente = string;
	}

	/**
	 * @return
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param string
	 */
	public void setAction(String string) {
		action = string;
	}

}
