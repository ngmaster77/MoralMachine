package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Board extends JPanel { 
	

	
	private Dimension dimension_backgroundpanel;
	private JButton button_start;
	private JLabel size_matrix_label;
	private String[] sizes = {"10x10", "20x20","30x30","40x40","50x50","60x60","70x70","80x80"};
	private JComboBox<String> size_matrix_box;
	private JButton button_exit;	
	


	
	public Board(Dimension size_backgroundpanel) { 
		
		
		dimension_backgroundpanel = size_backgroundpanel;
		button_start = new JButton(); 
		 button_start.setIcon(new ImageIcon("res/images/BOTON_COMENZAR72.png"));
		size_matrix_label = new JLabel();
		size_matrix_label.setIcon(new ImageIcon("res/images/BOTON_MAPA72.png"));
		size_matrix_box = new JComboBox<String>(sizes);
		button_exit = new JButton();
		 button_exit.setIcon(new ImageIcon("res/images/BOTON_SALIR72.png"));
		
		this.add_characteristics();
		this.add_components();
		this.edit_font();
		this.add_Layout(); 
		this.setVisible(true); 	
	}
	
	public void add_characteristics() { 
		
		this.setLayout(null); 
		this.setSize(new Dimension(600,300)); 
		this.setLocation(275,200);
		//this.setLocation(((int)(dimension_backgroundpanel.getWidth()/2)-(this.getWidth()/2)),((int)(dimension_backgroundpanel.getHeight()/2)-(this.getHeight()/2))); 
		this.setBorder(new LineBorder(new Color(208,168,10),3));
	}
	
	public void add_components() { 
		
		this.add(button_start);
		this.add(size_matrix_label); 
		this.add(size_matrix_box); 
		this.add(button_exit); 
	}
	
	public void edit_font() { 
		
		size_matrix_label.setFont(new Font("Impact",Font.PLAIN,16));
		size_matrix_label.setForeground(Color.black);
		size_matrix_box.setFont(new Font("Impact",Font.PLAIN,14));
		size_matrix_box.setForeground(Color.black);
	}
	
	public void add_Layout() { 
		
		button_start.setBounds(150,185,290,35); 
		size_matrix_label.setBounds(480,205,150,50);
		size_matrix_box.setBounds(450,250,125,20); 
		button_exit.setBounds(150,235,290,35); 
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


	public JComboBox<String> getSize_matrix_box() {
		return size_matrix_box;
	}

	public void setSize_matrix_box(JComboBox<String> size_matrix_box) {
		this.size_matrix_box = size_matrix_box;
	}

	
}
