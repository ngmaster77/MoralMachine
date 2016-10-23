package main;

import gui.Background; 
import gui.Board;
import game.MatrixPanel;
import gui.Information;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.lang.*;


public class GameController extends JFrame implements ActionListener, MouseListener 
{
	private JPanel mainpanel;
 
	private Background backgroundstartpanel; 
	private MatrixPanel matrixpanel;
	private Information information;
	private int button_selection; 
	private boolean car_selected; 
	private boolean finish_selected; 
	private boolean checkbox_path_checked;

public GameController() {
		
		
		mainpanel = new JPanel(); 
		backgroundstartpanel = new Background(); 	
		button_selection = 0; 
		checkbox_path_checked = false; 
		finish_selected = false;
		car_selected = false;
		information = new Information();
		this.add_characteristics(); 
		this.add_components(); 
		this.addActionListener(); 
		addMouseListener(this); 
		this.setVisible(true); 
		
	}

	public void add_characteristics() { 
		
		this.setLayout(null); 
		this.setTitle("Moral Machine"); 
		this.setSize(new Dimension(800,800)); 
		this.setResizable(false);
		this.setLocationRelativeTo(null); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

		
		mainpanel.setSize(new Dimension(this.getWidth(),(this.getHeight() ) ) ); 
		mainpanel.setLocation(0,0);
		mainpanel.setVisible(false); 
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(mainpanel); 
		
	}
	
	public void add_components() { 
		
		

		this.add(mainpanel); 
		this.add(backgroundstartpanel); 
		this.add(information);
		
	}
	
	private void initialize_matrix_panel() { 
		
		int a = Integer.parseInt(backgroundstartpanel.getStartpanel().getColumnas().getText());
		int b = Integer.parseInt(backgroundstartpanel.getStartpanel().getFilas().getText());
		int c =  Integer.parseInt(backgroundstartpanel.getStartpanel().getDificultad().getText());
		
		
		
		matrixpanel = new MatrixPanel(a,b,c); 
		this.add(matrixpanel); 
		this.setSize(new Dimension(800,622)); 
		//information.setMatrixInfo(matrixpanel.getGame_board());

	}
	
public void addActionListener() { 
	
		backgroundstartpanel.getStartpanel().getButton_start().addActionListener(this); 
		backgroundstartpanel.getStartpanel().getButton_exit().addActionListener(this); 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { 
		
		
		if(e.getSource() == backgroundstartpanel.getStartpanel().getButton_start()) {
			backgroundstartpanel.setVisible(false); 
			this.initialize_matrix_panel(); 
			matrixpanel.getGame_board();
			matrixpanel.repaint();

		}
		if(e.getSource() == backgroundstartpanel.getStartpanel().getButton_exit()) { 
			System.exit(0); 
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {  
		int scale = 70;
		int coordenada_x = e.getX(); 
		int coordenada_y = e.getY(); 
		int position_x = (int)(coordenada_x/scale);
		int position_y = (int)(coordenada_y/scale);
		/**
		if((this.getButton_selection() == 1) && 
		   (this.car_selected == false)) {
		   //(matrixpanel.getGame_board().getValue(position_y, position_x) > 3) &&
		   //(matrixpanel.getGame_board().getValue(position_y, position_x) < 80)) { 
			matrixpanel.getGame_board().setValue(position_y,position_x,80); 
			this.car_selected = true;
		}
		
		**/
		if((this.getButton_selection() == 2) && 
		   (this.car_selected == false) &&
		   (matrixpanel.getGame_board().getValue(position_y, position_x) > 3) &&
		   (matrixpanel.getGame_board().getValue(position_y, position_x) < 80)) { 
			matrixpanel.getGame_board().setValue(position_y,position_x,100); 
			this.finish_selected = true; 
		}
		matrixpanel.repaint(); // Nueva llamada al método paint.
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {} 
	@Override
	public void mouseReleased(MouseEvent e) {} 
	@Override
	public void mouseEntered(MouseEvent e) {} 
	@Override
	public void mouseExited(MouseEvent e) {}

	
	
	public MatrixPanel getMatrixpanel() {
		return matrixpanel;
	}

	public void setMatrixpanel(MatrixPanel matrixpanel) {
		this.matrixpanel = matrixpanel;
	}

	public int getButton_selection() {
		return button_selection;
	}

	public void setButton_selection(int button_selection) {
		this.button_selection = button_selection;
	}
	

	
	
	
}