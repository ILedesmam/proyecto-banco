package model;

import java.time.LocalDate;

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
	/**
	 * Funcion checkNombre
	 * @param x
	 * esta funcion detecta si en la variable entrante existen simbolos que no sean letras.
	 * con un recorrido de cada simbolo,usa una conversion de los simbolos del arreglo a 
	 * un numero de la tabla de ASCII, si el numero esta entre 65 y 122, significa que el
	 * simbolo entrante es una letra.
	 * Si llegara al caso de que el simbolo no fuera una letra, automaticamente se coloca
	 * el nombre como "null" y rompe el recorrido del arreglo ya que el simbolo no estaba
	 * dentro del rango 65 y 122, lo que significa que no era una letra.
	 * 
	 */
	public void checkNombre(String x) {
		char nomChar;
		Integer bandn = 1;
		int nomInt;
		for (int i = 0; i < x.length(); i++) {
  		  nomChar = String.valueOf(x).charAt(i);
  		  nomInt = (int)nomChar;
  		  if(nomInt<65 || nomInt>122) {
  			  this.perNombre=null;
  			  bandn=0;
  			  break;
  		  }
		}
		if (bandn == 1) {
			this.perNombre = x;
		}
	}
	/**
	 * Funcion checkApellido
	 * @param x
	 *esta funcion divide la variable entrante en 2 subvariables colocadas en un arreglo, 
	 *luego las subvariables son colocadas en otras variables de forma individual, despues
	 *son recorridas cada una de las variables en busca de simbolos que no sean letras,
	 *si un simbolo no es letra, automaticamente se coloca el apellido a null y se sale
	 *del recorrido.
	 */
	public void checkApellidos(String x) {
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
	public boolean checkEdad() {
		LocalDate currentDate = LocalDate.now();
		int y = currentDate.getYear();
		String[] e = this.perFecNacimiento.split("-");
		Integer year = Integer.parseInt(e[0]);
		if (y-year>=18) {
			return true;
		}else {
			return false;
		}
	}
	public void checkNacionalidad(String x) {
		char nomChar;
		Integer bandn = 1;
		int nomInt;
		for (int i = 0; i < x.length(); i++) {
  		  nomChar = String.valueOf(x).charAt(i);
  		  nomInt = (int)nomChar;
  		  if(nomInt<65 || nomInt>122) {
  			  this.perNacionalidad=null;
  			  bandn=0;
  			  break;
  		  }
		}
		if (bandn == 1) {
			this.perNacionalidad = x;
		}
	}
	
}
