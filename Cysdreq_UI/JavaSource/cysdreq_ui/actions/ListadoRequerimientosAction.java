package cysdreq_ui.actions;

import java.util.ArrayList;
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

import com.cysdreq.loader.SessionManager;
import com.cysdreq.modelo.Cysdreq;
import com.cysdreq.modelo.Miembro;
import com.cysdreq.modelo.Proyecto;
import com.cysdreq.modelo.flow.TipoEstado;
import com.cysdreq.modelo.req.Requerimiento;
import com.cysdreq.modelo.req.TipoRequerimiento;

import cysdreq_ui.bean.ListadoRequerimientosBean;
import cysdreq_ui.bean.UserBean;
import cysdreq_ui.forms.FormListadoRequerimientos;

/**
 * @version 	1.0
 * @author
 */
public class ListadoRequerimientosAction extends Action {

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		// return value
		FormListadoRequerimientos formListadoRequerimientos =
			(FormListadoRequerimientos) form;

		HttpSession session = request.getSession();
		UserBean userBean = (UserBean) session.getAttribute(LogonAction.USER_KEY);

		try {
			// obtiene la transacción asociada al administrador de persistencia.
			SessionManager.beginTransaction();

			Cysdreq cysdreq = Cysdreq.getPersistentInstance();
			Proyecto proyecto = cysdreq.getProyecto(userBean.getNombreProyecto());	
		
	
			// arma el ArrayList de requerimientos
			ArrayList requerimientosExistentes = proyecto.getRequerimientos();
			formListadoRequerimientos.setRequerimientosReales(new ArrayList());
		
			Iterator iterator = requerimientosExistentes.iterator();
			while (iterator.hasNext()) {
				Requerimiento requerimiento = (Requerimiento) iterator.next();
			
				//String nombreTipoReq = requerimiento.getTipo().getNombre();
				String nombreEstadoAct = requerimiento.getEstadoActual().getTipo().getNombre();
				String nombrePropietario = requerimiento.getPropietario().getUsuario().getNombre();
				String nombreResponsable = requerimiento.getEstadoActual().getResponsable().getUsuario().getNombre();

				boolean incluir = true;
				
				if (!formListadoRequerimientos.getNombrePropietarioSeleccionado().equals("") && incluir) {
					
					if (!formListadoRequerimientos.getNombrePropietarioSeleccionado().equals(nombrePropietario)){
						incluir = false;
					}
				}

				if (!formListadoRequerimientos.getNombreTipoRequerimientoSeleccionado().equals("") && incluir) {
					
					//if (!formListadoRequerimientos.getNombreTipoRequerimientoSeleccionado().equals(nombreTipoReq)){
					if (!formListadoRequerimientos.getNombreTipoRequerimientoSeleccionado().equals("Primer tipo de prueba")){
						incluir = false;
					}
				}

				if (!formListadoRequerimientos.getNombreTipoEstadoSeleccionado().equals("") && incluir) {
					
					if (!formListadoRequerimientos.getNombreTipoEstadoSeleccionado().equals(nombreEstadoAct)){
						incluir = false;
					}
				}
				
				if (incluir) {
					formListadoRequerimientos.getRequerimientosReales().add(new ListadoRequerimientosBean("nombreTipoReq", nombreEstadoAct, nombrePropietario, nombreResponsable));
				}
			}			
			

			// arma el ArrayList de usuarios
			ArrayList tiposRequerimientosExistentes = proyecto.getTiposRequerimientos();
			formListadoRequerimientos.setTiposRequerimientos(new ArrayList());
		
			Iterator iter = tiposRequerimientosExistentes.iterator();
		
			while (iter.hasNext()) {
				TipoRequerimiento tipoRequerimiento = (TipoRequerimiento) iter.next();
			
				formListadoRequerimientos.getTiposRequerimientos().add(new LabelValueBean(tipoRequerimiento.getNombre(),tipoRequerimiento.getNombre()));
			}
						
			// arma el ArrayList de propietarios
			ArrayList propietariosExistentes = proyecto.getMiembros();
			formListadoRequerimientos.setPropietarios(new ArrayList());
		
			iter = propietariosExistentes.iterator();
		
			while (iter.hasNext()) {
				Miembro miembro = (Miembro) iter.next();
			
				formListadoRequerimientos.getPropietarios().add(new LabelValueBean(miembro.getUsuario().getNombre(),miembro.getUsuario().getNombre()));
			}

			// arma el ArrayList de tipos de estados
			ArrayList tiposDeEstadosExistentes = proyecto.getTiposDeEstados();
			formListadoRequerimientos.setTiposEstados(new ArrayList());
		
			iter = tiposDeEstadosExistentes.iterator();
		
			while (iter.hasNext()) {
				TipoEstado tipoEstado = (TipoEstado) iter.next();
			
				formListadoRequerimientos.getTiposEstados().add(new LabelValueBean(tipoEstado.getNombre(),tipoEstado.getNombre()));
			}
								
			SessionManager.commit();
		
		} catch (Throwable t) {
			t.printStackTrace();
			SessionManager.rollback();
			errors.add("name", new ActionError("id"));
		}

		// If a message is required, save the specified key(s)
		// into the request for use by the <struts:errors> tag.

		if (!errors.isEmpty()) {
			saveErrors(request, errors);

			// Forward control to the appropriate 'failure' URI (change name as desired)
			forward = mapping.findForward("error");
		} else {
			// Forward control to the appropriate 'success' URI (change name as desired)
			// forward = mapping.findForward("success");
		}
		
		forward = mapping.findForward("error");
		
		// Finish with
		return (forward);

	}
}
