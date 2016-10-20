package main;

import gui.Background; 
import game.MatrixPanel;
import gui.ButtonPanel;
import gui.Information;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


public class GameController extends JFrame implements ActionListener, MouseListener 
{
	private JPanel mainpanel;
 
	private Background backgroundstartpanel; 
	private MatrixPanel matrixpanel;
	private ButtonPanel botonpanel;
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
		botonpanel = new ButtonPanel();
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
		this.setSize(new Dimension(700,700)); 
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
		this.add(botonpanel);
		this.add(information);
		
	}
	
	private void initialize_matrix_panel() { 
		
		int scale = (int) (((backgroundstartpanel.getStartpanel().getSize_matrix_box().getSelectedIndex()) + 1) * 10); 

		matrixpanel = new MatrixPanel(mainpanel.getWidth(), scale); 
		this.add(matrixpanel); 
	}
	
public void addActionListener() { 
	
		botonpanel.getcar().addActionListener(this); 
		botonpanel.getfinish().addActionListener(this);
		botonpanel.getreset_characters().addActionListener(this); 
		botonpanel.getreset_path().addActionListener(this);
		botonpanel.getButton_exit().addActionListener(this); 
		backgroundstartpanel.getStartpanel().getButton_start().addActionListener(this); 
		backgroundstartpanel.getStartpanel().getButton_exit().addActionListener(this); 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { 
		if(e.getSource() == botonpanel.getcar()) { 
			this.button_selection = 1; 
		}
		if(e.getSource() == botonpanel.getfinish()) { 
			this.button_selection = 2; 
		}
	
		if(e.getSource() == botonpanel.getreset_characters()) { 
			this.button_selection = 0; 
			this.car_selected = false;
			this.finish_selected = false; 
			//matrixpanel.getGame_board().reset_characters(); 
			matrixpanel.repaint(); 
		}
		if(e.getSource() == botonpanel.getreset_path()) {
			checkbox_path_checked = false;
			//matrixpanel.getGame_board().reset_path();
			//matrixpanel.getGame_board().set_value(minimum_path.getOrigin_x(),minimum_path.getOrigin_y(),80);
			//matrixpanel.getGame_board().set_value(minimum_path.getDestiny_x(),minimum_path.getDestiny_y(),100);
			matrixpanel.repaint();
		}
		
		if(e.getSource() == botonpanel.getButton_exit()) { 
			new GameController(); 
		}
		
		if(e.getSource() == backgroundstartpanel.getStartpanel().getButton_start()) {
			backgroundstartpanel.setVisible(false); 
			botonpanel.setVisible(true);
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
		int scale = matrixpanel.getScale_game(); 
		int coordenada_x = e.getX(); 
		int coordenada_y = e.getY(); 
		int position_x = (int)(coordenada_x/scale);
		int position_y = (int)(coordenada_y/scale);
		
		if((this.getButton_selection() == 1) && 
		   (this.car_selected == false) &&
		   (matrixpanel.getGame_board().get_value(position_y, position_x) > 3) &&
		   (matrixpanel.getGame_board().get_value(position_y, position_x) < 80)) { 
			matrixpanel.getGame_board().set_value(position_y,position_x,80); 
			this.car_selected = true;
		}
		if((this.getButton_selection() == 2) && 
		   (this.car_selected == false) &&
		   (matrixpanel.getGame_board().get_value(position_y, position_x) > 3) &&
		   (matrixpanel.getGame_board().get_value(position_y, position_x) < 80)) { 
			matrixpanel.getGame_board().set_value(position_y,position_x,100); 
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