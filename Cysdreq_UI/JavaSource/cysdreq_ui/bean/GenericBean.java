/*
 * Created on 16/07/2005
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
public class GenericBean {

	private String label;
	private String value;

	/**
	 * 
	 */
	public GenericBean(String labelAndValue) {
		super();
		setLabel(labelAndValue);
		setValue(labelAndValue);
	}

	/**
	 * 
	 */
	public GenericBean(String lbl, String val) {
		super();
		setLabel(lbl);
		setValue(val);
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
