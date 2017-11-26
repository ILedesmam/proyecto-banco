package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu extends JFrame implements ActionListener {

	private JButton opcion1;
	public Menu() {
		JLabel titulo=new JLabel("Menu Principal");
		this.getContentPane().add(titulo);
		this.setSize(350, 350);
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		titulo.setBounds(100, 10, 100, 15);
		this.opcion1=new JButton ("1.- Registrar Cliente");
		this.getContentPane().add(opcion1);
		opcion1.setBounds(100, 50, 150, 20);
		pack();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
