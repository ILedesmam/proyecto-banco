package model;

public class ejecutivo extends persona {
	protected String ejeFecContrato;

	public ejecutivo() {
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
	 */
	public ejecutivo(String perRut, String perNombre, String perApePaterno, String perApeMaterno,
			String perFecNacimiento, String perNacionalidad, String ejeFecContrato) {
		super(perRut, perNombre, perApePaterno, perApeMaterno, perFecNacimiento, perNacionalidad);
		this.ejeFecContrato = ejeFecContrato;
	}


	public String getEjeFecContrato() {
		return ejeFecContrato;
	}

	public void setEjeFecContrato(String ejeFecContrato) {
		this.ejeFecContrato = ejeFecContrato;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ejecutivo [ejeFecContrato=" + ejeFecContrato + ", perRut=" + perRut + ", perNombre=" + perNombre
				+ ", perApePaterno=" + perApePaterno + ", perApeMaterno=" + perApeMaterno + ", perFecNacimiento="
				+ perFecNacimiento + ", perNacionalidad=" + perNacionalidad + "]";
	}
}
