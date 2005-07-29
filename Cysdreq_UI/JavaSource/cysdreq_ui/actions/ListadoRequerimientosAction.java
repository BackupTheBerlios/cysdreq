package cysdreq_ui.actions;

import java.util.ArrayList;
import java.util.Collection;
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

import com.cysdreq.loader.SessionManager;
import com.cysdreq.modelo.Cysdreq;
import com.cysdreq.modelo.Miembro;
import com.cysdreq.modelo.Proyecto;
import com.cysdreq.modelo.flow.Transicion;
import com.cysdreq.modelo.req.Propiedad;
import com.cysdreq.modelo.req.Requerimiento;
import com.cysdreq.modelo.req.TipoRequerimiento;

import cysdreq_ui.bean.ListadoRequerimientosBean;
import cysdreq_ui.bean.UserBean;
import cysdreq_ui.forms.FormDetallesRequerimiento;
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

		String action = formListadoRequerimientos.getAction();

		// Modificación de un tipo de requerimiento
		if (action == null || action.equals("Buscar")) {

			try {
				// obtiene la transacción asociada al administrador de persistencia.
				SessionManager.beginTransaction();
	
				Cysdreq cysdreq = Cysdreq.getPersistentInstance();
				Proyecto proyecto = cysdreq.getProyecto(userBean.getNombreProyecto());	
			
		
				// arma el ArrayList de requerimientos
				Collection requerimientosExistentes = proyecto.getRequerimientos().values();
				formListadoRequerimientos.setRequerimientosReales(new ArrayList());
			
				Iterator iterator = requerimientosExistentes.iterator();
				while (iterator.hasNext()) {
					Requerimiento requerimiento = (Requerimiento) iterator.next();
				
					int idRequerimiento = requerimiento.getId();
					String nombreTipoReq = requerimiento.getTipo().getNombre();
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
						
						if (!formListadoRequerimientos.getNombreTipoRequerimientoSeleccionado().equals(nombreTipoReq)){
							incluir = false;
						}
					}
	
					if (!formListadoRequerimientos.getNombreTipoEstadoSeleccionado().equals("") && incluir) {
						
						if (!formListadoRequerimientos.getNombreTipoEstadoSeleccionado().equals(nombreEstadoAct)){
							incluir = false;
						}
					}
					
					if (incluir) {
						formListadoRequerimientos.getRequerimientosReales().add(new ListadoRequerimientosBean(idRequerimiento,nombreTipoReq, nombreEstadoAct, nombrePropietario, nombreResponsable));
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
					String nombreTipoEstado = (String) iter.next();
				
					formListadoRequerimientos.getTiposEstados().add(new LabelValueBean(nombreTipoEstado,nombreTipoEstado));
				}
									
				SessionManager.commit();
			
			} catch (Throwable t) {
				t.printStackTrace();
				SessionManager.rollback();
				errors.add("requerimiento", new ActionError("errors.listadoRequerimientos.recuperarRequerimientos"));
			}

			forward = mapping.findForward("error");

		} else {
			try {
				// obtiene la transacción asociada al administrador de persistencia.
				SessionManager.beginTransaction();
	
				Cysdreq cysdreq = Cysdreq.getPersistentInstance();
				Proyecto proyecto = cysdreq.getProyecto(userBean.getNombreProyecto());	
			
				Requerimiento req = proyecto.getRequerimiento(Integer.parseInt(action));

				FormDetallesRequerimiento nextForm = new FormDetallesRequerimiento();
				nextForm.setReqId(action);
				nextForm.setEstado(req.getEstadoActual().getTipo().getNombre());
				nextForm.setNombreTipo(req.getTipo().getNombre());
				nextForm.setPropietario(req.getPropietario().getUsuario().getNombre());
				nextForm.setResponsable(req.getEstadoActual().getResponsable().getUsuario().getNombre());

				// Propiedades generales
				ArrayList propiedades = new ArrayList(req.getPropiedades().size());
				Iterator iter = req.getPropiedades().iterator();
				while (iter.hasNext()) {
					Propiedad propiedad = (Propiedad) iter.next();
					propiedades.add(new LabelValueBean(propiedad.getTipo().getNombre(), propiedad.getValor()));
				}
				nextForm.setPropiedadesGenerales(propiedades);

				// Propiedades del estado actual
				ArrayList propiedadesEstado = new ArrayList(req.getEstadoActual().getPropiedades().size());
				iter = req.getEstadoActual().getPropiedades().iterator();
				while (iter.hasNext()) {
					Propiedad propiedad = (Propiedad) iter.next();
					propiedadesEstado.add(new LabelValueBean(propiedad.getTipo().getNombre(), propiedad.getValor()));
				}
				nextForm.setPropiedadesEstado(propiedadesEstado);

				// Transiciones
				ArrayList siguientes = new ArrayList(req.getEstadoActual().getTipo().getTransiciones().size());
				iter = req.getEstadoActual().getTipo().getTransiciones().iterator();
				while (iter.hasNext()) {
					Transicion transision = (Transicion) iter.next();
					String nombre = transision.getTipoEstadoDestino().getNombre();
					siguientes.add(new LabelValueBean(nombre, nombre));
				}
				nextForm.setEstadosSiguientes(siguientes);

				// Le asigna al form de la página siguiente el form que se armó
				request.setAttribute("formDetallesRequerimiento", nextForm);

				forward = mapping.findForward("success");

				SessionManager.commit();
			
			} catch (Throwable t) {
				t.printStackTrace();
				SessionManager.rollback();
				errors.add("requerimiento", new ActionError("errors.listadoRequerimientos.recuperarRequerimientos"));
			}

		}

		// If a message is required, save the specified key(s)
		// into the request for use by the <struts:errors> tag.

		if (!errors.isEmpty()) {
			saveErrors(request, errors);

			// Forward control to the appropriate 'failure' URI (change name as desired)
			forward = mapping.findForward("error");
		}
		
		// Finish with
		return (forward);
	}

}