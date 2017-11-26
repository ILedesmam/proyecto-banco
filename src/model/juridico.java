/**
 * 
 */
package model;

/**
 * @author IvanL
 *
 */
public final class juridico extends cliente {
	private String jurRazSocial;

	/**
	 * 
	 */
	public juridico() {
		super();
	}
	
	/**
	 * @param perRut
	 * @param perNombre
	 * @param perApePaterno
	 * @param perApeMaterno
	 * @param perFecNacimiento
	 * @param perNacionalidad
	 * @param cliCategoria
	 * @param eje
	 * @param jurRazSocial
	 */
	public juridico(String perRut, String perNombre, String perApePaterno, String perApeMaterno,
			String perFecNacimiento, String perNacionalidad, String cliCategoria, ejecutivo eje, String jurRazSocial) {
		super(perRut, perNombre, perApePaterno, perApeMaterno, perFecNacimiento, perNacionalidad, cliCategoria, eje);
		this.jurRazSocial = jurRazSocial;
	}
	public String getJurRazSocial() {
		return jurRazSocial;	}
	public void setJurRazSocial(String jurRazSocial) {
		this.jurRazSocial = jurRazSocial;	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "juridico [jurRazSocial=" + jurRazSocial + ", cliCategoria=" + cliCategoria + ", eje=" + eje
				+ ", perRut=" + perRut + ", perNombre=" + perNombre + ", perApePaterno=" + perApePaterno
				+ ", perApeMaterno=" + perApeMaterno + ", perFecNacimiento=" + perFecNacimiento + ", perNacionalidad="
				+ perNacionalidad + "]";
	}

	
}
