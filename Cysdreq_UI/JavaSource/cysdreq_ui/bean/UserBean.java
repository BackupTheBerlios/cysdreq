/*
 * Created on 23/06/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cysdreq_ui.bean;

/**
 * @author Nacirita
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class UserBean {

	private String username;
	private String password;
	private String longUsername;

	/**
	 * 
	 */
	public UserBean() {
		super();
	}

	/**
	 * @return
	 */
	public String getLongUsername() {
		return longUsername;
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param string
	 */
	public void setLongUsername(String string) {
		longUsername = string;
	}

	/**
	 * @param string
	 */
	public void setPassword(String string) {
		password = string;
	}

	/**
	 * @param string
	 */
	public void setUsername(String string) {
		username = string;
	}

}
