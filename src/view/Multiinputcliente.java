package view;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.cliente;
import model.ejecutivo;
import model.juridico;
import model.natural;
import modeldao.juridicodao;
import modeldao.naturaldao;

public class Multiinputcliente {
	public Multiinputcliente() {
		Object [] caso1 = new Object[] {"1.- Cliente Natural", 
		"2.- Cliente Juridico"};
		Integer p;
		String r;
		int bandera = 1;
		
		Object eleccion1 = JOptionPane.showInputDialog(
				   null, "Seleccione el Tipo de Cliente a Ingresar", "Sistema Banco Inter",
				   JOptionPane.QUESTION_MESSAGE, null,caso1,"1.- Cliente Natural");
		
	      JTextField cliRUT = new JTextField(13);
	      JTextField cliNombre = new JTextField(14);
	      JTextField cliApellidoP = new JTextField(20);
	      JTextField cliApellidoM = new JTextField(20);
	      JTextField cliCategoria = new JTextField(6);
	      
	      JPanel myPanel = new JPanel();
	      myPanel.add(new JLabel("RUT:"));
	      myPanel.add(cliRUT);
	      myPanel.add(Box.createVerticalStrut(10));
	      myPanel.add(new JLabel("NOMBRE:"));
	      myPanel.add(cliNombre);
	      myPanel.add(Box.createVerticalStrut(10));
	      myPanel.add(new JLabel("Apellido P:"));
	      myPanel.add(cliApellidoP);
	      myPanel.add(Box.createVerticalStrut(10));
	      myPanel.add(new JLabel("Apellido M:"));
	      myPanel.add(cliApellidoM);
	      myPanel.add(Box.createHorizontalStrut(15));
	      myPanel.add(new JLabel("Categoria:"));
	      myPanel.add(cliCategoria);
	      
	      ejecutivo e = new ejecutivo();
	      Integer nomInt;
	      char nomChar;
	      String nomPersona ="";
		while (nomPersona .equals("")) {
	    	  for (int i = 0; i < nomPersona.length(); i++) {
	    		  nomChar = String.valueOf(nomPersona).charAt(i);
	    		  nomInt = (int)nomChar;
	    		  if(nomInt<65 || nomInt>122) {
	    			  nomPersona="";
	    			  break;
	    		  }
	    	  }
	      }
	      switch(String.valueOf(eleccion1).charAt(0)) {
	      
	      case'1':
	    	while(bandera == 1) {
	    		JOptionPane.showConfirmDialog(null, myPanel, 
		    "Ingrese los Datos Principales", JOptionPane.OK_CANCEL_OPTION);
	    		
	    		
	    	}
	      	
	      	p = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Patrimonio del Cliente"));
	      
	      	natural n = new natural(cliRUT.getText(),
	    		cliNombre.getText(),
	    		cliApellidoP.getText(),
	    		cliApellidoM.getText(),
	    		null,
	    		null,
	    		cliCategoria.getText(),
	    		e,
	    		p);
	    	  	naturaldao natdao = new naturaldao();
	    	  	natdao.ingresar(n);
	    	  	break;
	      case'2':
	      	JOptionPane.showConfirmDialog(null, myPanel, 
		    "Ingrese los Datos Principales", JOptionPane.OK_CANCEL_OPTION);
	      	r = JOptionPane.showInputDialog("Señale la razon social del CLiente");
	      	juridico j = new juridico(cliRUT.getText(),
	    	cliNombre.getText(),
	    	cliApellidoP.getText(),
	    	cliApellidoM.getText(),
	    	null,null,
	    	cliCategoria.getText(),
	    	e,
	    	r);
	      	juridicodao jur = new juridicodao();
	      	jur.ingresar(j);
	      	break;
	      	
	      	}
	   }
}
