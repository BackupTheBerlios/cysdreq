/*
 * Created on 18/07/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
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

import com.cysdreq.acciones.proyecto.AgregarRequerimiento;
import com.cysdreq.loader.SessionManager;
import com.cysdreq.modelo.Cysdreq;
import com.cysdreq.modelo.Proyecto;
import com.cysdreq.modelo.Usuario;

import cysdreq_ui.bean.UserBean;
import cysdreq_ui.forms.FormAltaRequerimiento;



/**
 * @author Daniel Nanni
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AltaRequerimientoAction extends Action {
	
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		// return value
		FormAltaRequerimiento formAltaRequerimiento = (FormAltaRequerimiento) form;

		try {
			SessionManager.beginTransaction();

			HttpSession session = request.getSession();
			UserBean userBean = (UserBean) session.getAttribute(LogonAction.USER_KEY);
						
			Cysdreq cysdreq = Cysdreq.getPersistentInstance();
			Proyecto proyecto = cysdreq.getProyecto(userBean.getNombreProyecto());
			Usuario usuario = cysdreq.getUsuario(userBean.getUsername());
			
			if (proyecto == null) {
				errors.add(	"usuario",	new ActionError("errors.miembro.proyectoInexistente"));

			} else if (usuario == null) {
				errors.add(	"usuario", new ActionError("errors.miembro.usuarioInexistente"));
			
			} else if( proyecto.getMiembro(usuario) == null){
				errors.add(	"usuario", new ActionError("errors.miembro.miembroInexistente"));
			} else {							
			
				HashMap params = new HashMap(3);
				params.put("tipoRequerimiento", formAltaRequerimiento.getTipoRequerimientoSeleccionado(proyecto));
				params.put("propietario", proyecto.getMiembro(usuario));
				params.put("responsable", proyecto.getMiembro(usuario));
				cysdreq.ejecutarAccion(new AgregarRequerimiento(), proyecto, params);
			}
			
				SessionManager.commit();			

		} catch (Throwable e) {
			e.printStackTrace();
			SessionManager.rollback();
			errors.add("requerimiento", new ActionError("errors.altaRequerimiento"));
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward("error");
		} else
			forward = mapping.findForward("globalSuccess");
	
		return (forward);

	}
}



	