/*
 * Created on 27/07/2005
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
public class ListadoRequerimientosBean {
	
	private int idRequerimiento;
	private String nombreTipo;
	private String estado;
	private String propietario;
	private String responsable;	

	public ListadoRequerimientosBean(int i, String n, String e, String p, String r) {

		idRequerimiento = i;
		nombreTipo = n;
		estado = e;
		propietario = p;
		responsable = r;
				
	
	}
	/**
	 * @return
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @return
	 */
	public String getNombreTipo() {
		return nombreTipo;
	}

	/**
	 * @return
	 */
	public String getPropietario() {
		return propietario;
	}

	/**
	 * @return
	 */
	public String getResponsable() {
		return responsable;
	}

	/**
	 * @param string
	 */
	public void setEstado(String string) {
		estado = string;
	}

	/**
	 * @param string
	 */
	public void setNombreTipo(String string) {
		nombreTipo = string;
	}

	/**
	 * @param string
	 */
	public void setPropietario(String string) {
		propietario = string;
	}

	/**
	 * @param string
	 */
	public void setResponsable(String string) {
		responsable = string;
	}

	/**
	 * @return
	 */
	public int getIdRequerimiento() {
		return idRequerimiento;
	}

	/**
	 * @param i
	 */
	public void setIdRequerimiento(int i) {
		idRequerimiento = i;
	}

}
