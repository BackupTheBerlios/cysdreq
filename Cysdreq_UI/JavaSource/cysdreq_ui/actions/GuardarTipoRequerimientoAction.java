/*
 * Created on 16/07/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cysdreq_ui.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cysdreq_ui.bean.GenericBean;
import cysdreq_ui.bean.UserBean;
import cysdreq_ui.forms.FormTipoRequerimiento;

/**
 * @author Nacirita
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class GuardarTipoRequerimientoAction extends Action {

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

			ActionErrors errors = new ActionErrors();
			ActionForward forward = new ActionForward();

			//String nombreProyecto  = (String) PropertyUtils.getSimpleProperty(form, "nombre");

			FormTipoRequerimiento formTipoRequerimiento = (FormTipoRequerimiento) form;
			
			String action = formTipoRequerimiento.getAction();
		
			if (action.equals("agregarEstado")) {
				HttpSession session = request.getSession();
				UserBean userBean = (UserBean) session.getAttribute(LogonAction.USER_KEY);

				GenericBean bean = new GenericBean(formTipoRequerimiento.getEstado());
//				formTipoRequerimiento.getEstados().add(bean);
				formTipoRequerimiento.setEstadosIngresados(formTipoRequerimiento.getEstadosIngresados()+"|"+formTipoRequerimiento.getEstado());
				formTipoRequerimiento.setEstado("");
				forward = mapping.findForward("error");
			} else if (action.equals("agregarPropiedad")) {
				
			}
/*		
			try	{
				//obtiene la transacción asociada al administrador de persistencia.
				SessionManager.beginTransaction();

				Cysdreq cysdreq = Cysdreq.getPersistentInstance();
			
				Proyecto proyecto = cysdreq.getProyecto(nombreProyecto);
						
				if (proyecto == null) {
					errors.add("name", new ActionError("errors.ingresarAProyecto.inexistente"));
				} else {
								
					HttpSession session = request.getSession();
					UserBean userBean = (UserBean) session.getAttribute(LogonAction.USER_KEY);
				
					userBean.setNombreProyecto(nombreProyecto);
				}
			
				SessionManager.commit();
			} catch (Throwable t) {
				SessionManager.rollback();
				t.printStackTrace();
				System.out.println("Error al recuperar el proyecto");
				// Report the error using the appropriate name and ID.
				errors.add("name", new ActionError("id"));

			}
*/
			// If a message is required, save the specified key(s)
			// into the request for use by the <struts:errors> tag.
/*
			if (!errors.isEmpty()) {
				saveErrors(request, errors);

				// Forward control to the appropriate 'failure' URI (change name as desired)
				forward = mapping.findForward("error");

			} else {

				// Forward control to the appropriate 'success' URI (change name as desired)
				forward = mapping.findForward("globalSuccess");

			}
*/
forward = mapping.findForward("error");
			// Finish with
			return (forward);
	}

}
