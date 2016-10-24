package game;

import java.util.Random;

public class Matrix
{
	private int m;
	private int n;
	private double obstaculos;
	private int matrix[];
	private Coche car;
	private Obstaculo conos[];
	private Persona pasajeros[];
	private Meta fin;
	private Random rnd;
	private int nObs;
	
	public Matrix()
	{
		this.m = 0;
		this.n = 0;
		this.obstaculos = 0;
		this.matrix = null;
		this.car = new Coche();
		this.conos = new Obstaculo[(int)getObs()];
		this.pasajeros = null;
		fillMatrix(0);
		setBorde();
		setObstaculos();
		setCarPos();
		setPasajeros();
	}
	
	public Matrix(int m,int n,double dificultad)
	{
		this.m = m;
		this.n = n;
		this.nObs = (int)obstaculos;
		this.obstaculos = (m*n*(dificultad/100));
		this.matrix = new int[m*n];
		this.car = new Coche(1,1);
		this.fin = new Meta(1,2);
		createObstaculos();
		createPasajeros();
		createConos();
		fillMatrix(0);
		setBorde();		
		setObstaculos();
		setCarPos();
		setMetaPos();
		setPasajeros();

	}
	
	public Matrix(int n, int m, double obstaculos, int xc, int yc)
	{
		this.m = m;
		this.n = n;
		this.nObs = (int)obstaculos;
		this.obstaculos = (m*n*(obstaculos/100));
		this.matrix = new int[m*n];
		this.car = new Coche(xc, yc);
		this.fin = new Meta(1,2);
		createObstaculos();
		createPasajeros();
		createConos();
		fillMatrix(0);
		setBorde();		
		setObstaculos();
		setCarPos();
		setMetaPos();
		setPasajeros();
	}
	
	public int getM()
	{
		return m;
	}
	
	public int getN()
	{
		return n;
	}
	
	public double getObs()
	{
		return obstaculos;
	}
	
	public int getValue(int row, int column)
	{ 
		return matrix[pos(row,column)];
	}
	
	public void setM(int m)
	{
		this.m = m;
	}
	
	public void setN(int n)
	{
		this.n = n;
	}
	
	public void setValue(int row, int column,int element)
	{ 
		matrix[pos(row,column)] = element;
	}
	
	public void setObs(int o)
	{
		this.obstaculos = (getM()*getN()*(o/100));
	}
	
	public int getnObs()
	{
		return nObs;
	}
	
	public void printMatrix()
	{
		for(int i = 0; i < getN(); i++)
		{
			for(int j = 0; j < getM(); j++)
			{
				System.out.print(matrix[pos(i,j)]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private int pos(int i, int j)
	{
		if ((i < 0) || (j < 0) || (i >= getM()) || (i >= getN()))
		{
			System.out.println("Acceso incorrecto al vector");
			return -1;
		}
		else
			return i*getN()+j;
	}
	
	public void fillMatrix(int x)
	{
		for(int i = 0; i < matrix.length; i++)
		{
			this.matrix[i] = x;
		}
	}
	
	public void setCarPos()
	{
		
		this.matrix[pos(car.getxC(),car.getyC())] = 1;
	}
	
	public void setMetaPos()
	{
		this.matrix[pos(fin.getX(),fin.getY())] = 6;
	}
	
	public void moveCar(int m)
	{
		if(m == 1)
			car.moveForward();
		if(m == 2)
			car.moveBack();
		if(m == 3)
			car.moveLeft();
		if(m == 4)
			car.moveRight();
		setCarPos();
	}
	
	public void setBorde()
	{
		for(int j = 0; j < getN(); j = j+1*getN()-1)
		{
			for(int i = 0; i < getM(); i++)
			{
				this.matrix[pos(i,j)] = 2;
			}
		}
		for(int j = 0; j < getN(); j = j+1*getN()-1)
		{
			for(int i = 0; i < getM(); i++)
			{
				this.matrix[pos(j,i)] = 2;
			}
		}
	}
	
	public void setObstaculos()
	{		
		for(int i = 0; i < conos.length; i++)
		{
			rnd = new Random();
			
			conos[i].set_x(rnd.nextInt((getN()-2) - 1 + 1) + 1);
			conos[i].set_y(rnd.nextInt((getM()-2) - 1 + 1) + 1);
			
			while(matrix[pos(conos[i].get_x(),conos[i].get_y())] != 0)
			{
				conos[i].set_x(rnd.nextInt((getN()-2) - 1 + 1) + 1);
				conos[i].set_y(rnd.nextInt((getM()-2) - 1 + 1) + 1);
			}
			
		}
		printObstaculos();
	}
	
	public void printObstaculos()
	{
		for(int i = 0; i < conos.length; i++)
		{
			int x = conos[i].get_y();
			int y = conos[i].get_x();
			matrix[pos(x,y)] = 3;
		}
	}
	
	public void createConos()
	{
		
		for(int i = 0; i < conos.length; i++)
		{
			Obstaculo cono = new Obstaculo();
			conos[i] = cono;
		}
	}
	
	public void createPasajeros()
	{
		for(int i = 0; i < pasajeros.length; i++)
		{
			rnd = new Random();
			boolean random = rnd.nextBoolean();
			Persona pasajero;
			
			if(random == true)
			{
				pasajero = new Persona(4);
			}
			else
			{
				pasajero = new Persona(5);
			}
			pasajeros[i] = pasajero;
		}
	}
	
	public void setPasajeros()
	{		
		for(int i = 0; i < pasajeros.length; i++)
		{
			Random rnd = new Random();
			
			pasajeros[i].setX(rnd.nextInt((getN()-2) - 1 + 1) + 1);
			pasajeros[i].setY(rnd.nextInt((getM()-2) - 1 + 1) + 1);	
			
			while(matrix[pos(pasajeros[i].getX(), pasajeros[i].getX())] != 0)
			{
				pasajeros[i].setX(rnd.nextInt((getN()-2) - 1 + 1) + 1);
				pasajeros[i].setX(rnd.nextInt((getM()-2) - 1 + 1) + 1);
			}
		}
		
		
		printPasajeros();
	}
	
	public void printPasajeros()
	{
		for(int i = 0; i < pasajeros.length; i++)
		{
			
			int x = pasajeros[i].getY();
			int y = pasajeros[i].getX();
			if(pasajeros[i].getId() == 4)
				matrix[pos(x,y)] = 4;
			else
				matrix[pos(x,y)] = 5;
		}
	}
	

	
	public void createObstaculos()
	{
		int setenta = (int)(getObs()*0.7);
		int treinta = (int)getObs() - setenta;
		
		System.out.println("Porcentaje: " + treinta + "," + setenta);
		
		this.conos = new Obstaculo[setenta];
		this.pasajeros = new Persona[treinta];
	}
	
	public int getConos()
	{
		int conos = 0;
		  
		for(int i = 0; i < getN(); i++)
		{
			for(int j = 0; j < getM(); j++)
			{
				
				if (this.matrix[pos(i,j)] == 3)
				{
					conos++;
				}
				
			}
		}
		
		return conos;
	}
	
	public int getChicas()
	{
		
	  int chicas = 0;
	  
		for(int i = 0; i < getN(); i++)
		{
			for(int j = 0; j < getM(); j++)
			{
				
				if (this.matrix[pos(i,j)] == 5)
				{
					chicas++;
				}
				
			}
		}
		
		return chicas;
	}
	
	public int getChicos()
	{
		
	  int chicos = 0;
	  
		for(int i = 0; i < getN(); i++)
		{
			for(int j = 0; j < getM(); j++)
			{
				
				if (this.matrix[pos(i,j)] == 4)
				{
					chicos++;
				}
				
			}
		}
		
		return chicos;
	}
	
	public double getDificultad()
	{
		return obstaculos; 
	}
	
	
}