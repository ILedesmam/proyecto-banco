/**
 * 
 */
package model;

/**
 * @author Ivan Ledesma
 *
 */
public final class natural extends cliente {
	private Integer natPatrimonio;

	/**
	 * 
	 */
	public natural() {
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
	 * @param natPatrimonio
	 */
	public natural(String perRut, String perNombre, String perApePaterno, String perApeMaterno, String perFecNacimiento,
			String perNacionalidad, String cliCategoria, ejecutivo eje, Integer natPatrimonio) {
		super(perRut, perNombre, perApePaterno, perApeMaterno, perFecNacimiento, perNacionalidad, cliCategoria, eje);
		this.natPatrimonio = natPatrimonio;
	}


	public Integer getNatPatrimonio() {
		return natPatrimonio;	}
	public void setNatPatrimonio(Integer natPatrimonio) {
		this.natPatrimonio = natPatrimonio;	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "natural [natPatrimonio=" + natPatrimonio + ", cliCategoria=" + cliCategoria + ", eje=" + eje
				+ ", perRut=" + perRut + ", perNombre=" + perNombre + ", perApePaterno=" + perApePaterno
				+ ", perApeMaterno=" + perApeMaterno + ", perFecNacimiento=" + perFecNacimiento + ", perNacionalidad="
				+ perNacionalidad + "]";
	}
	
	
}
