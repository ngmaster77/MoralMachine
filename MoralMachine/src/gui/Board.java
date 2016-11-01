package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Board extends JPanel { 
	

	
	private Dimension dimension_backgroundpanel;
	private JButton button_start;
	private JLabel size_matrix_label;
	private JTextField columnas;
	private JTextField filas;
	private JTextField dificultad;
	private JButton button_exit;	
	


	
	public Board(Dimension size_backgroundpanel) { 
		
		
		dimension_backgroundpanel = size_backgroundpanel;
		button_start = new JButton(); 
		button_start.setIcon(new ImageIcon("res/images/BOTON_COMENZAR72.png"));
		size_matrix_label = new JLabel();
		size_matrix_label.setIcon(new ImageIcon("res/images/BOTON_MAPA72.png"));
		button_exit = new JButton();
		button_exit.setIcon(new ImageIcon("res/images/BOTON_SALIR72.png"));
		columnas = new JTextField();
		columnas.setEnabled(true);
		columnas.setBackground(Color.GRAY);
		filas = new JTextField();
		filas.setEnabled(true);
		filas.setBackground(Color.GRAY);
		dificultad = new JTextField();
		dificultad.setEnabled(true);
		dificultad.setBackground(Color.GRAY);
		this.add_characteristics();
		this.add_components();
		this.edit_font();
		this.add_Layout(); 
		this.setVisible(true); 	
	}
	
	public void add_characteristics() { 
		
		this.setLayout(null); 
		this.setSize(new Dimension(600,300)); 
		this.setLocation(100,250);
		this.setBorder(new LineBorder(new Color(208,168,10),3));
	}
	
	public void add_components() { 
		
		this.add(button_start);
		this.add(size_matrix_label); 
		this.add(columnas); 
		this.add(filas);
		this.add(button_exit); 
		this.add(dificultad);
	}
	
	public void edit_font() { 
		
		size_matrix_label.setFont(new Font("Impact",Font.PLAIN,16));
		size_matrix_label.setForeground(Color.black);
	}
	
	public void add_Layout() { 
		
		button_start.setBounds(150,185,290,35); 
		size_matrix_label.setBounds(480,190,150,50);
		columnas.setBounds(485,240,50,20);
		filas.setBounds(485,260,50,20);
		button_exit.setBounds(150,235,290,35); 
		dificultad.setBounds(50,240,50,20);
	}
	
	
	
	@Override
	public void paint(Graphics g) { 
		
		g.drawImage(new ImageIcon("res/images/Selfdrivingcar72.png").getImage(),0,0,this.getWidth(),this.getHeight(),null); 
		this.setOpaque(false); 
		super.paint(g); 
	}
	


	public JButton getButton_start() {
		return button_start;
	}

	public void setButton_start(JButton button_start) {
		this.button_start = button_start;
	}

	public JButton getButton_exit() {
		return button_exit;
	}

	public void setButton_exit(JButton button_exit) {
		this.button_exit = button_exit;
	}

	public JTextField getColumnas() {
		
		return columnas;
	}
	
	public JTextField getFilas() {
		
		return filas;
	}
	
	public JTextField getDificultad() {
		
		return dificultad;
	}
}
