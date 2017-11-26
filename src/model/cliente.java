package model;

public class cliente extends persona {
	protected String cliCategoria;
	protected ejecutivo eje;

	/**
	 * 
	 */
	public cliente() {
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
	 */
	public cliente(String perRut, String perNombre, String perApePaterno, String perApeMaterno, String perFecNacimiento,
			String perNacionalidad, String cliCategoria, ejecutivo eje) {
		super(perRut, perNombre, perApePaterno, perApeMaterno, perFecNacimiento, perNacionalidad);
		this.cliCategoria = cliCategoria;
		this.eje = eje;
	}


	public String getCliCategoria() {
		return cliCategoria; }
	public void setCliCategoria(String cliCategoria) {
		this.cliCategoria = cliCategoria; }
	public ejecutivo getEje() {
		return eje;	}
	public void setEje(ejecutivo eje) {
		this.eje = eje;  }
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "cliente [cliCategoria=" + cliCategoria + ", eje=" + eje + ", perRut=" + perRut + ", perNombre="
				+ perNombre + ", perApePaterno=" + perApePaterno + ", perApeMaterno=" + perApeMaterno
				+ ", perFecNacimiento=" + perFecNacimiento + ", perNacionalidad=" + perNacionalidad + "]";
	}
}
