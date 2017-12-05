/**
 * 
 */
package view;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.cliente;
import model.cuenta;
import model.ejecutivo;
import model.juridico;
import model.natural;
import modeldao.clientedao;
import modeldao.cuentadao;
import modeldao.ejecutivodao;
import modeldao.juridicodao;
import modeldao.naturaldao;

/**
 * @author Ivan Ledesma
 *
 */
public class main {
	public static void main(String[] args) {
		String rut,ruteje,nombre,apellidos,categoria, nacionalidad,nacimiento,sobregiro,estado,contrato;
		Integer id,saldo;
		JTextField dia = new JTextField(2);
		JTextField mes = new JTextField(2);
		JTextField year = new JTextField(4);
		JPanel myPanel = new JPanel();
		myPanel.add(new JLabel("Dia:"));
	    myPanel.add(dia);
	    myPanel.add(Box.createVerticalStrut(10));
	    myPanel.add(new JLabel("Mes:"));
	    myPanel.add(mes);
	    myPanel.add(Box.createVerticalStrut(10));
	    myPanel.add(new JLabel("Año:"));
	    myPanel.add(year);
		char nomChar;
		int nomInt;
		Integer p;
		String r;
		int band = 0;
		natural n;
		juridico j;
		ejecutivo e;
		cliente cli;
		cuenta cu;
		ArrayList<cliente> clientes;
		ArrayList<natural> naturales;
		ArrayList<juridico> juridicos;
		ArrayList<ejecutivo> ejecutivos;
		ArrayList<cuenta> cuentas;
		clientedao clidao;
		naturaldao natDao;
		juridicodao jurdao;
		ejecutivodao ejedao;
		cuentadao cuedao;
		Object [] cat = new Object[]  {"normal", "VIP", "riesgo"};
		Object [] opciones=new Object[] {"1.- Ingresar Cliente", 
				"2.- Registrar Cuenta", 
				"3.- Ejecutivos", 
				"4.- Listado de Clientes", 
				"5.- Gestionar Clientes", 
				"6.- Gestionar Cuentas",
				"7.- Realizar Giro",
				"8.- Realizar Deposito",
				"9.- Salir Programa"};
		Object [] caso1 = new Object[] {"1.- Cliente Natural", 
		"2.- Cliente Juridico"};
		Object [] caso2 = new Object[] {"0.- Sin SobreGiro", 
		"1.- Con Sobregiro"};
		Object [] caso3 = new Object[] {"1.- Registrar Ejecutivo",
				"2.- Actualizar Ejecutivo",
				"3.- Listar Ejecutivos"};
		Object [] caso4 = new Object[] {"1.- Listar Todos los Clientes",
				"2.- Listar Clientes Naturales",
				"3.- Listar Clientes Juridicos"};
		Object [] caso5 = new Object[] {"1.- Actualizar Cliente Natural", 
		"2.- Actualizar Cliente Juridico"};
		Object [] caso6 = new Object[] {"1.- Actualizar Cuenta", 
		"2.- Buscar Cuenta",
		"3.- Listar Todas las Cuentas",
		"4.- Listar Cuentas Naturales",
		"5.- Listar Cuentas Juridicos",
		"6.- Bloquear Cuenta",
		"7.- Eliminar Cuenta"};
		Object [] est = new Object[] {"vigente","bloqueado","inactivo"};
		while (true) {
			Object seleccion = JOptionPane.showInputDialog(
					   null, "Seleccione una opcion", "Sistema Banco Inter",
					   JOptionPane.QUESTION_MESSAGE, null,opciones,"1.- Ingresar Cliente");
			dia.setText("");
			mes.setText("");
			year.setText("");
			nacionalidad="";
			rut="";
			ruteje="";
			nombre = "";
			categoria = "";
			p = null;
			r = "";
			switch (String.valueOf(seleccion).charAt(0)) {
				case'1':
					Object eleccion1 = JOptionPane.showInputDialog(
							   null, "Seleccione el Tipo de Cliente a Ingresar", "Sistema Banco Inter",
							   JOptionPane.QUESTION_MESSAGE, null,caso1,"1.- Cliente Natural");
					n = new natural();
					j = new juridico();
					while (rut.equals("")) {
						rut = JOptionPane.showInputDialog("Ingrese el Rut del Cliente");
					}
					switch(String.valueOf(eleccion1).charAt(0)) {
					case'1':
						n.setPerRut(rut);
						break;
					case'2':
						j.setPerRut(rut);
						break;
					}
					
					while (nombre .equals("")) {
						nombre = JOptionPane.showInputDialog("Ingrese el Nombre del Cliente");
				    	  for (int i = 0; i < nombre.length(); i++) {
				    		  nomChar = String.valueOf(nombre).charAt(i);
				    		  nomInt = (int)nomChar;
				    		  if(nomInt<65 || nomInt>122) {
				    			  nombre="";
				    			  break;
				    		  }
				    	  }
				      }
					switch(String.valueOf(eleccion1).charAt(0)) {
					case'1':
						n.setPerNombre(nombre);
						break;
					case'2':
						j.setPerNombre(nombre);
						break;
					}
					switch(String.valueOf(eleccion1).charAt(0)) {
					case'1':
						while (n.getPerApePaterno() == null || n.getPerApePaterno().equals("")) {
							apellidos = JOptionPane.showInputDialog("Indique los Apellidos del cliente");
							n.checkApellidos(apellidos);
						}
						break;
					case'2':
						while (j.getPerApePaterno() == null || j.getPerApePaterno().equals("")) {
							apellidos = JOptionPane.showInputDialog("Indique los Apellidos del Cliente");
							j.checkApellidos(apellidos);
						}
						break;
					}	
					categoria = (String) JOptionPane.showInputDialog(
							   null, "Seleccione Categoria", "Sistema Banco Inter",
							   JOptionPane.QUESTION_MESSAGE, null,cat,"normal");
					switch(String.valueOf(eleccion1).charAt(0)) {
					case'1':
						n.setCliCategoria(categoria);;
						break;
					case'2':
						j.setCliCategoria(categoria);;
						break;
					}
				    switch(String.valueOf(eleccion1).charAt(0)) {
				      
				      case'1':
				      	p = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Patrimonio del Cliente"));
				      	
				      	n.setNatPatrimonio(p);
				    	  	naturaldao natdao = new naturaldao();
				    	  	natdao.ingresar(n);
				    	  	break;
				      case'2':
				      	r = JOptionPane.showInputDialog("Señale la razon social del Cliente");
				      	j.setJurRazSocial(r);
				      	juridicodao jur = new juridicodao();
				      	jur.ingresar(j);
				      	break;
				    }
					
					break;
				case'2':
					cli = new cliente();
					rut = JOptionPane.showInputDialog("Ingrese el RUT del Cliente");
					cli.setPerRut(rut);
					clidao = new clientedao();
					clidao.buscarforcuenta(cli);
					if (cli.getPerFecNacimiento() == null) {
						JOptionPane.showMessageDialog(null, "Fecha no Ingresada, Favor de Actualizar Fecha.");
					}else {
						if (cli.checkEdad()) {
							saldo = Integer.parseInt(JOptionPane.showInputDialog("Indique el Saldo que ingresara el Cliente"));
							if(cli.getCliCategoria().toLowerCase().equals("riesgo")) {
								sobregiro = "0";
							}else {
								Object sg = JOptionPane.showInputDialog(
										   null, "Indique Opcion de SobreGiro", "Sistema Banco Inter",
										   JOptionPane.QUESTION_MESSAGE, null,caso2,"0.- Sin SobreGiro");
								sobregiro =String.valueOf(String.valueOf(sg).charAt(0));}
							cu = new cuenta(cli);
							cu.setCueSaldo(saldo);
							cu.setCueSobregiro(Integer.parseInt(sobregiro));
							cuedao = new cuentadao();
							cuedao.ingresar(cu);
						}else {
							JOptionPane.showMessageDialog(null, "El Cliente no tiene Edad Suficiente para Abrir una Cuenta");
						}
					}
					break;
				case'3':
					ejedao = new ejecutivodao();
					e = new ejecutivo();
					Object seleccion3 = JOptionPane.showInputDialog(
							   null, "Seleccione una opcion", "Sistema Banco Inter",
							   JOptionPane.QUESTION_MESSAGE, null,caso3,"1.- Registrar Ejecutivo");
					switch(String.valueOf(seleccion3).charAt(0)) {
					case'1':
						
						while (e.getPerRut() == null || e.getPerRut().equals("")) {
							rut = JOptionPane.showInputDialog("Ingrese el RUT del Ejecutivo");
							e.setPerRut(rut);
						}
						while (e.getPerNombre() == null || e.getPerNombre().equals("")) {
							nombre = JOptionPane.showInputDialog("Indique el Nombre Del Ejecutivo");
							e.checkNombre(nombre);
						}
						while (e.getPerApePaterno() == null || e.getPerApePaterno().equals("")) {
							apellidos = JOptionPane.showInputDialog("Ingrese los Apellidos del Ejecutivo");
							e.checkApellidos(apellidos);
						}
					    JOptionPane.showConfirmDialog(null, myPanel, 
							    "Ingrese Fecha De Contratacion del Ejecutivo", JOptionPane.OK_CANCEL_OPTION);
					    e.setEjeFecContrato(year.getText()+"-"+mes.getText()+"-"+dia.getText());
					    
					    ejedao.ingresar(e);
					    break;
					case'2':
						
						while (e.getPerRut() == null || e.getPerRut().equals("")) {
							rut = JOptionPane.showInputDialog("Ingrese el RUT del Ejecutivo");
							e.setPerRut(rut);
						}
						while (e.getPerNombre() == null || e.getPerNombre().equals("")) {
							nombre = JOptionPane.showInputDialog("Indique el Nombre Del Ejecutivo");
							e.checkNombre(nombre);
						}
						while (e.getPerApePaterno() == null || e.getPerApePaterno().equals("")) {
							apellidos = JOptionPane.showInputDialog("Ingrese los Apellidos del Ejecutivo");
							e.checkApellidos(apellidos);
						}
						while (e.getPerNacionalidad() == null || e.getPerNacionalidad().equals("")) {
							nacionalidad = JOptionPane.showInputDialog("Ingrese la Nacionalidad del Ejecutivo");
					    	e.checkNacionalidad(nacionalidad);
					      }
					    JOptionPane.showConfirmDialog(null, myPanel, 
							    "Ingrese Fecha De Nacimiento del Ejecutivo", JOptionPane.OK_CANCEL_OPTION);
						nacimiento = year.getText()+"-"+mes.getText()+"-"+dia.getText();
						dia.setText("");
						mes.setText("");
						year.setText("");
						JOptionPane.showConfirmDialog(null, myPanel, 
							    "Ingrese Fecha De Contratacion del Ejecutivo", JOptionPane.OK_CANCEL_OPTION);
						contrato = year.getText()+"-"+mes.getText()+"-"+dia.getText();
					    e.setPerFecNacimiento(nacimiento);
					    e.setEjeFecContrato(contrato);
					    ejedao.actualizar(e);
					    
						break;
					case'3':
						ejecutivos = new ArrayList<>();
						ejedao = new ejecutivodao();
						ejecutivo ejecutivo1 = new ejecutivo();
						ejecutivos = ejedao.listar();
						for (ejecutivo e1 : ejecutivos) {
							System.out.println(e1.toString());
						}
							break;
						}
						break;
				case'4':
					Object eleccion4 = JOptionPane.showInputDialog(
							   null, "Seleccione Opcion de Listado", "Sistema Banco Inter",
							   JOptionPane.QUESTION_MESSAGE, null,caso4,"1.- Listar Todos los Clientes");
					switch(String.valueOf(eleccion4).charAt(0)) {
					case'1':
						clientes = new ArrayList<>();
						clidao = new clientedao();
						cliente cliente1 = new cliente();
						clientes = clidao.listar();
						for (cliente c1 : clientes) {
							System.out.println(c1.toString());
						}
						break;
					case'2':
						naturales= new ArrayList<>();
						natDao = new naturaldao();
						natural natural1 = new natural();
						naturales = natDao.listar();
						for (natural n1 : naturales) {
							System.out.println(n1.toString());
						}
						break;
					case'3':
						juridicos = new ArrayList<>();
						jurdao = new juridicodao();
						juridico juridico1 = new juridico();
						juridicos = jurdao.listar();
						for (juridico j1 : juridicos) {
							System.out.println(j1.toString());
						}
						break;
					}
					break;
				case'5':
					Object eleccion5 = JOptionPane.showInputDialog(
							   null, "Seleccione el Tipo de Cliente a Actualizar", "Sistema Banco Inter",
							   JOptionPane.QUESTION_MESSAGE, null,caso5,"1.- Actualizar Cliente Natural");
					e = new ejecutivo();
					n = new natural();
					j = new juridico();
					while (rut.equals("")) {
						rut = JOptionPane.showInputDialog("Ingrese el Rut del Cliente");
					}
					switch(String.valueOf(eleccion5).charAt(0)) {
					case'1':
						n.setPerRut(rut);
						break;
					case'2':
						j.setPerRut(rut);
						break;
					}
					
					while (nombre .equals("")) {
						nombre = JOptionPane.showInputDialog("Ingrese el Nombre del Cliente");
				    	  for (int i = 0; i < nombre.length(); i++) {
				    		  nomChar = String.valueOf(nombre).charAt(i);
				    		  nomInt = (int)nomChar;
				    		  if(nomInt<65 || nomInt>122) {
				    			  nombre="";
				    			  break;
				    		  }
				    	  }
				      }
					switch(String.valueOf(eleccion5).charAt(0)) {
					case'1':
						n.setPerNombre(nombre);
						break;
					case'2':
						j.setPerNombre(nombre);
						break;
					}
					switch(String.valueOf(eleccion5).charAt(0)) {
					case'1':
						while (n.getPerApePaterno() == null || n.getPerApePaterno().equals("")) {
							apellidos = JOptionPane.showInputDialog("Indique los Apellidos del cliente");
							n.checkApellidos(apellidos);
						}
						break;
					case'2':
						while (j.getPerApePaterno() == null || j.getPerApePaterno().equals("")) {
							apellidos = JOptionPane.showInputDialog("Indique los Apellidos del Cliente");
							j.checkApellidos(apellidos);
						}
					}
					
					categoria = (String) JOptionPane.showInputDialog(
							   null, "Seleccione Categoria", "Sistema Banco Inter",
							   JOptionPane.QUESTION_MESSAGE, null,cat,"normal");
					switch(String.valueOf(eleccion5).charAt(0)) {
					case'1':
						n.setCliCategoria(categoria);
						break;
					case'2':
						j.setCliCategoria(categoria);
						break;
					}
				    JOptionPane.showConfirmDialog(null, myPanel, 
						    "Ingrese Fecha de Nacimiento", JOptionPane.OK_CANCEL_OPTION);
				    switch(String.valueOf(eleccion5).charAt(0)) {
					case'1':
						n.setPerFecNacimiento(year.getText()+"-"+mes.getText()+"-"+dia.getText());
						break;
					case'2':
						j.setPerFecNacimiento(year.getText()+"-"+mes.getText()+"-"+dia.getText());
						break;
					}
				    switch(String.valueOf(eleccion5).charAt(0)) {
					case'1':
						while (n.getPerNacionalidad() == null || n.getPerNacionalidad().equals("")) {
							nacionalidad = JOptionPane.showInputDialog("Indique la Nacionalidad del cliente");
							n.checkNacionalidad(nacionalidad);
						}
						break;
					case'2':
						while (j.getPerNacionalidad() == null || j.getPerNacionalidad().equals("")) {
							nacionalidad = JOptionPane.showInputDialog("Indique la Nacionalidad del cliente");
							j.checkNacionalidad(nacionalidad);
						}
						break;
					}
				    
				    while (ruteje.equals("")) {
				    	ruteje = JOptionPane.showInputDialog("Ingrese el RUT del Ejecutivo Encargado");
				      }
				    e.setPerRut(ruteje);
				    switch(String.valueOf(eleccion5).charAt(0)) {
					case'1':
						n.setEje(e);
						break;
					case'2':
						j.setEje(e);
						break;
					}
				    
				    switch(String.valueOf(eleccion5).charAt(0)) {
				      
				      case'1':
				      	p = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Patrimonio del Cliente"));
				      	
				      	n.setNatPatrimonio(p);
				    	  	naturaldao natdao = new naturaldao();
				    	  	natdao.actualizar(n);
				    	  	break;
				      case'2':
				      	r = JOptionPane.showInputDialog("Señale la razon social del Cliente");
				      	j.setJurRazSocial(r);
				      	juridicodao jur = new juridicodao();
				      	jur.actualizar(j);
				      	break;
				    }
					
					break;
				case'6':
					Object eleccion6 = JOptionPane.showInputDialog(
							   null, "Seleccione la Opcion de Cuentas", "Sistema Banco Inter",
							   JOptionPane.QUESTION_MESSAGE, null,caso6,"1.- Actualizar Cuenta");
					switch(String.valueOf(eleccion6).charAt(0)) {
					case '1':
						id = Integer.parseInt(JOptionPane.showInputDialog("Indique la ID de la cuenta"));
						saldo = Integer.parseInt(JOptionPane.showInputDialog("Indique el Saldo de la Cuenta"));
						Object sg = JOptionPane.showInputDialog(
								   null, "Indique Opcion de SobreGiro", "Sistema Banco Inter",
								   JOptionPane.QUESTION_MESSAGE, null,caso2,"0.- Sin SobreGiro");
						
						sobregiro =String.valueOf(String.valueOf(sg).charAt(0));
						estado = (String) JOptionPane.showInputDialog(
								   null, "Seleccione Estado de la Cuenta", "Sistema Banco Inter",
								   JOptionPane.QUESTION_MESSAGE, null,est,"vigente");
						cli = new cliente();
						cu = new cuenta(id,saldo,null,estado,Integer.parseInt(sobregiro),cli);
						cuedao = new cuentadao();
						cuedao.actualizar(cu);
						break;
					case'2':
						rut="";
						while (rut.equals("")) {
							rut = JOptionPane.showInputDialog("Ingrese el Rut del Cliente");
						}
						cli = new cliente();
						cli.setPerRut(rut);
						cuentas = new ArrayList<>();
						cuedao = new cuentadao();
						cu = new cuenta(cli);
						cuedao.buscar_cuentas(cu);
						for (cuenta cue1 : cuentas) {
							System.out.println(cue1.toString());
						}
						break;
					
					case'3':
						cuentas = new ArrayList<>();
						cuedao = new cuentadao();
						cuedao.listartodo();
						for (cuenta cue1 : cuentas) {
							System.out.println(cue1.toString());
						}
						break;
					case'4':
						cuentas = new ArrayList<>();
						cuedao = new cuentadao();
						cuedao.listarnaturales();
						for (cuenta cue1 : cuentas) {
							System.out.println(cue1.toString());
						}
						break;
					case'5':
						cuentas = new ArrayList<>();
						cuedao = new cuentadao();
						cuedao.listarjuridicos();
						for (cuenta cue1 : cuentas) {
							System.out.println(cue1.toString());
						}
						break;
					case'6':
						id = Integer.parseInt(JOptionPane.showInputDialog("Indique el Id de Cuenta a Bloquear"));
						cli = new cliente();
						cu = new cuenta(cli);
						cu.setCueId(id);
						cuedao = new cuentadao();
						cuedao.bloquear(cu);
						break;
					case'7':
						id = Integer.parseInt(JOptionPane.showInputDialog("Indique el Id de Cuenta a Eliminar"));
						cli = new cliente();
						cu = new cuenta(cli);
						cu.setCueId(id);
						cuedao = new cuentadao();
						cuedao.eliminar(cu);
						break;
					}
				case'7':
					id = Integer.parseInt(JOptionPane.showInputDialog("Indique el Id de la Cuenta"));
					cli = new cliente();
					cu = new cuenta(cli);
					cu.setCueId(id);
					cuedao = new cuentadao();
					cuedao.buscar(cu);
					if(cu.getCueEstado().toLowerCase().equals("vigente")) {
						if (cu.getCueSobregiro()==1) {
							saldo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Cantidad a Girar"));
							cu.setCueSaldo(cu.getCueSaldo()-saldo);
							cuedao.transaccion(cu);
						}else {
							band = 0;
							while(band == 0) {
								saldo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Cantidad a Girar, Usted no Puede Sobregirar"));
								if(cu.getCueSaldo()-saldo>=0) {
									cu.setCueSaldo(cu.getCueSaldo()-saldo);
									cuedao.transaccion(cu);
									band=1;
								}else {
									JOptionPane.showMessageDialog(null, "No Puede girar mas de su Saldo, Intentelo con otra cantidad");
									band=0;
								}
							}
						}
					}else {
						JOptionPane.showMessageDialog(null, "Cuenta Bloqueada o Inactiva, Favor de Reabrir su cuenta");
					}
					break;
				case'8':
					id = Integer.parseInt(JOptionPane.showInputDialog("Indique el Id de la Cuenta"));
					cli = new cliente();
					cu = new cuenta(cli);
					cu.setCueId(id);
					cuedao = new cuentadao();
					cuedao.buscar(cu);
					if(cu.getCueEstado().toLowerCase().equals("vigente")) {
						saldo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Cantidad a Girar"));
						cu.setCueSaldo(cu.getCueSaldo()+saldo);
						cuedao.transaccion(cu);
					}else {
						JOptionPane.showMessageDialog(null, "Cuenta Bloqueada o Inactiva, Favor de Reabrir su cuenta");
					}
					break;
				case'9':
					System.exit(0);
					break;
			}
		
		}
	}
}
