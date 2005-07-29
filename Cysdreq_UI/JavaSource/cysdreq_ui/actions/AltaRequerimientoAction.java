/*
 * Created on 18/07/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cysdreq_ui.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;

import com.cysdreq.acciones.proyecto.AgregarRequerimiento;
import com.cysdreq.loader.SessionManager;
import com.cysdreq.modelo.Cysdreq;
import com.cysdreq.modelo.Proyecto;
import com.cysdreq.modelo.Usuario;
import com.cysdreq.modelo.req.TipoPropiedad;
import com.cysdreq.modelo.req.TipoRequerimiento;
import com.cysdreq.util.PersistentArrayList;
import com.cysdreq.util.PersistentMap;

import cysdreq_ui.bean.UserBean;
import cysdreq_ui.forms.FormAltaRequerimiento;



/**
 * @author Daniel Nanni
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AltaRequerimientoAction extends Action {
	
	public AltaRequerimientoAction() {
		super();
	}

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		// return value
		FormAltaRequerimiento formAltaRequerimiento = (FormAltaRequerimiento) form;

		String action = formAltaRequerimiento.getAction();

		try {
			SessionManager.beginTransaction();
	
			HttpSession session = request.getSession();
			UserBean userBean = (UserBean) session.getAttribute(LogonAction.USER_KEY);
							
			Cysdreq cysdreq = Cysdreq.getPersistentInstance();
			Proyecto proyecto = cysdreq.getProyecto(userBean.getNombreProyecto());

			// Selección de tipo de requerimiento
			if        (action.equals(FormAltaRequerimiento.ACCION_SELECCIONAR_TIPO)) {
				// el default es continuar con la misma página
				forward = mapping.findForward("continue");
	
				String nombreTipo = formAltaRequerimiento.getNombreTipoRequerimientoSeleccionado();
	
				if (nombreTipo == null) {
					errors.add(	"requerimiento", new ActionError("errors.requerimiento.tipoNoSeleccionado"));
				} else {
					session.setAttribute("nombreTipoReqSelHidden", nombreTipo);
					formAltaRequerimiento.setNombreTipoReqSelHidden(nombreTipo);
				}

			} else if (action.equals(FormAltaRequerimiento.ACCION_GUARDAR_REQUERIMIENTO)) {
	
				Usuario usuario = cysdreq.getUsuario(userBean.getUsername());
				
				if (proyecto == null) {
					errors.add(	"usuario",	new ActionError("errors.requerimiento.proyectoInexistente"));
	
				} else if (usuario == null) {
					errors.add(	"usuario", new ActionError("errors.requerimiento.usuarioInexistente"));
				
				} else if( proyecto.getMiembro(usuario) == null){
					errors.add(	"usuario", new ActionError("errors.requerimiento.miembroInexistente"));
				} else {							
				
					HashMap params = new HashMap(5);
					params.put("tipoRequerimiento", formAltaRequerimiento.getTipoRequerimientoSeleccionado(proyecto));
					params.put("propietario", proyecto.getMiembro(usuario));
					params.put("responsable", proyecto.getMiembro(usuario));
					params.put("propiedadesGenerales", formAltaRequerimiento.getPropiedadesGeneralesPersistentes());
					params.put("propiedadesEstado", formAltaRequerimiento.getPropiedadesEstadoPersistentes());
					cysdreq.ejecutarAccion(new AgregarRequerimiento(), proyecto, params);
				}
				
				forward = mapping.findForward("globalSuccess");
			}

			SessionManager.commit();			
		} catch (Throwable e) {
			e.printStackTrace();
			SessionManager.rollback();
			errors.add("requerimiento", new ActionError("errors.altaRequerimiento"));
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		}
	
		return (forward);

	}
}



	