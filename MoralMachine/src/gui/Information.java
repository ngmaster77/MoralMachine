package gui;


import javax.swing.*;
import java.awt.*;

public class Information extends JPanel {


	
	
public Information() { 
		
		
		this.add_characteristics(); 
		this.setVisible(true); 	
	}

	public void add_characteristics() { 
	
	this.setLayout(null); 
	this.setSize(new Dimension(100,800)); 
	this.setLocation(600,0);
	//this.setBorder(new LineBorder(new Color(208,168,10),3));
	this.setBackground(new Color(196,196,196));
	}
	
	
	
	
}
