/*
 * Created on 16/07/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cysdreq_ui.forms;

import java.util.ArrayList;
import java.util.Arrays;
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
	private String[] estadoSeleccionado;
	private ArrayList estados = new ArrayList();
	private String propiedad = "";
	private String[] propiedadSeleccionada;
	private ArrayList propiedades = new ArrayList();
	private String action = "";
	private String estadosIngresados = "";

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
		estados = new ArrayList();

		StringTokenizer st = new StringTokenizer(getEstadosIngresados(), "|");
		String token;
		while (st.hasMoreTokens()) {
			token = st.nextToken();
			estados.add(new GenericBean(token));
		}

		return estados;
	}

	/**
	 * @return
	 */
	public String[] getEstadoSeleccionado() {
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
		return propiedades;
	}

	/**
	 * @return
	 */
	public String[] getPropiedadSeleccionada() {
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
	 * @param list
	 */
	public void setEstados(ArrayList list) {
		estados = list;
	}

	/**
	 * @param strings
	 */
	public void setEstadoSeleccionado(String[] strings) {
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
	 * @param list
	 */
	public void setPropiedades(ArrayList list) {
		propiedades = list;
	}

	/**
	 * @param strings
	 */
	public void setPropiedadSeleccionada(String[] strings) {
		propiedadSeleccionada = strings;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	public void reset(ActionMapping actionMapping, HttpServletRequest request) {
		super.reset(actionMapping, request);

/*
		String[] ests = {};
		String[] props = {};

		nombre = "";
		estado = "";
		estadoSeleccionado = ests;
		estados = new ArrayList();
		propiedad = "";
		propiedadSeleccionada = props;
		propiedades = new ArrayList();
		action = "";
*/
	}

	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return super.validate(actionMapping, request);
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

}
