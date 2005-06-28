package cysdreq_ui.actions;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cysdreq.acciones.sistema.AgregarUsuario;
import com.cysdreq.loader.SessionManager;
import com.cysdreq.modelo.Cysdreq;
import com.cysdreq.modelo.Usuario;

import cysdreq_ui.forms.FormAgregarUsuario;

/**
 * @version 	1.0
 * @author
 */
public class AgregarUsuarioAction extends Action {

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();

		// return value
		FormAgregarUsuario formAgregarUsuario = (FormAgregarUsuario) form;

		try {
			SessionManager.beginTransaction();

			// Agrega el usuario
			Cysdreq cysdreq = Cysdreq.getPersistentInstance();
			HashMap params = new HashMap(3);
			params.put("nombreUsuario", formAgregarUsuario.getNombre());
			params.put("usuario", formAgregarUsuario.getUsuario());
			params.put("password", formAgregarUsuario.getPassword());
			cysdreq.ejecutarAccion(AgregarUsuario.getInstance(), cysdreq, params);

			SessionManager.commit();			

		} catch (Throwable e) {
			e.printStackTrace();
			SessionManager.rollback();
			errors.add("usuario", new ActionError("errors.registrarUsuario"));
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else
			forward = mapping.findForward("globalSuccess");
		
		return (forward);

	}
}
