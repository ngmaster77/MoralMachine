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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GameController extends JFrame implements ActionListener, MouseListener 
{
	private JPanel mainpanel;
 
	private Background backgroundstartpanel; 
	private MatrixPanel matrixpanel;
	private ButtonPanel botonpanel;
	private Information information;
	private int button_selection; 
	private boolean checkbox_path_checked;

public GameController() {
		
		
		mainpanel = new JPanel(); 
		backgroundstartpanel = new Background(); 	
		button_selection = 0; 
		checkbox_path_checked = false; 
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
