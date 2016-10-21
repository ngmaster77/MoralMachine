package game;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MatrixPanel extends JPanel { 
	

	
	private Matrix game_board;
	private int scale_game;
	private int rows;
	private int dificultad_;

	
	public MatrixPanel(int mainpanel_size, int scale){
		
		
		rows = scale ;
		game_board = new Matrix(mainpanel_size,scale); 
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
		
		
		final int IMAGESIZE = Math.min(this.getWidth(), this.getHeight()) / game_board.get_columns();
		final int IMAGESIZE2 = Math.min(this.getWidth(), this.getHeight()) / game_board.get_rows();
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
		
		
		for (int i = 0; i < game_board.get_rows(); i++)  {
			g.drawImage(new ImageIcon("res/images/2cdwbuo.png").getImage(),0 * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
			g.drawImage(new ImageIcon("res/images/2cdwbuo.png").getImage(),(game_board.get_columns()-1) * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
			
		}
		
		
		
		for (int j = 0; j < game_board.get_columns(); j++) {
			
			g.drawImage(new ImageIcon("res/images/2cdwbuo.png").getImage(),j * IMAGESIZE, 0 * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
			g.drawImage(new ImageIcon("res/images/2cdwbuo.png").getImage(),j * IMAGESIZE, (rows-1)  * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);

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