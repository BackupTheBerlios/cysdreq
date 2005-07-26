/*
 * Created on 16/07/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cysdreq_ui.actions;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;

import com.cysdreq.util.LabelAndValueListHelper;

import cysdreq_ui.forms.FormTipoRequerimiento;

/**
 * @author Nacirita
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class GuardarTipoRequerimientoAction extends Action {

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

			ActionErrors errors = new ActionErrors();
			ActionForward forward = new ActionForward();

			//String nombreProyecto  = (String) PropertyUtils.getSimpleProperty(form, "nombre");

			FormTipoRequerimiento formTipoRequerimiento = (FormTipoRequerimiento) form;
			
			String action = parseAction(formTipoRequerimiento.getAction());
			String stateAction = parseState(formTipoRequerimiento.getAction());
		
			System.out.println("ESTE ES EL ACTION:");
			System.out.println(action);
			System.out.println(stateAction);
			System.out.println();

			// el default es continuar con la misma página
			forward = mapping.findForward("continue");

			// Alta de estados
			if        (action.equals(FormTipoRequerimiento.ACCION_AGREGAR_ESTADO)) {
				if (LabelAndValueListHelper.existsOnLabelValueArray(formTipoRequerimiento.getEstadosReales(), formTipoRequerimiento.getEstado())) {
					errors.add("estados", new ActionError("errors.tipoRequerimiento.estadoExistente"));
				} else if (formTipoRequerimiento.getEstado() == null || formTipoRequerimiento.getEstado().length() == 0) {
					errors.add("estados", new ActionError("errors.tipoRequerimiento.estadoVacio"));
				} else {
					formTipoRequerimiento.agregarEstado();
				}

			// Baja de estados
			} else if (action.equals(FormTipoRequerimiento.ACCION_QUITAR_ESTADO)) {
				if (formTipoRequerimiento.getEstadoSeleccionado() == null || formTipoRequerimiento.getEstadoSeleccionado().length() == 0) {
					errors.add("estados", new ActionError("errors.tipoRequerimiento.estadoNoSeleccionado"));
				} else {
					formTipoRequerimiento.quitarEstado();
				}

			// Alta de propiedades
			} else if (action.equals(FormTipoRequerimiento.ACCION_AGREGAR_PROPIEDAD) &&
						stateAction == null) {
				if (LabelAndValueListHelper.existsOnLabelValueArray(formTipoRequerimiento.getPropiedades(), formTipoRequerimiento.getPropiedad())) {
					errors.add("propiedades", new ActionError("errors.tipoRequerimiento.propiedadExistente"));
				} else if (formTipoRequerimiento.getPropiedad() == null || formTipoRequerimiento.getPropiedad().length() == 0) {
					errors.add("propiedades", new ActionError("errors.tipoRequerimiento.propiedadVacia"));
				} else {
					formTipoRequerimiento.agregarPropiedad();
				}

			// Baja de propiedades
			} else if (action.equals(FormTipoRequerimiento.ACCION_QUITAR_PROPIEDAD) &&
						stateAction == null) {
				if (formTipoRequerimiento.getPropiedadSeleccionada() == null || formTipoRequerimiento.getPropiedadSeleccionada().length() == 0) {
					errors.add("propiedades", new ActionError("errors.tipoRequerimiento.propiedadNoSeleccionada"));
				} else {
					formTipoRequerimiento.quitarPropiedad();
				}

			// Alta de propiedades
			} else if (action.equals(FormTipoRequerimiento.ACCION_AGREGAR_PROPIEDAD) &&
						stateAction != null) {
				int index = LabelAndValueListHelper.indexOnLabelValueArray(formTipoRequerimiento.getEstadosReales(), stateAction);
				if (LabelAndValueListHelper.existsOnLabelValueArray(formTipoRequerimiento.getPropiedadesEstados(index), formTipoRequerimiento.getPropiedadEstados(index))) {
					errors.add("propiedades", new ActionError("errors.tipoRequerimiento.propiedadExistente"));
				} else if (formTipoRequerimiento.getPropiedadEstados(index) == null || formTipoRequerimiento.getPropiedadEstados(index).length() == 0) {
					errors.add("propiedades", new ActionError("errors.tipoRequerimiento.propiedadVacia"));
				} else {
					formTipoRequerimiento.agregarPropiedadEstados(index);
				}

			// Baja de propiedades
			} else if (action.equals(FormTipoRequerimiento.ACCION_QUITAR_PROPIEDAD) &&
						stateAction != null) {
				int index = LabelAndValueListHelper.indexOnLabelValueArray(formTipoRequerimiento.getEstadosReales(), stateAction);
				if (formTipoRequerimiento.getPropiedadSeleccionadaEstados(index) == null || formTipoRequerimiento.getPropiedadSeleccionadaEstados(index).length() == 0) {
					errors.add("propiedades", new ActionError("errors.tipoRequerimiento.propiedadNoSeleccionada"));
				} else {
					formTipoRequerimiento.quitarPropiedadEstados(index);
				}

			}
/*		
			try	{
				//obtiene la transacción asociada al administrador de persistencia.
				SessionManager.beginTransaction();

				Cysdreq cysdreq = Cysdreq.getPersistentInstance();
			
				Proyecto proyecto = cysdreq.getProyecto(nombreProyecto);
						
				if (proyecto == null) {
					errors.add("name", new ActionError("errors.ingresarAProyecto.inexistente"));
				} else {
								
					HttpSession session = request.getSession();
					UserBean userBean = (UserBean) session.getAttribute(LogonAction.USER_KEY);
				
					userBean.setNombreProyecto(nombreProyecto);
				}
			
				SessionManager.commit();
			} catch (Throwable t) {
				SessionManager.rollback();
				t.printStackTrace();
				System.out.println("Error al recuperar el proyecto");
				// Report the error using the appropriate name and ID.
				errors.add("name", new ActionError("id"));

			}
*/
			formTipoRequerimiento.setAction("");

			// If a message is required, save the specified key(s)
			// into the request for use by the <struts:errors> tag.
			if (!errors.isEmpty()) {
				saveErrors(request, errors);

				// Forward control to the appropriate 'failure' URI (change name as desired)
				forward = mapping.findForward("error");
			}

			// Finish with
			return (forward);
	}

	/**
	 * @param string
	 * @return
	 */
	private String parseAction(String action) {
		String resultAction = action.trim();

		if (action.endsWith(")")) {
			int start = action.trim().indexOf('(');
			int end = action.trim().indexOf(')');
			resultAction = action.trim().substring(0, start - 1);
		}

		return resultAction;
	}

	/**
	 * @param string
	 * @return
	 */
	private String parseState(String action) {
		String resultState = null;

		if (action.endsWith(")")) {
			int start = action.trim().indexOf('(');
			int end = action.trim().indexOf(')');
			resultState = action.trim().substring(start + 1, end);
		}

		return resultState;
	}

}
