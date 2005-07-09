package cysdreq_ui.actions;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cysdreq.acciones.proyecto.AgregarMiembro;
import com.cysdreq.loader.SessionManager;
import com.cysdreq.modelo.Cysdreq;
import com.cysdreq.modelo.Proyecto;
import com.cysdreq.modelo.Usuario;
import com.cysdreq.util.PersistentArrayList;

import cysdreq_ui.bean.UserBean;
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

			HttpSession session = request.getSession();
			UserBean userBean = (UserBean) session.getAttribute(LogonAction.USER_KEY);

			// Agrega el miembro
			Cysdreq cysdreq = Cysdreq.getPersistentInstance();
			Proyecto proyecto = cysdreq.getProyecto(userBean.getNombreProyecto());
			Usuario usuario = cysdreq.getUsuario(formAgregarMiembro.getNombre());
					
			if (proyecto == null) {
				errors.add(	"usuario",	new ActionError("errors.miembro.proyectoInexistente"));

			} else if (usuario == null) {
				errors.add(	"usuario", new ActionError("errors.miembro.usuarioInexistente"));
			} else {

				HashMap params = new HashMap(2);
				params.put("usuario", usuario);
				params.put("roles", new PersistentArrayList());
				cysdreq.ejecutarAccion(new AgregarMiembro(), proyecto, params);


			}	
			
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
