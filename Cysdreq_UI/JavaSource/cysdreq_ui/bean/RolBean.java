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

	private String label;
	private String value;

	/**
	 * 
	 */
	public RolBean() {
		super();
	}

	public RolBean(Rol rol) {
		super();
		setLabel(rol.getNombre());
		setValue(rol.getNombre());
	}




	/**
	 * @return
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @return
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param string
	 */
	public void setLabel(String string) {
		label = string;
	}

	/**
	 * @param string
	 */
	public void setValue(String string) {
		value = string;
	}

}