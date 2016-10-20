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
	private JButton car;
	private JButton finish;
	private JButton reset_characters;
	private JButton reset_path;
	
public ButtonPanel() { 
		
		
		button_start = new JButton("COMENZAR"); 
		button_exit = new JButton("SALIR");
		car = new JButton();
		finish = new JButton();
		reset_characters = new JButton("Reiniciar coche");
		reset_path = new JButton("Reiniciar camino");
		
		
		this.add_characteristics();
		this.add_components();
		this.add_Layout(); 
		this.edit_components(); 
		this.setVisible(false); 	
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
		this.add(car);
		this.add(finish);
		this.add(reset_characters);
		this.add(reset_path);
	}
	
	public void add_Layout() { 
		
		button_start.setBounds(20,30,100,20); 
		button_exit.setBounds(150,30,100,20); 
		car.setBounds(300,30,20,36);
		finish.setBounds(350,30,30,22);
	}
	
public void edit_components() { 
		
		car.setIcon(new ImageIcon("res/images/coche-verde.png"));
		finish.setIcon(new ImageIcon("res/images/carrera.gif"));
		
	}
	
	@Override
	public void paint(Graphics g) { 
		
		g.drawImage(new ImageIcon("res/images/boton.png").getImage(),0,0,this.getWidth(),this.getHeight(),null); 
		this.setOpaque(false); 
		super.paint(g); 
	}
	
	public JButton getcar() {
		return car;
	}

	public void setButton_spaceman(JButton car) {
		this.car = car;
	}

	public JButton getfinish() {
		return finish;
	}

	public void setButton_objetive(JButton finish) {
		this.finish = finish;
	}



	public JButton getreset_characters() {
		return reset_characters;
	}
	
	public void setreset_characters(JButton reset_characters) {
		this.reset_characters = reset_characters;
	}

	public JButton getreset_path() {
		return reset_path;
	}

	public void setreset_path(JButton reset_path) {
		this.reset_path = reset_path;
	}

	public JButton getButton_exit() {
		return button_exit;
	}

	public void setButton_exit(JButton button_exit) {
		this.button_exit = button_exit;
	}

	
	
}