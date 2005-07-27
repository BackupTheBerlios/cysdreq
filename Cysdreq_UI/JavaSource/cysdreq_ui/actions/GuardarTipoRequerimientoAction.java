/*
 * Created on 16/07/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cysdreq_ui.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;

import com.cysdreq.acciones.proyecto.AgregarTipoRequerimiento;
import com.cysdreq.loader.SessionManager;
import com.cysdreq.modelo.Cysdreq;
import com.cysdreq.modelo.Proyecto;
import com.cysdreq.util.LabelAndValueListHelper;
import com.cysdreq.util.PersistentArrayList;

import cysdreq_ui.bean.UserBean;
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
			if        (action.equals(FormTipoRequerimiento.ACCION_AGREGAR_ESTADO) &&
						stateAction == null) {
				if (LabelAndValueListHelper.existsOnLabelValueArray(formTipoRequerimiento.getEstadosReales(), formTipoRequerimiento.getEstado())) {
					errors.add("estados", new ActionError("errors.tipoRequerimiento.estadoExistente"));
				} else if (formTipoRequerimiento.getEstado() == null || formTipoRequerimiento.getEstado().length() == 0) {
					errors.add("estados", new ActionError("errors.tipoRequerimiento.estadoVacio"));
				} else {
					formTipoRequerimiento.agregarEstado();
				}

			// Baja de estados
			} else if (action.equals(FormTipoRequerimiento.ACCION_QUITAR_ESTADO) &&
						stateAction == null) {
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

			// Alta de propiedades de un estado determinado
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

			// Baja de propiedades de un estado determinado
			} else if (action.equals(FormTipoRequerimiento.ACCION_QUITAR_PROPIEDAD) &&
						stateAction != null) {
				int index = LabelAndValueListHelper.indexOnLabelValueArray(formTipoRequerimiento.getEstadosReales(), stateAction);
				if (formTipoRequerimiento.getPropiedadSeleccionadaEstados(index) == null || formTipoRequerimiento.getPropiedadSeleccionadaEstados(index).length() == 0) {
					errors.add("propiedades", new ActionError("errors.tipoRequerimiento.propiedadNoSeleccionada"));
				} else {
					formTipoRequerimiento.quitarPropiedadEstados(index);
				}

			// Alta de estados siguientes de un estado determinado
			} else if (action.equals(FormTipoRequerimiento.ACCION_AGREGAR_ESTADO) &&
						stateAction != null) {
				int index = LabelAndValueListHelper.indexOnLabelValueArray(formTipoRequerimiento.getEstadosReales(), stateAction);
				if (LabelAndValueListHelper.existsOnLabelValueArray(formTipoRequerimiento.getEstadosSiguientes(index), formTipoRequerimiento.getEstadoSiguienteSeleccionadoIzq(index))) {
					errors.add("estados", new ActionError("errors.tipoRequerimiento.estadoExistente"));
				} else if (formTipoRequerimiento.getEstadoSiguienteSeleccionadoIzq(index) == null || formTipoRequerimiento.getEstadoSiguienteSeleccionadoIzq(index).length() == 0) {
					errors.add("estados", new ActionError("errors.tipoRequerimiento.estadoIzqNoSeleccionado"));
				} else {
					formTipoRequerimiento.agregarEstadoSiguiente(index);
				}

			// Baja de estados siguientes de un estado determinado
			} else if (action.equals(FormTipoRequerimiento.ACCION_QUITAR_ESTADO) &&
						stateAction != null) {
				int index = LabelAndValueListHelper.indexOnLabelValueArray(formTipoRequerimiento.getEstadosReales(), stateAction);
				if (formTipoRequerimiento.getEstadoSiguienteSeleccionadoDer(index) == null || formTipoRequerimiento.getEstadoSiguienteSeleccionadoDer(index).length() == 0) {
					errors.add("estados", new ActionError("errors.tipoRequerimiento.estadoDerNoSeleccionado"));
				} else {
					formTipoRequerimiento.quitarEstadoSiguiente(index);
				}


			// Agrega el tipo de requerimiento
			} else if (action.equals(FormTipoRequerimiento.ACCION_GUARDAR_TIPO)) {
				try	{
					//obtiene la transacción asociada al administrador de persistencia.
					SessionManager.beginTransaction();
	
					HttpSession session = request.getSession();
					UserBean userBean = (UserBean) session.getAttribute(LogonAction.USER_KEY);

					Cysdreq cysdreq = Cysdreq.getPersistentInstance();
				
					Proyecto proyecto = cysdreq.getProyecto(userBean.getNombreProyecto());
							
					if (proyecto == null) {
						errors.add("name", new ActionError("errors.tipoRequerimiento.proyectoNoSeleccionado"));
					} else {
						
						// Itera sobre los estados armando los arraylist de arraylist de estados y propiedades
						PersistentArrayList estadosSiguientes = new PersistentArrayList();
						PersistentArrayList propiedadesDeEstados = new PersistentArrayList();
						for (int i = 0; i < formTipoRequerimiento.getEstadosReales().size(); i++) {
							PersistentArrayList estados = new PersistentArrayList(formTipoRequerimiento.getNombresEstadosSiguientes(i));
							estadosSiguientes.add(estados);

							PersistentArrayList propiedades = new PersistentArrayList(formTipoRequerimiento.getNombresPropiedadesEstados(i));
							propiedadesDeEstados.add(propiedades);
						}

						HashMap params = new HashMap(5);
						params.put("nombre", formTipoRequerimiento.getNombre());
						params.put("estados", new PersistentArrayList(formTipoRequerimiento.getNombresEstadosReales()));
						params.put("propiedades", new PersistentArrayList(formTipoRequerimiento.getNombresPropiedadesReales()));
						params.put("estadosSiguientes", estadosSiguientes);
						params.put("propiedadesDeEstados", propiedadesDeEstados);

						cysdreq.ejecutarAccion(new AgregarTipoRequerimiento(), proyecto, params);
					}
				
					SessionManager.commit();

					forward = mapping.findForward("globalSuccess");

				} catch (Throwable t) {
					t.printStackTrace();
					SessionManager.rollback();
					System.out.println("Error al recuperar el proyecto");
					// Report the error using the appropriate name and ID.
					errors.add("tipoRequerimiento", new ActionError("errors.tipoRequerimiento.guardarTipoRequerimiento"));
				}
			}
			
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
