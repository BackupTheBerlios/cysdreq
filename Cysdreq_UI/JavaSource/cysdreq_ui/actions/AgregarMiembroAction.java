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

import com.cysdreq.acciones.proyecto.AgregarMiembro;
import com.cysdreq.loader.SessionManager;
import com.cysdreq.modelo.Cysdreq;

import cysdreq_ui.forms.FormAgregarMiembro;

/**
 * @version 	1.0
 * @author
 */
public class AgregarMiembroAction extends Action {

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		// return value
		FormAgregarMiembro formAgregarMiembro = (FormAgregarMiembro) form;

		try {
			SessionManager.beginTransaction();

			// Agrega el miembro
			Cysdreq cysdreq = Cysdreq.getPersistentInstance();
			HashMap params = new HashMap(2);
			params.put("usuario", formAgregarMiembro.getNombre());
			params.put("roles", new ArrayList());
			cysdreq.ejecutarAccion(new AgregarMiembro(), cysdreq, params);
			
			SessionManager.commit();			

		} catch (Throwable e) {
			e.printStackTrace();
			SessionManager.rollback();
			errors.add("usuario", new ActionError("errors.registrarMiembro"));
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else
			forward = mapping.findForward("globalSuccess");
		
		return (forward);

	}
}
