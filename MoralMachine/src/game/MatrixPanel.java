package game;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MatrixPanel extends JPanel { 
	

	
	private Matrix game_board;
	private int scale_game;
	private int rows;
	private double dificultad_;

	
	public MatrixPanel(int mainpanel_size, int scale,int dificultad){
		
		dificultad_ = dificultad;
		rows = scale ;
		game_board = new Matrix(mainpanel_size,scale,dificultad_); 
		scale_game = (int) mainpanel_size *	 scale;
		
		add_characteristics(); 
		//System.out.println(game_board.get_columns());
		//System.out.println(game_board.get_rows());
		System.out.println(rows);
	}
	
	public void add_characteristics() { 
		
		this.setSize(new Dimension(600,600)); 
	}

	@Override 
	public void paint(Graphics g) { 
		
		
		final int IMAGESIZE = Math.min(this.getWidth(), this.getHeight()) / game_board.getN();
		final int IMAGESIZE2 = Math.min(this.getWidth(), this.getHeight()) / game_board.getM();
		/**
		final int IMAGESIZE = Math.min(this.getWidth(), this.getHeight()) / game_board.get_columns();
		for (int i = 0; i < game_board.get_rows(); i++)  {
			for (int j = 0; j < game_board.get_columns(); j++) {
		//g.drawImage(new ImageIcon("res/images/fondo.jpg").getImage(),0,0,1200,500,this);
				if ((i + j) % 2 == 0) {
					g.drawImage(new ImageIcon("res/images/blanca.png").getImage(), i * IMAGESIZE, j * IMAGESIZE, IMAGESIZE, IMAGESIZE,this);
				  } else {
					  g.drawImage(new ImageIcon("res/images/negra.png").getImage(), i * IMAGESIZE, j * IMAGESIZE, IMAGESIZE, IMAGESIZE,this);
				  }
			}
			
				
		}
		**/
		g.drawImage(new ImageIcon("res/images/fondo.jpg").getImage(),0,0,700,700,this);
		
		
		for (int i = 0; i < game_board.getM(); i++)  {
			for (int j = 0; j < game_board.getN(); j++) 
			{
				
				if ( game_board.getValue(i, j) == 2)
				{
					g.drawImage(new ImageIcon("res/images/2cdwbuo.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				
				if ( game_board.getValue(i, j) == 3)
				{
					g.drawImage(new ImageIcon("res/images/coni.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
					
				}
				
				if ( game_board.getValue(i, j) == 1)
				{
					g.drawImage(new ImageIcon("res/images/car-green.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				
				if ( game_board.getValue(i, j) == 4)
				{
					g.drawImage(new ImageIcon("res/images/karmele.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				
					
					
				}
			}
		
		this.setOpaque(false);
		super.paintComponent(g);
	}

	public Matrix getGame_board(){ 
		return game_board;
	}

	public void setGame_board(Matrix game_board){ 
		this.game_board = game_board;
	}

	public int getScale_game() {
		return scale_game;
	}

	public void setScale_game(int scale_game) {
		this.scale_game = scale_game;
	}

	

	
	
}