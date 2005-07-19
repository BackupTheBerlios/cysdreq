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

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof GenericBean) {
			GenericBean bean = (GenericBean) obj;
			return (this.getLabel().equals(bean.getLabel()) &&
					this.getValue().equals(bean.getValue()));
		} else
			return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return this.getLabel().hashCode() ^ this.getValue().hashCode();
	}

}
