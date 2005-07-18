/*
 * Created on 16/07/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cysdreq_ui.bean;

import com.cysdreq.modelo.Usuario;



/**
 * @author Daniel Nanni
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class UsuarioBean {
	private String label;
	private String value;

	/**
	 * 
	 */
	public UsuarioBean() {
		super();
	}

	public UsuarioBean(Usuario usuario) {
		super();
		setLabel(usuario.getNombre());
		setValue(usuario.getUsuario());
	}

	public String getLabel() {
		return label;
	}
	
	public String getValue() {
		return value;
	}

	public void setLabel(String string) {
		label = string;
	}

	public void setValue(String string) {
		value = string;
	}

}