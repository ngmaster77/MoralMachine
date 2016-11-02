package game;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MatrixPanel extends JPanel { 
	

	
	private Matrix game_board;
	private int scale_game;
	private int rows;
	private double dificultad_;
	private boolean malla;

	
	public MatrixPanel(int mainpanel_size, int scale,int dificultad){
		
		String posCoche = JOptionPane.showInputDialog(null, "Introduzca posición inicial del coche. (Ej: 4,5)");
		String[] posC = posCoche.split(",");
		int xC = Integer.parseInt(posC[0]);
		int yC = Integer.parseInt(posC[1]);
		
		String posMeta = JOptionPane.showInputDialog(null, "Introduzca posición de la meta. (Ej: 4,5)");
		String[] posM = posMeta.split(",");
		int xM = Integer.parseInt(posM[0]);
		int yM = Integer.parseInt(posM[1]);
		
		dificultad_ = dificultad;
		rows = scale ;
		game_board = new Matrix(mainpanel_size,scale,dificultad_, xC, yC, xM, yM);
		scale_game = (int) mainpanel_size *	 scale;
		setMalla();
		add_characteristics(); 
		}
	
	public void add_characteristics() { 
		
		this.setSize(new Dimension(600,600)); 
	}

	@Override 
	public void paint(Graphics g) { 
		
		
		final int IMAGESIZE = Math.min(this.getWidth(), this.getHeight()) / game_board.getN();
		final int IMAGESIZE2 = Math.min(this.getWidth(), this.getHeight()) / game_board.getM();
		
		g.drawImage(new ImageIcon("res/images/fondo.jpg").getImage(),0,0,700,700,this);
		g.drawImage(new ImageIcon("res/images/fondo.jpg").getImage(),600,800,600,200,this);
		
		if(this.malla == true)
		{
			printMalla(g, IMAGESIZE, IMAGESIZE2);
			game_board.setMalla(true);
		}
		else
		{
			printNoMalla(g, IMAGESIZE, IMAGESIZE2);
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
	public void setMalla()
	{
		int malla = JOptionPane.showConfirmDialog(null, "¿Desea activar una malla para identificar mejor las casillas?");
		if(malla == 0)
		{
			this.malla = true;
		}
		else
		{
			this.malla = false;

		}
	}
	public void printNoMalla(Graphics g, int IMAGESIZE, int IMAGESIZE2)
	{
		for (int i = 0; i < game_board.getM(); i++)  {
			for (int j = 0; j < game_board.getN(); j++) 
			{
				if ( game_board.getValue(i, j) == 0)
				{
					g.drawImage(new ImageIcon("res/images/Carretera/carretera.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 1)
				{
					g.drawImage(new ImageIcon("res/images/Personajes/cocheabajo.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 2)
				{
					g.drawImage(new ImageIcon("res/images/Obstaculos/arbol.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 3)
				{
					g.drawImage(new ImageIcon("res/images/Obstaculos/cono.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);	
				}
				if ( game_board.getValue(i, j) == 4)
				{
					g.drawImage(new ImageIcon("res/images/Personajes/chico.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 5)
				{
					g.drawImage(new ImageIcon("res/images/Personajes/chica.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 6)
				{
					g.drawImage(new ImageIcon("res/images/Carretera/meta.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 7)
				{
					g.drawImage(new ImageIcon("res/images/Personajes/cochearriba.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 8)
				{
					g.drawImage(new ImageIcon("res/images/Personajes/cocheabajo.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 9)
				{
					g.drawImage(new ImageIcon("res/images/Personajes/cochederecha.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 10)
				{
					g.drawImage(new ImageIcon("res/images/Personajes/cocheizquierda.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 11)
				{
					g.drawImage(new ImageIcon("res/images/Carretera/salidaarr").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 12)
				{
					g.drawImage(new ImageIcon("res/images/Carretera/salidaaba.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 13)
				{
					g.drawImage(new ImageIcon("res/images/Carretera/salidader.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 14)
				{
					g.drawImage(new ImageIcon("res/images/Carretera/salidaizq.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 15)
				{
					g.drawImage(new ImageIcon("res/images/Carretera/vertical.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 16)
				{
					g.drawImage(new ImageIcon("res/images/Carretera/arrizq.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 17)
				{
					g.drawImage(new ImageIcon("res/images/Carretera/arrdcha.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 18)
				{
					g.drawImage(new ImageIcon("res/images/Carretera/izqaba.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 19)
				{
					g.drawImage(new ImageIcon("res/images/Carretera/abadcha.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 20)
				{
					g.drawImage(new ImageIcon("res/images/Carretera/horiozontal.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
			}
		}
	}
	public void printMalla(Graphics g, int IMAGESIZE, int IMAGESIZE2)
	{
		for (int i = 0; i < game_board.getM(); i++)  {
			for (int j = 0; j < game_board.getN(); j++) 
			{
				if ( game_board.getValue(i, j) == 0)
				{
					g.drawImage(new ImageIcon("res/images/Carretera/mcarretera.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 1)
				{
					g.drawImage(new ImageIcon("res/images/Personajes/mcocheabajo.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 2)
				{
					g.drawImage(new ImageIcon("res/images/Obstaculos/marbol.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 3)
				{
					g.drawImage(new ImageIcon("res/images/Obstaculos/mcono.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);	
				}
				if ( game_board.getValue(i, j) == 4)
				{
					g.drawImage(new ImageIcon("res/images/Personajes/mchico.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 5)
				{
					g.drawImage(new ImageIcon("res/images/Personajes/mchica.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 6)
				{
					g.drawImage(new ImageIcon("res/images/Carretera/mmeta.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 7)
				{
					g.drawImage(new ImageIcon("res/images/Personajes/mcochearriba.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 8)
				{
					g.drawImage(new ImageIcon("res/images/Personajes/mcocheabajo.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 9)
				{
					g.drawImage(new ImageIcon("res/images/Personajes/mcochederecha.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 10)
				{
					g.drawImage(new ImageIcon("res/images/Personajes/mcocheizquierda.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 11)
				{
					g.drawImage(new ImageIcon("res/images/Carretera/msalidaarr.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 12)
				{
					g.drawImage(new ImageIcon("res/images/Carretera/msalidaaba.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 13)
				{
					g.drawImage(new ImageIcon("res/images/Carretera/msalidader.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 14)
				{
					g.drawImage(new ImageIcon("res/images/Carretera/msalidaizq.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
			}
		}
	}
}