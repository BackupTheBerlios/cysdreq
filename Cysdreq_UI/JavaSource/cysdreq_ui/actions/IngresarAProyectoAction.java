package cysdreq_ui.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cysdreq.loader.SessionManager;
import com.cysdreq.modelo.Cysdreq;
import com.cysdreq.modelo.Proyecto;

import cysdreq_ui.bean.UserBean;
import cysdreq_ui.forms.FormIngresarAProyecto;

/**
 * @version 	1.0
 * @author
 */
public class IngresarAProyectoAction extends Action {

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		FormIngresarAProyecto formIngresar = (FormIngresarAProyecto) form;
		
		try	{
			//obtiene la transacción asociada al administrador de persistencia.
			SessionManager.beginTransaction();

			Cysdreq cysdreq = Cysdreq.getPersistentInstance();
			
			//Proyecto proyecto = cysdreq.getProyecto(nombreProyecto);
			Proyecto proyecto = formIngresar.getProyectoSeleccionado(); 
						
			if (proyecto == null) {
				errors.add("name", new ActionError("errors.ingresarAProyecto.inexistente"));
			} else {
								
				HttpSession session = request.getSession();
				UserBean userBean = (UserBean) session.getAttribute(LogonAction.USER_KEY);
				
				userBean.setNombreProyecto(proyecto.getNombre());
			}
			
			SessionManager.commit();
		} catch (Throwable t) {
			SessionManager.rollback();
			t.printStackTrace();
			System.out.println("Error al recuperar el proyecto");
			// Report the error using the appropriate name and ID.
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
			forward = mapping.findForward("globalSuccess");

		}

		// Finish with
		return (forward);

	}
}