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

import com.cysdreq.acciones.sistema.AgregarProyecto;
import com.cysdreq.acciones.sistema.EliminarProyecto;
import com.cysdreq.loader.SessionManager;
import com.cysdreq.modelo.Cysdreq;

import cysdreq_ui.forms.FormEliminarProyecto;

/**
 * @version 	1.0
 * @author
 */
public class EliminarProyectoAction extends Action {

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		// return value
		FormEliminarProyecto formEliminarProyecto = (FormEliminarProyecto) form;

		try {
			SessionManager.beginTransaction();
			Cysdreq cysdreq = Cysdreq.getPersistentInstance();
			
			HashMap params = new HashMap(1);
			String nombreProyecto = formEliminarProyecto.getNombreProyectoSeleccionado();			
			params.put("proyecto", cysdreq.getProyecto(nombreProyecto));
			cysdreq.ejecutarAccion(new EliminarProyecto(), cysdreq, params);
			
			SessionManager.commit();			
		} catch (Exception e) {
			e.printStackTrace();
			SessionManager.rollback();
			errors.add("proyecto", new ActionError("errors.eliminarProyecto"));
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else
			forward = mapping.findForward("globalSuccess");
		
		return (forward);

	}
}