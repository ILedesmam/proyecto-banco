package model;

public final class usuario extends ejecutivo {
	private String usuAlias;
	private String usuClave;
	private String usuEstado;
	private String usuFecRegistro;
	
	public usuario() {
		super();
	}
	

	/**
	 * @param perRut
	 * @param perNombre
	 * @param perApePaterno
	 * @param perApeMaterno
	 * @param perFecNacimiento
	 * @param perNacionalidad
	 * @param ejeFecContrato
	 * @param usuAlias
	 * @param usuClave
	 * @param usuEstado
	 * @param usuFecRegistro
	 */
	public usuario(String perRut, String perNombre, String perApePaterno, String perApeMaterno, String perFecNacimiento,
			String perNacionalidad, String ejeFecContrato, String usuAlias, String usuClave, String usuEstado,
			String usuFecRegistro) {
		super(perRut, perNombre, perApePaterno, perApeMaterno, perFecNacimiento, perNacionalidad, ejeFecContrato);
		this.usuAlias = usuAlias;
		this.usuClave = usuClave;
		this.usuEstado = usuEstado;
		this.usuFecRegistro = usuFecRegistro;
	}


	public String getUsuAlias() {
		return usuAlias;
	}

	public void setUsuAlias(String usuAlias) {
		this.usuAlias = usuAlias;
	}

	public String getUsuClave() {
		return usuClave;
	}

	public void setUsuClave(String usuClave) {
		this.usuClave = usuClave;
	}

	public String getUsuEstado() {
		return usuEstado;
	}

	public void setUsuEstado(String usuEstado) {
		this.usuEstado = usuEstado;
	}

	public String getUsuFecRegistro() {
		return usuFecRegistro;
	}

	public void setUsuFecRegistro(String usuFecRegistro) {
		this.usuFecRegistro = usuFecRegistro;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "usuario [usuAlias=" + usuAlias + ", usuClave=" + usuClave + ", usuEstado=" + usuEstado
				+ ", usuFecRegistro=" + usuFecRegistro + ", ejeFecContrato=" + ejeFecContrato + ", perRut=" + perRut
				+ ", perNombre=" + perNombre + ", perApePaterno=" + perApePaterno + ", perApeMaterno=" + perApeMaterno
				+ ", perFecNacimiento=" + perFecNacimiento + ", perNacionalidad=" + perNacionalidad + "]";
	}

	
	
	

}
