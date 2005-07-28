package cysdreq_ui.actions;

import java.util.ArrayList;
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

import com.cysdreq.loader.SessionManager;
import com.cysdreq.modelo.Cysdreq;
import com.cysdreq.modelo.Proyecto;
import com.cysdreq.modelo.flow.TipoEstado;
import com.cysdreq.modelo.flow.Transicion;
import com.cysdreq.modelo.req.TipoPropiedad;
import com.cysdreq.modelo.req.TipoRequerimiento;
import com.cysdreq.util.LabelAndValueListHelper;

import cysdreq_ui.bean.UserBean;
import cysdreq_ui.forms.FormTipoRequerimiento;
import cysdreq_ui.forms.FormTiposDeRequerimientos;

/**
 * @version 	1.0
 * @author
 */
public class TiposDeRequerimientosAction extends Action {

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

			ActionErrors errors = new ActionErrors();
			ActionForward forward = new ActionForward();
			// return value
			FormTiposDeRequerimientos formTiposDeRequerimientos = (FormTiposDeRequerimientos) form;
	
			String action = formTiposDeRequerimientos.getAction();

			// Modificación de un tipo de requerimiento
			if (action.equals(FormTiposDeRequerimientos.ACCION_MODIFICAR)) {
				try	{
					FormTipoRequerimiento nextForm = new FormTipoRequerimiento();
					nextForm.setModificacion(true);

					//obtiene la transacción asociada al administrador de persistencia.
					SessionManager.beginTransaction();
	
					HttpSession session = request.getSession();
					UserBean userBean = (UserBean) session.getAttribute(LogonAction.USER_KEY);

					Cysdreq cysdreq = Cysdreq.getPersistentInstance();
				
					Proyecto proyecto = cysdreq.getProyecto(userBean.getNombreProyecto());
							
					if (proyecto == null) {
						errors.add("name", new ActionError("errors.tipoRequerimiento.proyectoNoSeleccionado"));
					} else {
						Iterator iter;
						
						// Obtiene el tipo de requerimiento
						TipoRequerimiento tipoRequerimiento = proyecto.getTipoRequerimiento(formTiposDeRequerimientos.getNombreTipoSeleccionado());
						
						// Setea el nombre del tipo de requerimiento
						nextForm.setNombre(tipoRequerimiento.getNombre());
						nextForm.setNombreTipoModificado(tipoRequerimiento.getNombre());

						// Arma un arraylist con los nombres de los tipos de estados
						ArrayList nombresEstados = new ArrayList();
						iter = tipoRequerimiento.getTiposDeEstados().iterator();
						int i = 0;
						while (iter.hasNext()) {
							TipoEstado tipoEstado = (TipoEstado) iter.next();
							nombresEstados.add(tipoEstado.getNombre());
							
							// Obtiene las transiciones de este estado
							ArrayList nombresEstadosSiguientes = new ArrayList();
							Iterator iterTrans = tipoEstado.getTransiciones().iterator();
							while (iterTrans.hasNext()) {
								Transicion transicion = (Transicion) iterTrans.next();
								nombresEstadosSiguientes.add(transicion.getTipoEstadoDestino().getNombre());
							}
							nextForm.setEstadosSiguientesIngresados(i, LabelAndValueListHelper.renderArrayList(nombresEstadosSiguientes));

							// Obtiene las propiedades de este estado
							ArrayList nombresPropiedadesEstados = new ArrayList();
							Iterator iterProps = tipoEstado.getTiposPropiedades().iterator();
							while (iterProps.hasNext()) {
								TipoPropiedad tipoPropiedad = (TipoPropiedad) iterProps.next();
								nombresPropiedadesEstados.add(tipoPropiedad.getNombre());
							}
							nextForm.setPropiedadesIngresadasEstados(i, LabelAndValueListHelper.renderArrayList(nombresPropiedadesEstados));
							i++;
						}
						nextForm.setEstadosIngresados(LabelAndValueListHelper.renderArrayList(nombresEstados));

						// Arma un arraylist con los nombres de las propiedades del estado
						ArrayList nombresPropiedades = new ArrayList();
						iter = tipoRequerimiento.getTiposPropiedades().iterator();
						while (iter.hasNext()) {
							TipoPropiedad tipoPropiedad = (TipoPropiedad) iter.next();
							nombresPropiedades.add(tipoPropiedad.getNombre());
						}
						nextForm.setPropiedadesIngresadas(LabelAndValueListHelper.renderArrayList(nombresPropiedades));
					}
				
					SessionManager.commit();

					// Le asigna al form de la página siguiente el form que se armó
					request.setAttribute("formTipoRequerimiento", nextForm);

				} catch (Throwable t) {
					t.printStackTrace();
					SessionManager.rollback();
					System.out.println("Error al recuperar la data del tipo de requerimiento");
					// Report the error using the appropriate name and ID.
					errors.add("tipoRequerimiento", new ActionError("errors.tipoRequerimiento.getTipoRequerimiento"));
				}
				
			// Baja de un tipo de requerimiento
			} else if (action.equals(FormTiposDeRequerimientos.ACCION_ELIMINAR)) {

			}

			// If a message is required, save the specified key(s)
			// into the request for use by the <struts:errors> tag.
			if (!errors.isEmpty()) {
				saveErrors(request, errors);

				// Forward control to the appropriate 'failure' URI (change name as desired)
				forward = mapping.findForward("error");
			} else {
				forward = mapping.findForward("success");
			}

			// Finish with
			return (forward);

		}
}
