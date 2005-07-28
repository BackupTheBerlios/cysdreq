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
	public static final String ACCION_GUARDAR_TIPO = "Guardar Tipo de Requerimiento";

	// Estas dos variables son para usar la misma página como modificación
	private boolean modificacion = false;
	private String nombreTipoModificado = "";

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

	private ArrayList estadoSiguienteSeleccionadoIzq = new ArrayList();
	private ArrayList estadoSiguienteSeleccionadoDer = new ArrayList();
	private ArrayList estadosSiguientesIngresados = new ArrayList();

	public String getAction() {
		return action;
	}

	public String getEstado() {
		return estado.trim();
	}

	public ArrayList getEstados() {
		return LabelAndValueListHelper.parseBeansList(getEstadosIngresados(), "<Debe agregar estados>");
	}

	public ArrayList getEstadosReales() {
		return LabelAndValueListHelper.parseBeansList(getEstadosIngresados(), null);
	}

	public ArrayList getNombresEstadosReales() {
		return LabelAndValueListHelper.parseStringList(getEstadosIngresados());
	}

	public String getEstadoSeleccionado() {
		return estadoSeleccionado;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPropiedad() {
		return propiedad;
	}

	public ArrayList getPropiedades() {
		return LabelAndValueListHelper.parseBeansList(getPropiedadesIngresadas(), "<Debe agregar propiedades>");
	}

	public ArrayList getPropiedadesReales() {
		return LabelAndValueListHelper.parseBeansList(getPropiedadesIngresadas(), null);
	}

	public ArrayList getNombresPropiedadesReales() {
		return LabelAndValueListHelper.parseStringList(getPropiedadesIngresadas());
	}

	public String getPropiedadSeleccionada() {
		return propiedadSeleccionada;
	}

	public void setAction(String string) {
		action = string;
	}

	public void setEstado(String string) {
		estado = string;
	}

	public void setEstadoSeleccionado(String strings) {
		estadoSeleccionado = strings;
	}

	public void setNombre(String string) {
		nombre = string;
	}

	public void setPropiedad(String string) {
		propiedad = string;
	}

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

	public String getEstadosIngresados() {
		return estadosIngresados;
	}

	public void setEstadosIngresados(String string) {
		estadosIngresados = string;
		
		int size = getEstadosReales().size();

		Iterator iter = getEstadosReales().iterator();
		while (iter.hasNext()) {
			LabelValueBean estado = (LabelValueBean) iter.next();
			if (propiedadEstados.size() < size) {
				propiedadEstados.add("");
			}
			if (propiedadSeleccionadaEstados.size() < size) {
				propiedadSeleccionadaEstados.add("");
			}
			if (propiedadesIngresadasEstados.size() < size) {
				propiedadesIngresadasEstados.add("");
			}
			if (estadoSiguienteSeleccionadoIzq.size() < size) {
				estadoSiguienteSeleccionadoIzq.add("");
			}
			if (estadoSiguienteSeleccionadoDer.size() < size) {
				estadoSiguienteSeleccionadoDer.add("");
			}
			if (estadosSiguientesIngresados.size() < size) {
				estadosSiguientesIngresados.add("");
			}
		}
	}

	public String getPropiedadesIngresadas() {
		return propiedadesIngresadas;
	}

	public void setPropiedadesIngresadas(String string) {
		propiedadesIngresadas = string;
	}

	public void agregarEstado() {
		// Se agregan los strings vacíos a los arrays de propiedades del nuevo estado
		propiedadEstados.add("");
		propiedadSeleccionadaEstados.add("");
		propiedadesIngresadasEstados.add("");

		// Se agregan los strings vacíos a los arrays de estados siguientes del nuevo estado
		estadoSiguienteSeleccionadoIzq.add("");
		estadoSiguienteSeleccionadoDer.add("");
		estadosSiguientesIngresados.add("");

		// Agrega al campo hidden el nuevo estado
		setEstadosIngresados(LabelAndValueListHelper.add(getEstadosIngresados(), getEstado()));
		setEstado("");
	}

	public void agregarPropiedad() {
		setPropiedadesIngresadas(
			LabelAndValueListHelper.add(getPropiedadesIngresadas(), getPropiedad()));
		setPropiedad("");
	}

	public void quitarEstado() {
		// Borra la data de los arrays de propiedades del estado que se está borrando
		int index = LabelAndValueListHelper.indexOnLabelValueArray(getEstadosReales(), getEstadoSeleccionado());
		propiedadEstados.remove(index);
		propiedadesIngresadasEstados.remove(index);
		estadosSiguientesIngresados.remove(index);
		
		// Borra de los estados ingresados restantes el estado que se está borrando
		Iterator iter = estadosSiguientesIngresados.iterator();
		int i = 0;
		while (iter.hasNext()) {
			String estSiguientes = (String) iter.next();
			setEstadosSiguientesIngresados(i,
				LabelAndValueListHelper.remove(
					estSiguientes,
					getEstadoSeleccionado()));
			i++;
		} 

		// Saca del campo hidden el estado borrado
		setEstadosIngresados(
			LabelAndValueListHelper.remove(getEstadosIngresados(), getEstadoSeleccionado()));
	}

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

	public ArrayList getPropiedadesEstados(int index) {
		return LabelAndValueListHelper.parseBeansList(getPropiedadesIngresadasEstados(index), "<Debe agregar propiedades>");
	}

	public ArrayList getNombresPropiedadesEstados(int index) {
		return LabelAndValueListHelper.parseStringList(getPropiedadesIngresadasEstados(index));
	}

	public void agregarPropiedadEstados(int index) {
		setPropiedadesIngresadasEstados(index,
			LabelAndValueListHelper.add(getPropiedadesIngresadasEstados(index), getPropiedadEstados(index)));
		setPropiedadEstados(index, "");
	}

	public void quitarPropiedadEstados(int index) {
		setPropiedadesIngresadasEstados(index,
			LabelAndValueListHelper.remove(getPropiedadesIngresadasEstados(index), getPropiedadSeleccionadaEstados(index)));
	}

////////////////////////////

	public String getEstadoSiguienteSeleccionadoIzq(int index) { 
		try {
			return (String) estadoSiguienteSeleccionadoIzq.get(index); 
		} catch (IndexOutOfBoundsException e) {
			setEstadoSiguienteSeleccionadoIzq(index, "");
			return (String) estadoSiguienteSeleccionadoIzq.get(index); 
		}
	}
    
	public void setEstadoSiguienteSeleccionadoIzq(int index, String value) { 
		setIntoArrayList(estadoSiguienteSeleccionadoIzq, index, value);
	}

	public String getEstadoSiguienteSeleccionadoDer(int index) { 
		try {
			return (String) estadoSiguienteSeleccionadoDer.get(index); 
		} catch (IndexOutOfBoundsException e) {
			setEstadoSiguienteSeleccionadoDer(index, "");
			return (String) estadoSiguienteSeleccionadoDer.get(index); 
		}
	}
    
	public void setEstadoSiguienteSeleccionadoDer(int index, String value) { 
		setIntoArrayList(estadoSiguienteSeleccionadoDer, index, value);
	}

	public String getEstadosSiguientesIngresados(int index) { 
		return (String) estadosSiguientesIngresados.get(index); 
	}
    
	public void setEstadosSiguientesIngresados(int index, String value) { 
		setIntoArrayList(estadosSiguientesIngresados, index, value);
	}

	public ArrayList getEstadosSiguientes(int index) {
		return LabelAndValueListHelper.parseBeansList(getEstadosSiguientesIngresados(index), "<Debe agregar estados>");
	}

	public ArrayList getNombresEstadosSiguientes(int index) {
		return LabelAndValueListHelper.parseStringList(getEstadosSiguientesIngresados(index));
	}

	public void agregarEstadoSiguiente(int index) {
		setEstadosSiguientesIngresados(index,
			LabelAndValueListHelper.add(getEstadosSiguientesIngresados(index), getEstadoSiguienteSeleccionadoIzq(index)));
	}

	public void quitarEstadoSiguiente(int index) {
		setEstadosSiguientesIngresados(index,
			LabelAndValueListHelper.remove(getEstadosSiguientesIngresados(index), getEstadoSiguienteSeleccionadoDer(index)));
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
	 * @return
	 */
	public boolean isModificacion() {
		return modificacion;
	}

	/**
	 * @param b
	 */
	public void setModificacion(boolean b) {
		modificacion = b;
	}

	/**
	 * @return
	 */
	public String getNombreTipoModificado() {
		return nombreTipoModificado;
	}

	/**
	 * @param string
	 */
	public void setNombreTipoModificado(String string) {
		nombreTipoModificado = string;
	}

}
