package cysdreq_ui.actions;

import java.util.HashMap;



import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cysdreq_ui.forms.FormAgregarRolProyecto;
import com.cysdreq.util.PersistentArrayList;
import com.cysdreq.loader.SessionManager;
import com.cysdreq.modelo.Cysdreq;
import com.cysdreq.acciones.proyecto.AgregarRolProyecto;
import com.cysdreq.modelo.Proyecto;
import cysdreq_ui.bean.UserBean;

/**
 * @version 	1.0
 * @author
 */
public class AgregarRolProyectoAction extends Action {

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		// return value
		FormAgregarRolProyecto formAgregarRolProyecto = (FormAgregarRolProyecto) form;

		try {
			SessionManager.beginTransaction();

			HttpSession session = request.getSession();
			UserBean userBean = (UserBean) session.getAttribute(LogonAction.USER_KEY);
			
			String nombre = formAgregarRolProyecto.getNombre();
			
			PersistentArrayList acciones = formAgregarRolProyecto.getAccionesPersistentesSeleccionadas();

			// Agrega el usuario
			Cysdreq cysdreq = Cysdreq.getPersistentInstance();
			Proyecto proyecto = cysdreq.getProyecto(userBean.getNombreProyecto());
			HashMap params = new HashMap(2);
			params.put("nombreRol", nombre);
			params.put("tiposDeAcciones", acciones);
			cysdreq.ejecutarAccion(new AgregarRolProyecto(), proyecto, params);
		
			SessionManager.commit();			

		} catch (Throwable e) {
			e.printStackTrace();
			SessionManager.rollback();
			errors.add("rolSistema", new ActionError("errors.registrarRolSistema"));
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else
			forward = mapping.findForward("globalSuccess");
	
		return (forward);

	}
}
