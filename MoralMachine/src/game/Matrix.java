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
	
	public Matrix()
	{
		this.m = 0;
		this.n = 0;
		this.obstaculos = 0;
		this.matrix = null;
		this.car = new Coche();
		this.conos = new Obstaculo[(int) obstaculos];
		fillMatrix(0);
		setBorde();
		setObstaculos();
		setCarPos();
	}
	
	public Matrix(int m,int n,double dificultad)
	{
		this.m = m;
		this.n = n;
		this.obstaculos = (m*n*(dificultad/100));
		this.matrix = new int[m*n];
		this.car = new Coche(1,1);
		int aux = (int)getObs();
		this.conos = new Obstaculo[aux];
		createConos();
		fillMatrix(0);
		setBorde();		
		setObstaculos();
		setCarPos();

	}
	
	public Matrix(int n, int m, double obstaculos, int xc, int yc)
	{
		this.m = m;
		this.n = n;
		this.obstaculos = (m*n*(obstaculos/100));
		this.matrix = new int[m*n];
		this.car = new Coche(xc, yc);
		int aux = (int)getObs();
		this.conos = new Obstaculo[aux];
		createConos();
		fillMatrix(0);
		setBorde();		
		setObstaculos();
		setCarPos();
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
			Random rnd = new Random();
			
			conos[i].set_x(rnd.nextInt((getN()-2) - 1 + 1) + 1);
			conos[i].set_y(rnd.nextInt((getM()-2) - 1 + 1) + 1);	
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
}