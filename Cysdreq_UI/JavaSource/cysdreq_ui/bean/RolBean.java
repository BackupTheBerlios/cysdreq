/*
 * Created on 02/07/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cysdreq_ui.bean;

import com.cysdreq.modelo.Rol;

/**
 * @author Daniel Nanni
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class RolBean {

	private Rol rol;

	/**
	 * 
	 */
	public RolBean() {
		super();
	}

	public RolBean(Rol rol) {
		super();
		setRol(rol);
	}

	/**
	 * @return
	 */
	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol unRol) {
		rol = unRol;
	}

	public String getLabel() {
		return this.getRol().getNombre();
	}

	public Object getValue() {
		return this.getRol();
	}

}