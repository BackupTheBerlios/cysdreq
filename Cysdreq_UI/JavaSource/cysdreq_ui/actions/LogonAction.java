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
import com.cysdreq.modelo.Usuario;
import com.poet.jdo.PersistenceManagers;

import cysdreq_ui.bean.UserBean;

/**
 * @version 	1.0
 * @author
 */
public class LogonAction extends Action {

	private static final String USER_KEY = "user";

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		// return value
		String username  = (String) PropertyUtils.getSimpleProperty(form, "usuario");
		String password = (String) PropertyUtils.getSimpleProperty(form, "password");
		
		try	{
			//obtiene la transacción asociada al administrador de persistencia.
			SessionManager.beginTransaction();

			Cysdreq cysdreq = (Cysdreq) PersistenceManagers.findObject(SessionManager.getSession(), SessionManager.ROOT_OBJECT_ID);
			System.out.println("Cysdreq obtenido");

			Usuario usuario = cysdreq.getUsuario(username, password);
			if (usuario == null) {
				System.out.println("NO SE ENCONTRO EL USUARIO");
				errors.add("name", new ActionError("id"));
			} else {
				System.out.println("SE ENCONTRO EL USUARIO");
				
				UserBean userBean = new UserBean();
				userBean.setLongUsername(usuario.getNombre());
				userBean.setUsername(usuario.getUsuario());
				userBean.setPassword(usuario.getPassword());
				
				// Save our logged-in user in the session
				HttpSession session = request.getSession();
				session.setAttribute(USER_KEY, userBean);
			}
			
			SessionManager.commit();
		} catch (Throwable t) {
			SessionManager.rollback();
			t.printStackTrace();
			System.out.println("Error al recuperar el usuario");
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
			forward = mapping.findForward("success");

		}

		// Finish with
		return (forward);

	}
}
