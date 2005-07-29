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
import com.cysdreq.modelo.Miembro;
import com.cysdreq.modelo.Proyecto;
import com.cysdreq.modelo.Usuario;
import com.cysdreq.modelo.flow.TipoEstado;
import com.cysdreq.modelo.req.Requerimiento;
import com.cysdreq.modelo.req.TipoRequerimiento;

import cysdreq_ui.actions.LogonAction;
import cysdreq_ui.bean.ListadoRequerimientosBean;
import cysdreq_ui.bean.ListadoUsuariosBean;
import cysdreq_ui.bean.UserBean;

/**
 * Form bean for a Struts application.
 * Users may access 4 fields on this form:
 * <ul>
 * <li>responsable - [your comment here]
 * <li>estado - [your comment here]
 * <li>nombreTipo - [your comment here]
 * <li>propietario - [your comment here]
 * </ul>
 * @version 	1.0
 * @author
 */
public class FormListadoRequerimientos extends ActionForm {

	private String action;
	
	private String responsable = null;
	private String nombreTipo = null;
	private String estado = null;
	private String propietario = null;
	private int idRequerimiento;
	
	private ArrayList requerimientosReales = new ArrayList();	
	private ArrayList tiposRequerimientos  = new ArrayList();
	private String nombreTipoRequerimientoSeleccionado = "";

	private ArrayList propietariosReales = new ArrayList();	
	private ArrayList propietarios  = new ArrayList();
	private String nombrePropietarioSeleccionado = "";

	private ArrayList tiposEstadosReales = new ArrayList();	
	private ArrayList tiposEstados  = new ArrayList();
	private String nombreTipoEstadoSeleccionado = "";	
	
	public ArrayList getRequerimientosReales() {
		return requerimientosReales;
	}

	/**
	 * @param list
	 */
	public void setRequerimientosReales(ArrayList list) {
		requerimientosReales = list;
	
	}
	/**
	 * Get responsable
	 * @return String
	 */
	public String getResponsable() {
		return responsable;
	}

	/**
	 * Set responsable
	 * @param <code>String</code>
	 */
	public void setResponsable(String r) {
		this.responsable = r;
	}

	/**
	 * Get nombreTipo
	 * @return String
	 */
	public String getNombreTipo() {
		return nombreTipo;
	}

	/**
	 * Set nombreTipo
	 * @param <code>String</code>
	 */
	public void setNombreTipo(String n) {
		this.nombreTipo = n;
	}

	/**
	 * Get estado
	 * @return String
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Set estado
	 * @param <code>String</code>
	 */
	public void setEstado(String e) {
		this.estado = e;
	}

	/**
	 * Get propietario
	 * @return String
	 */
	public String getPropietario() {
		return propietario;
	}

	/**
	 * Set propietario
	 * @param <code>String</code>
	 */
	public void setPropietario(String p) {
		this.propietario = p;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {

		// Reset values are provided as samples only. Change as appropriate.
		
/*		responsable = null;
		nombreTipo = null;
		estado = null;
		propietario = null;
*/
		HttpSession session = request.getSession();
		UserBean userBean = (UserBean) session.getAttribute(LogonAction.USER_KEY);

		try {
			// obtiene la transacción asociada al administrador de persistencia.
			SessionManager.beginTransaction();
	
			Cysdreq cysdreq = Cysdreq.getPersistentInstance();
			Proyecto proyecto = cysdreq.getProyecto(userBean.getNombreProyecto());	

			// arma el ArrayList de tipos de requuerimientos
			ArrayList tiposRequerimientosExistentes = proyecto.getTiposRequerimientos();
			tiposRequerimientos = new ArrayList();
			
			Iterator iter = tiposRequerimientosExistentes.iterator();
			
			while (iter.hasNext()) {
				TipoRequerimiento tipoRequerimiento = (TipoRequerimiento) iter.next();
				
				tiposRequerimientos.add(new LabelValueBean(tipoRequerimiento.getNombre(),tipoRequerimiento.getNombre()));
			}
							
			// arma el ArrayList de propietarios
			ArrayList propietariosExistentes = proyecto.getMiembros();
			propietarios = new ArrayList();
			
			iter = propietariosExistentes.iterator();
			
			while (iter.hasNext()) {
				Miembro miembro = (Miembro) iter.next();
				
				propietarios.add(new LabelValueBean(miembro.getUsuario().getNombre(),miembro.getUsuario().getNombre()));
			}

			// arma el ArrayList de tipos de estados
			ArrayList tiposEstadosExistentes = proyecto.getTiposDeEstados();
			tiposEstados = new ArrayList();
			
			iter = tiposEstadosExistentes.iterator();
			
			while (iter.hasNext()) {
				String nombreTipoEstado = (String) iter.next();
				
				tiposEstados.add(new LabelValueBean(nombreTipoEstado,nombreTipoEstado));
			}
									
			SessionManager.commit();
			
		} catch (Throwable t) {
			t.printStackTrace();
			SessionManager.rollback();
			System.out.println("Error al recuperar los requerimientos del proyecto");
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
	public String getNombreTipoRequerimientoSeleccionado() {
		return nombreTipoRequerimientoSeleccionado;
	}

	/**
	 * @return
	 */
	public ArrayList getTiposRequerimientos() {
		return tiposRequerimientos;
	}

	/**
	 * @param string
	 */
	public void setNombreTipoRequerimientoSeleccionado(String string) {
		nombreTipoRequerimientoSeleccionado = string;
	}

	/**
	 * @param list
	 */
	public void setTiposRequerimientos(ArrayList list) {
		tiposRequerimientos = list;
	}

	/**
	 * @return
	 */
	public ArrayList getTiposEstados() {
		return tiposEstados;
	}

	/**
	 * @return
	 */
	public ArrayList getTiposEstadosReales() {
		return tiposEstadosReales;
	}

	/**
	 * @return
	 */
	public String getNombreTipoEstadoSeleccionado() {
		return nombreTipoEstadoSeleccionado;
	}

	/**
	 * @return
	 */
	public String getNombrePropietarioSeleccionado() {
		return nombrePropietarioSeleccionado;
	}

	/**
	 * @return
	 */
	public ArrayList getPropietarios() {
		return propietarios;
	}

	/**
	 * @return
	 */
	public ArrayList getPropietariosReales() {
		return propietariosReales;
	}

	/**
	 * @param list
	 */
	public void setTiposEstados(ArrayList list) {
		tiposEstados = list;
	}

	/**
	 * @param list
	 */
	public void setTiposEstadosReales(ArrayList list) {
		tiposEstadosReales = list;
	}

	/**
	 * @param string
	 */
	public void setNombreTipoEstadoSeleccionado(String string) {
		nombreTipoEstadoSeleccionado = string;
	}

	/**
	 * @param string
	 */
	public void setNombrePropietarioSeleccionado(String string) {
		nombrePropietarioSeleccionado = string;
	}

	/**
	 * @param list
	 */
	public void setPropietarios(ArrayList list) {
		propietarios = list;
	}

	/**
	 * @param list
	 */
	public void setPropietariosReales(ArrayList list) {
		propietariosReales = list;
	}

	/**
	 * @return
	 */
	public int getIdRequerimiento() {
		return idRequerimiento;
	}

	/**
	 * @param i
	 */
	public void setIdRequerimiento(int i) {
		idRequerimiento = i;
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
