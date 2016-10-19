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

public class Information extends JPanel {


	
	
public Information() { 
		
		
		this.add_characteristics(); 
		this.setVisible(true); 	
	}

	public void add_characteristics() { 
	
	this.setLayout(null); 
	this.setSize(new Dimension(300,1200)); 
	this.setLocation(700,0);
	//this.setBorder(new LineBorder(new Color(208,168,10),3));
	}
	
	
	
	@Override
	public void paint(Graphics g) { 
		
		g.drawImage(new ImageIcon("res/images/boton.png").getImage(),0,0,this.getWidth(),this.getHeight(),null); 
		this.setOpaque(false); 
		super.paint(g); 
	}
}
