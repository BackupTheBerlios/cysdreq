/*
 * Created on 26/07/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cysdreq_ui.bean;

/**
 * @author Daniel Nanni
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ListadoUsuariosBean {

	private String nombre;
	private String login;
	private String roles;
	private String proyecto;

	public ListadoUsuariosBean(String n, String l, String r, String p) {

		nombre = n;
		login = l;
		roles = r;
		proyecto = p;
				
	}
	
	
	
	/**
	 * @return
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @return
	 */
	public String getProyecto() {
		return proyecto;
	}

	/**
	 * @return
	 */
	public String getRoles() {
		return roles;
	}

	/**
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param string
	 */
	public void setLogin(String string) {
		login = string;
	}

	/**
	 * @param string
	 */
	public void setProyecto(String string) {
		proyecto = string;
	}

	/**
	 * @param string
	 */
	public void setRoles(String string) {
		roles = string;
	}

	/**
	 * @param string
	 */
	public void setNombre(String string) {
		nombre = string;
	}

}
