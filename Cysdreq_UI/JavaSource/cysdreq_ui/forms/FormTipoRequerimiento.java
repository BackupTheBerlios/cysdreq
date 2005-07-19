/*
 * Created on 16/07/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cysdreq_ui.forms;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import cysdreq_ui.bean.GenericBean;

/**
 * @author Nacirita
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class FormTipoRequerimiento extends ActionForm {

	private String nombre = "";
	private String estado = "";
	private String estadoSeleccionado;
	private String propiedad = "";
	private String propiedadSeleccionada;
	private String action = "";
	private String estadosIngresados = "";
	private String propiedadesIngresadas = "";

	/**
	 * @return
	 */
	public String getAction() {
		return action;
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
	public ArrayList getEstados() {
		ArrayList estados = new ArrayList();

		StringTokenizer st = new StringTokenizer(getEstadosIngresados(), "|");
		String token;
		while (st.hasMoreTokens()) {
			token = st.nextToken();
			estados.add(new GenericBean(token));
		}

		if (estados.size() == 0) {
			estados.add(new GenericBean("<Debe agregar estados>"));
		}

		return estados;
	}

	/**
	 * @return
	 */
	public String getEstadoSeleccionado() {
		return estadoSeleccionado;
	}

	/**
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return
	 */
	public String getPropiedad() {
		return propiedad;
	}

	/**
	 * @return
	 */
	public ArrayList getPropiedades() {
		ArrayList propiedades = new ArrayList();

		StringTokenizer st = new StringTokenizer(getPropiedadesIngresadas(), "|");
		String token;
		while (st.hasMoreTokens()) {
			token = st.nextToken();
			propiedades.add(new GenericBean(token));
		}

		if (propiedades.size() == 0) {
			propiedades.add(new GenericBean("<Debe agregar propiedades>"));
		}

		return propiedades;
	}

	/**
	 * @return
	 */
	public String getPropiedadSeleccionada() {
		return propiedadSeleccionada;
	}

	/**
	 * @param string
	 */
	public void setAction(String string) {
		action = string;
	}

	/**
	 * @param string
	 */
	public void setEstado(String string) {
		estado = string;
	}

	/**
	 * @param strings
	 */
	public void setEstadoSeleccionado(String strings) {
		estadoSeleccionado = strings;
	}

	/**
	 * @param string
	 */
	public void setNombre(String string) {
		nombre = string;
	}

	/**
	 * @param string
	 */
	public void setPropiedad(String string) {
		propiedad = string;
	}

	/**
	 * @param strings
	 */
	public void setPropiedadSeleccionada(String strings) {
		propiedadSeleccionada = strings;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		// Validate the fields in your form, adding
		// adding each error to this.errors as found, e.g.

		if ((getNombre() == null) || (getNombre().length() == 0)) {
			errors.add("nombre", new org.apache.struts.action.ActionError("errors.tipoRequerimiento.nombreVacio"));
		}
		if ((getEstadosIngresados() == null) || (getEstadosIngresados().length() == 0)) {
			errors.add("estados", new org.apache.struts.action.ActionError("errors.tipoRequerimiento.estadosVacio"));
		}
		if ((getPropiedadesIngresadas() == null) || (getPropiedadesIngresadas().length() == 0)) {
			errors.add("propiedades", new org.apache.struts.action.ActionError("errors.tipoRequerimiento.propiedadesVacio"));
		}
		return errors;
	}

	/**
	 * @return
	 */
	public String getEstadosIngresados() {
		return estadosIngresados;
	}

	/**
	 * @param string
	 */
	public void setEstadosIngresados(String string) {
		estadosIngresados = string;
	}

	/**
	 * @return
	 */
	public String getPropiedadesIngresadas() {
		return propiedadesIngresadas;
	}

	/**
	 * @param string
	 */
	public void setPropiedadesIngresadas(String string) {
		propiedadesIngresadas = string;
	}

	public void agregarEstado() {
		String est = getEstado();
		if (est != null && est.trim().length() > 0) {
			setEstadosIngresados(getEstadosIngresados() + "|" + est);
		}
		setEstado("");
	}

	public void agregarPropiedad() {
		String prop = getPropiedad();
		if (prop != null && prop.trim().length() > 0) {
			setPropiedadesIngresadas(getPropiedadesIngresadas() + "|" + prop);
		}
		setPropiedad("");
	}

	/**
	 * 
	 */
	public void quitarEstado() {
		String est = getEstadoSeleccionado();

		if (est != null && est.trim().length() > 0 && !est.startsWith("<")) {
			StringBuffer estadosIng = new StringBuffer();
	
			StringTokenizer st = new StringTokenizer(getEstadosIngresados(), "|");
			String token;
			while (st.hasMoreTokens()) {
				token = st.nextToken();
				if (!est.equals(token)) {
					estadosIng.append("|");
					estadosIng.append(token);
				}
			}
			setEstadosIngresados(estadosIng.toString());
		}
	}

	/**
	 * 
	 */
	public void quitarPropiedad() {
		String prop = getPropiedadSeleccionada();

		if (prop != null && prop.trim().length() > 0 && !prop.startsWith("<")) {
			StringBuffer propsIng = new StringBuffer();
	
			StringTokenizer st = new StringTokenizer(getPropiedadesIngresadas(), "|");
			String token;
			while (st.hasMoreTokens()) {
				token = st.nextToken();
				if (!prop.equals(token)) {
					propsIng.append("|");
					propsIng.append(token);
				}
			}
			setPropiedadesIngresadas(propsIng.toString());
		}
	}

}
