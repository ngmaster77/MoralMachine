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

public class ButtonPanel extends JPanel {

	
	private JButton button_start;
	private JButton button_exit;	
	
	
public ButtonPanel() { 
		
		
		button_start = new JButton("COMENZAR"); 
		button_exit = new JButton("SALIR");
		this.add_characteristics();
		this.add_components();
		this.add_Layout(); 
		this.setVisible(true); 	
	}

	public void add_characteristics() { 
	
	this.setLayout(null); 
	this.setSize(new Dimension(600,100)); 
	this.setLocation(0,600);
	//this.setBorder(new LineBorder(new Color(208,168,10),3));
	}
	
	public void add_components() { 
		
		this.add(button_start);
		this.add(button_exit); 
	}
	
	public void add_Layout() { 
		
		button_start.setBounds(20,30,100,20); 
		button_exit.setBounds(150,30,100,20); 
	}
	
	@Override
	public void paint(Graphics g) { 
		
		g.drawImage(new ImageIcon("res/images/boton.png").getImage(),0,0,this.getWidth(),this.getHeight(),null); 
		this.setOpaque(false); 
		super.paint(g); 
	}
}