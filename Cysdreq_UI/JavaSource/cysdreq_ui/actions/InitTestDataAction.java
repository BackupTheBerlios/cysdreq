package cysdreq_ui.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cysdreq.loader.Loader;
import com.cysdreq.loader.SessionManager;
import com.cysdreq.modelo.Cysdreq;

/**
 * @version 	1.0
 * @author
 */
public class InitTestDataAction extends Action {

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		ActionErrors errors = new ActionErrors();

		try	{
			//obtiene la transacción asociada al administrador de persistencia.
			SessionManager.beginTransaction();

			Cysdreq cysdreq = Cysdreq.getPersistentInstance();
			Loader.initTestData(cysdreq);

			SessionManager.commit();

		} catch (Throwable t) {
			t.printStackTrace();
			SessionManager.rollback();
			// Report the error using the appropriate name and ID.
			errors.add("sistema", new ActionError("errors.errorDesconocido"));
		}

		ActionForward forward = mapping.findForward("home");
		return (forward);
	}
}
