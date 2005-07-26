/*
 * Created on 16/07/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cysdreq_ui.forms;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;

import com.cysdreq.util.LabelAndValueListHelper;

/**
 * @author Nacirita
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class FormTipoRequerimiento extends ActionForm {

	public static final String ACCION_AGREGAR_ESTADO = "Agregar Estado";
	public static final String ACCION_QUITAR_ESTADO = "Quitar Estado";
	public static final String ACCION_AGREGAR_PROPIEDAD = "Agregar Propiedad";
	public static final String ACCION_QUITAR_PROPIEDAD = "Quitar Propiedad";
	public static final String ACCION_GUARDAR_TIPO = "Guardar";

	private String nombre = "";
	private String action = "";

	private String estado = "";
	private String estadoSeleccionado;
	private String estadosIngresados = "";

	private String propiedad = "";
	private String propiedadSeleccionada;
	private String propiedadesIngresadas = "";

	private ArrayList propiedadEstados = new ArrayList();
	private ArrayList propiedadSeleccionadaEstados = new ArrayList();
	private ArrayList propiedadesIngresadasEstados = new ArrayList();

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
		return estado.trim();
	}

	/**
	 * @return
	 */
	public ArrayList getEstados() {
		return LabelAndValueListHelper.parseBeansList(getEstadosIngresados(), "<Debe agregar estados>");
	}

	/**
	 * @return
	 */
	public ArrayList getEstadosReales() {
		return LabelAndValueListHelper.parseBeansList(getEstadosIngresados(), null);
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
		return LabelAndValueListHelper.parseBeansList(getPropiedadesIngresadas(), "<Debe agregar propiedades>");
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
		String action = getAction();
		ActionErrors errors = new ActionErrors();
		// Validate the fields in your form, adding
		// adding each error to this.errors as found, e.g.

		if        (action.equals(ACCION_AGREGAR_ESTADO)) {
			if ((getEstado() == null) || (getEstado().trim().length() == 0)) {
				errors.add("nombre", new org.apache.struts.action.ActionError("errors.tipoRequerimiento.estadoVacio"));
			}

		} else if (action.equals(ACCION_QUITAR_ESTADO)) {

		} else if (action.equals(ACCION_AGREGAR_PROPIEDAD)) {

		} else if (action.equals(ACCION_QUITAR_PROPIEDAD)) {

		} else if (action.equals(ACCION_GUARDAR_TIPO)) {
			if ((getNombre() == null) || (getNombre().length() == 0)) {
				errors.add("nombre", new org.apache.struts.action.ActionError("errors.tipoRequerimiento.nombreVacio"));
			}
			if ((getEstadosIngresados() == null) || (getEstadosIngresados().length() == 0)) {
				errors.add("estados", new org.apache.struts.action.ActionError("errors.tipoRequerimiento.estadosVacio"));
			}
			if ((getPropiedadesIngresadas() == null) || (getPropiedadesIngresadas().length() == 0)) {
				errors.add("propiedades", new org.apache.struts.action.ActionError("errors.tipoRequerimiento.propiedadesVacio"));
			}
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
		
		int size = getEstadosReales().size();

		Iterator iter = getEstadosReales().iterator();
		while (iter.hasNext()) {
			LabelValueBean estado = (LabelValueBean) iter.next();
			if (propiedadEstados.size() < size) {
				propiedadEstados.add("");
			}
			if (propiedadEstados.size() < size) {
				propiedadSeleccionadaEstados.add("");
			}
			if (propiedadEstados.size() < size) {
				propiedadesIngresadasEstados.add("");
			}
		}
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
		// Se agregan los strings vacíos a los arrays de propiedades del nuevo estado
		propiedadEstados.add("");
		propiedadSeleccionadaEstados.add("");
		propiedadesIngresadasEstados.add("");

		// Agrega al campo hidden el nuevo estado
		setEstadosIngresados(LabelAndValueListHelper.add(getEstadosIngresados(), getEstado()));
		setEstado("");
	}

	public void agregarPropiedad() {
		setPropiedadesIngresadas(
			LabelAndValueListHelper.add(getPropiedadesIngresadas(), getPropiedad()));
		setPropiedad("");
	}

	/**
	 * 
	 */
	public void quitarEstado() {
		// Borra la data de los arrays de propiedades del estado que se está borrando
		int index = LabelAndValueListHelper.indexOnLabelValueArray(getEstadosReales(), getEstadoSeleccionado());
		propiedadEstados.remove(index);
		propiedadesIngresadasEstados.remove(index);

		// Saca del campo hidden el estado borrado
		setEstadosIngresados(
			LabelAndValueListHelper.remove(getEstadosIngresados(), getEstadoSeleccionado()));
	}

	/**
	 * 
	 */
	public void quitarPropiedad() {
		setPropiedadesIngresadas(
			LabelAndValueListHelper.remove(getPropiedadesIngresadas(), getPropiedadSeleccionada()));
	}

	public String getPropiedadEstados(int index) { 
		return (String) propiedadEstados.get(index); 
	}
    
	public void setPropiedadEstados(int index, String value) {
		setIntoArrayList(propiedadEstados, index, value);
	}

	public String getPropiedadSeleccionadaEstados(int index) { 
		try {
			return (String) propiedadSeleccionadaEstados.get(index); 
		} catch (IndexOutOfBoundsException e) {
			setPropiedadSeleccionadaEstados(index, "");
			return (String) propiedadSeleccionadaEstados.get(index); 
		}
	}
    
	public void setPropiedadSeleccionadaEstados(int index, String value) { 
		setIntoArrayList(propiedadSeleccionadaEstados, index, value);
	}

	public String getPropiedadesIngresadasEstados(int index) { 
		return (String) propiedadesIngresadasEstados.get(index); 
	}
    
	public void setPropiedadesIngresadasEstados(int index, String value) { 
		setIntoArrayList(propiedadesIngresadasEstados, index, value);
	}

	/**
	 * @return
	 */
	public ArrayList getPropiedadesEstados(int index) {
		return LabelAndValueListHelper.parseBeansList(getPropiedadesIngresadasEstados(index), "<Debe agregar propiedades>");
	}

	private void setIntoArrayList(ArrayList array, int index, String value) {
		try {
			array.set(index, value);
		} catch (IndexOutOfBoundsException e) {
			boolean added = false;
			while (!added) {
				try {
					array.add("");
					array.set(index, value);
					added = true;
				} catch (IndexOutOfBoundsException e1) {}
			}
		}
	}

	/**
	 * @param index
	 */
	public void agregarPropiedadEstados(int index) {
		setPropiedadesIngresadasEstados(index,
			LabelAndValueListHelper.add(getPropiedadesIngresadasEstados(index), getPropiedadEstados(index)));
		setPropiedadEstados(index, "");
	}

	/**
	 * @param index
	 */
	public void quitarPropiedadEstados(int index) {
		setPropiedadesIngresadasEstados(index,
			LabelAndValueListHelper.remove(getPropiedadesIngresadasEstados(index), getPropiedadSeleccionadaEstados(index)));
	}

}
