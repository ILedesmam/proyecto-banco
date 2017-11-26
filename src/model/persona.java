package model;
/**
 * 
 * @author Ivan Ledesma
 * @version 1.0 03-11-2017
 * 
 * aqui se representa una persona abstracta
 *
 */
public abstract class persona {
	protected String perRut;
	protected String perNombre;
	protected String perApePaterno;
	protected String perApeMaterno;
	protected String perFecNacimiento;
	protected String perNacionalidad;
	/**
	 * constructor vacio
	 */
	public persona() {
	}
	/**
	 * @param perRut
	 * @param perNombre
	 * @param perApePaterno
	 * @param perApeMaterno
	 * @param perFecNacimiento
	 * @param perNacionalidad
	 */
	public persona(String perRut, String perNombre, String perApePaterno, String perApeMaterno, String perFecNacimiento,
			String perNacionalidad) {
		this.perRut = perRut;
		this.perNombre = perNombre;
		this.perApePaterno = perApePaterno;
		this.perApeMaterno = perApeMaterno;
		this.perFecNacimiento = perFecNacimiento;
		this.perNacionalidad = perNacionalidad;
	}

	public String getPerRut() {
		return perRut;
	}
	public void setPerRut(String perRut) {
		this.perRut = perRut;
	}
	public String getPerNombre() {
		return perNombre;
	}
	public void setPerNombre(String perNombre) {
		this.perNombre = perNombre;
	}
	public String getPerApePaterno() {
		return perApePaterno;
	}
	public void setPerApePaterno(String perApePaterno) {
		this.perApePaterno = perApePaterno;
	}
	public String getPerApeMaterno() {
		return perApeMaterno;
	}
	public void setPerApeMaterno(String perApeMaterno) {
		this.perApeMaterno = perApeMaterno;
	}
	public String getPerFecNacimiento() {
		return perFecNacimiento;
	}
	public void setPerFecNacimiento(String perFecNacimiento) {
		this.perFecNacimiento = perFecNacimiento;
	}
	public String getPerNacionalidad() {
		return perNacionalidad;
	}
	public void setPerNacionalidad(String perNacionalidad) {
		this.perNacionalidad = perNacionalidad;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "persona [perRut=" + perRut + ", perNombre=" + perNombre + ", perApePaterno=" + perApePaterno
				+ ", perApeMaterno=" + perApeMaterno + ", perFecNacimiento=" + perFecNacimiento + ", perNacionalidad="
				+ perNacionalidad + "]";
	}
	
	public void dividirApellidos(String x) {
		String[] partes = x.split(" ");
		String parte1 = partes[0];
		String parte2 = partes[1];
		char nomChar;
		Integer bandp = 1;
		Integer bandm = 1;
		int nomInt;
		for (int i = 0; i < parte1.length(); i++) {
  		  nomChar = String.valueOf(parte1).charAt(i);
  		  nomInt = (int)nomChar;
  		  System.out.println(nomInt);
  		  if(nomInt<65 || nomInt>122) {
  			  this.perApePaterno="";
  			  bandp=0;
  			  break;
  		  }
		}
		if (bandp == 1) {
			this.perApePaterno = parte1;
		}
  		for (int i = 0; i < parte2.length(); i++) {
  		  nomChar = String.valueOf(parte2).charAt(i);
  		  nomInt = (int)nomChar;
  		  System.out.println(nomInt);
  		  if(nomInt<65 || nomInt>122) {
  			this.perApeMaterno="";
  			bandm=0;
  			  break;
  		  }
  	  }
  		if (bandm == 1) {
  			this.perApeMaterno = parte2;
  		}
	}
	
}
