package model;
/**
 * 
 * @author Ivan Ledesma
 *
 */
public final class cuenta {
	private Integer cueId;
	private Integer cueSaldo;
	private String cueFecApertura;
	private String cueEstado;
	private Integer cueSobregiro;
	private cliente cliente;
	/**
	 * @param cliente
	 */
	public cuenta(cliente cliente) {
		this.cliente = cliente;
	}
	/**
	 * @param cueId
	 * @param cueSaldo
	 * @param cueFecApertura
	 * @param cueEstado
	 * @param cueSobregiro
	 * @param cliente
	 */
	public cuenta(Integer cueId, 
			Integer cueSaldo, 
			String cueFecApertura, 
			String cueEstado, 
			Integer cueSobregiro,
			cliente cliente) {
		this.cueId = cueId;
		this.cueSaldo = cueSaldo;
		this.cueFecApertura = cueFecApertura;
		this.cueEstado = cueEstado;
		this.cueSobregiro = cueSobregiro;
		this.cliente = cliente;
	}
	public Integer getCueId() {
		return cueId;	}
	public void setCueId(Integer cueId) {
		this.cueId = cueId;	}
	public Integer getCueSaldo() {
		return cueSaldo;	}
	public void setCueSaldo(Integer cueSaldo) {
		this.cueSaldo = cueSaldo;	}
	public String getCueFecApertura() {
		return cueFecApertura;	}
	public void setCueFecApertura(String cueFecApertura) {
		this.cueFecApertura = cueFecApertura;	}
	public String getCueEstado() {
		return cueEstado;	}
	public void setCueEstado(String cueEstado) {
		this.cueEstado = cueEstado;	}
	public Integer getCueSobregiro() {
		return cueSobregiro;	}
	public void setCueSobregiro(Integer cueSobregiro) {
		this.cueSobregiro = cueSobregiro;	}
	public cliente getCliente() {
		return cliente;	}
	public void setCliente(cliente cliente) {
		this.cliente = cliente;	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "cuenta [cueId=" + cueId 
				+ ", cueSaldo=" + cueSaldo 
				+ ", cueFecApertura=" + cueFecApertura
				+ ", cueEstado=" + cueEstado 
				+ ", cueSobregiro=" + cueSobregiro 
				+ ", cliente=" + cliente + "]";
	}
	
	
	
	
	
	
}
