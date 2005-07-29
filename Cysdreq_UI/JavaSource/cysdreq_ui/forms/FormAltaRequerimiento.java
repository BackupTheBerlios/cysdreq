/*
 * Created on 18/07/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cysdreq_ui.forms;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;

import com.cysdreq.loader.SessionManager;
import com.cysdreq.modelo.Cysdreq;
import com.cysdreq.modelo.Proyecto;
import com.cysdreq.modelo.req.TipoRequerimiento;
import com.cysdreq.util.LabelAndValueListHelper;
import com.cysdreq.util.PersistentArrayList;
import com.cysdreq.util.PersistentMap;

import cysdreq_ui.actions.LogonAction;
import cysdreq_ui.bean.GenericBean;
import cysdreq_ui.bean.UserBean;


/**
 * @author Daniel Nanni
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class FormAltaRequerimiento extends ActionForm {

	public static final String ACCION_SELECCIONAR_TIPO = "Seleccionar Tipo";
	public static final String ACCION_GUARDAR_REQUERIMIENTO = "Dar de alta el requerimiento";

	private String action = "";
	private ArrayList tiposRequerimientos = null;
	private String nombreTipoRequerimientoSeleccionado = null;
	private ArrayList propiedadesGenerales = new ArrayList();
	private ArrayList propiedadesEstado = new ArrayList();
 

	public void reset(ActionMapping mapping, HttpServletRequest request) {

		// Reset values are provided as samples only. Change as appropriate.

		nombreTipoRequerimientoSeleccionado ="";

		HttpSession session = request.getSession();
		
		try {
			// obtiene la transacción asociada al administrador de persistencia.
			SessionManager.beginTransaction();
			UserBean userBean = (UserBean) session.getAttribute(LogonAction.USER_KEY);

			Cysdreq cysdreq = Cysdreq.getPersistentInstance();
			Proyecto proyecto = cysdreq.getProyecto(userBean.getNombreProyecto());
										
			ArrayList tiposRequerimientosExistentes =  proyecto.getTiposRequerimientos();
			
			tiposRequerimientos = new ArrayList();
			
			Iterator iter = tiposRequerimientosExistentes.iterator();
			while (iter.hasNext()) {
				TipoRequerimiento tipoRequerimiento = (TipoRequerimiento) iter.next();
				
				tiposRequerimientos.add(new LabelValueBean(tipoRequerimiento.getNombre(), tipoRequerimiento.getNombre()));
			}
				
			SessionManager.commit();
		} catch (Throwable t) {
			SessionManager.rollback();
			t.printStackTrace();
			System.out.println("Error al recuperar los tipos de requerimientos del proyecto");
		}
	
	}

	public ActionErrors validate(
	ActionMapping mapping,
	HttpServletRequest request) {

	ActionErrors errors = new ActionErrors();
	// Validate the fields in your form, adding
	// adding each error to this.errors as found, e.g.

	return errors;

	}
	
	public TipoRequerimiento getTipoRequerimientoSeleccionado(Proyecto proyecto) {
		
		TipoRequerimiento tipoRequerimiento = proyecto.getTipoRequerimiento(getNombreTipoRequerimientoSeleccionado());
						
		return tipoRequerimiento;
		
	}
	
	public String getNombreTipoRequerimientoSeleccionado() {
		return nombreTipoRequerimientoSeleccionado;
	}

	/**
	 * @param string
	 */
	public void setNombreTipoRequerimientoSeleccionado(String string) {
		nombreTipoRequerimientoSeleccionado = string;
	}

	/**
	 * @return
	 */
	public ArrayList getTiposRequerimientos() {
		return tiposRequerimientos;
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

	/**
	 * @return
	 */
	public ArrayList getPropiedadesEstado() {
		return propiedadesEstado;
	}

	public PersistentMap getPropiedadesEstadoPersistentes() {
		PersistentMap propiedades = new PersistentMap(getPropiedadesEstado().size());

		Iterator iter = getPropiedadesEstado().iterator();
		while (iter.hasNext()) {
			LabelValueBean prop = (LabelValueBean) iter.next();
			propiedades.put(prop.getLabel(), prop.getValue());
		}

		return propiedades;
	}

	/**
	 * @return
	 */
	public ArrayList getPropiedadesGenerales() {
		return propiedadesGenerales;
	}

	public PersistentMap getPropiedadesGeneralesPersistentes() {
		PersistentMap propiedades = new PersistentMap(getPropiedadesGenerales().size());

		Iterator iter = getPropiedadesGenerales().iterator();
		while (iter.hasNext()) {
			LabelValueBean prop = (LabelValueBean) iter.next();
			propiedades.put(prop.getLabel(), prop.getValue());
		}

		return propiedades;
	}

	/**
	 * @param list
	 */
	public void setPropiedadesEstado(ArrayList list) {
		propiedadesEstado = list;
	}

	/**
	 * @param list
	 */
	public void setPropiedadesGenerales(ArrayList list) {
		propiedadesGenerales = list;
	}

}
