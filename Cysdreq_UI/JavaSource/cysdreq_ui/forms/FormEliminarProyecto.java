package cysdreq_ui.forms;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.cysdreq.loader.SessionManager;
import com.cysdreq.modelo.Cysdreq;
import com.cysdreq.modelo.Proyecto;

import cysdreq_ui.bean.ProyectoBean;

/**
 * Form bean for a Struts application.
 * Users may access 1 field on this form:
 * <ul>
 * <li>nombreProyectoSeleccionado - [your comment here]
 * </ul>
 * @version 	1.0
 * @author
 */
public class FormEliminarProyecto extends ActionForm {

	private ArrayList proyectos = null;
	private String nombreProyectoSeleccionado = null; 	

	public Proyecto getProyectoSeleccionado() {
	
		Cysdreq cysdreq = Cysdreq.getPersistentInstance();
		Proyecto proyecto = cysdreq.getProyecto(getNombreProyectoSeleccionado());
						
		return proyecto;
		
	}
	
	public String getNombreProyectoSeleccionado() {
		return nombreProyectoSeleccionado;
	}

	/**
	 * @param string
	 */
	public void setNombreProyectoSeleccionado(String string) {
		nombreProyectoSeleccionado = string;
	}

	/**
	 * @return
	 */
	public ArrayList getProyectos() {
		return proyectos;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {

		// Reset values are provided as samples only. Change as appropriate.

		nombreProyectoSeleccionado ="";
		 
		HttpSession session = request.getSession();
		
		try {
			// obtiene la transacción asociada al administrador de persistencia.
			SessionManager.beginTransaction();
	
			Cysdreq cysdreq = Cysdreq.getPersistentInstance();
					
			ArrayList proyectosExistentes =  cysdreq.getProyectos();
			proyectos = new ArrayList();
			
			Iterator iter = proyectosExistentes.iterator();
			while (iter.hasNext()) {
				Proyecto proyecto = (Proyecto) iter.next();
				
				proyectos.add(new ProyectoBean(proyecto));
			}
				
			SessionManager.commit();
		} catch (Throwable t) {
			SessionManager.rollback();
			t.printStackTrace();
			System.out.println("Error al recuperar los proyectos del sistema");
		}
	
	}
	public ActionErrors validate(
		ActionMapping mapping,
		HttpServletRequest request) {

			ActionErrors errors = new ActionErrors();
			// Validate the fields in your form, adding
			// adding each error to this.errors as found, e.g.

			if ((nombreProyectoSeleccionado == null) || (nombreProyectoSeleccionado.length() == 0)) {
				errors.add("nombre", new ActionError("errors.ingresarAProyecto.nombreVacio"));
			}
			return errors;

			}
}
