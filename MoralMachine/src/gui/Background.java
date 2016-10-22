package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Background extends JPanel { 
	

	private Dimension dimension_panel;
	private Board startpanel;
	


	public Background () { 
		
		
		dimension_panel = new Dimension(1200,1200);
		startpanel = new Board(dimension_panel);
		
		this.setLayout(null); 
		this.add_characteristic(); 
		this.add_components();
	}

	private void add_characteristic() { 

		this.setSize(dimension_panel);
		this.setBackground(Color.black);
	}
	
	private void add_components() { 
		
		this.add(startpanel); 
	}
	
	
	
	@Override
	public void paint(Graphics g) { 
		
		g.drawImage(new ImageIcon("res/images/carretera-1.jpg").getImage(),0,0,800,800,this); 
		this.setOpaque(false); 
		super.paint(g); 
	}
	
	

	public Board getStartpanel() {
		return startpanel;
	}

	public void setStartpanel(Board startpanel) {
		this.startpanel = startpanel;
	}
	
}
