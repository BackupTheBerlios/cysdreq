package cysdreq_ui.actions;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cysdreq.acciones.sistema.AgregarRolSistema;
import com.cysdreq.loader.SessionManager;
import com.cysdreq.modelo.Cysdreq;

import cysdreq_ui.forms.FormAgregarRolSistema;

/**
 * @version 	1.0
 * @author
 */
public class AgregarRolSistemaAction extends Action {

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		// return value
		FormAgregarRolSistema formAgregarRolSistema = (FormAgregarRolSistema) form;

		try {
			SessionManager.beginTransaction();

			// Agrega el usuario
			Cysdreq cysdreq = Cysdreq.getPersistentInstance();
			HashMap params = new HashMap(2);
			params.put("nombreRol", formAgregarRolSistema.getNombre());
			params.put("tiposDeAcciones", new ArrayList());
			cysdreq.ejecutarAccion(AgregarRolSistema.getInstance(), cysdreq, params);
		
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
