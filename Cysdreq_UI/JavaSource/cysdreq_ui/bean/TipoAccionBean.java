/*
 * Created on 02/07/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cysdreq_ui.bean;

import com.cysdreq.acciones.TipoAccion;

/**
 * @author Nacirita
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TipoAccionBean {

	private TipoAccion tipoAccion;

	/**
	 * 
	 */
	public TipoAccionBean() {
		super();
	}

	/**
	 * 
	 */
	public TipoAccionBean(TipoAccion tipo) {
		super();
		setTipoAccion(tipo);
	}

	/**
	 * @return
	 */
	public TipoAccion getTipoAccion() {
		return tipoAccion;
	}

	/**
	 * @param accion
	 */
	public void setTipoAccion(TipoAccion accion) {
		tipoAccion = accion;
	}

	public String getLabel() {
		return this.getTipoAccion().getName();
	}

	public Object getValue() {
		return this.getTipoAccion();
	}

}
