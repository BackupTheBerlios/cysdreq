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

import cysdreq_ui.actions.LogonAction;
import cysdreq_ui.bean.UserBean;

/**
 * Form bean for a Struts application.
 * Users may access 1 field on this form:
 * <ul>
 * <li>nombreTipoSeleccionado - [your comment here]
 * </ul>
 * @version 	1.0
 * @author
 */
public class FormTiposDeRequerimientos extends ActionForm {

	public static final String ACCION_MODIFICAR = "Modificar";
	public static final String ACCION_ELIMINAR = "Eliminar";

	private String action = "";
	private String nombreTipoSeleccionado = null;
	private ArrayList tiposDeRequerimientos = null;

	/**
	 * Get nombreTipoSeleccionado
	 * @return String
	 */
	public String getNombreTipoSeleccionado() {
		return nombreTipoSeleccionado;
	}

	/**
	 * Set nombreTipoSeleccionado
	 * @param <code>String</code>
	 */
	public void setNombreTipoSeleccionado(String n) {
		this.nombreTipoSeleccionado = n;
	}

	public ActionErrors validate(
		ActionMapping mapping,
		HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		// Validate the fields in your form, adding
		// adding each error to this.errors as found, e.g.

		if ((getNombreTipoSeleccionado() == null) || (getNombreTipoSeleccionado().length() == 0)) {
			errors.add("tipoDeRequerimientos", new org.apache.struts.action.ActionError("errors.tipoRequerimiento.seleccionVacia"));
		}
		return errors;

	}

	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);

		nombreTipoSeleccionado = null;

		if (getTiposDeRequerimientos() == null) {
			HttpSession session = request.getSession();
			UserBean userBean = (UserBean) session.getAttribute(LogonAction.USER_KEY);
	
			try {
				// obtiene la transacción asociada al administrador de persistencia.
				SessionManager.beginTransaction();
		
				Cysdreq cysdreq = Cysdreq.getPersistentInstance();
				Proyecto proyecto = cysdreq.getProyecto(userBean.getNombreProyecto());
						
				// arma el ArrayList de roles
				ArrayList tipos = new ArrayList();
				
				Iterator iter = proyecto.getTiposRequerimientos().iterator();
				while (iter.hasNext()) {
					TipoRequerimiento tipo = (TipoRequerimiento) iter.next();
					
					tipos.add(new LabelValueBean(tipo.getNombre(), tipo.getNombre()));
				}
				
				SessionManager.commit();
				
				setTiposDeRequerimientos(tipos);
				
			} catch (Throwable t) {
				t.printStackTrace();
				SessionManager.rollback();
				System.out.println("Error al recuperar los roles del proyecto");
			}
		}

	}

	/**
	 * @return
	 */
	public ArrayList getTiposDeRequerimientos() {
		return tiposDeRequerimientos;
	}

	/**
	 * @param string
	 */
	public void setTiposDeRequerimientos(ArrayList list) {
		tiposDeRequerimientos = list;
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
