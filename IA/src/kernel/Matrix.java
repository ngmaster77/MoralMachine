package kernel;

public class Matrix
{
	private int m;
	private int n;
	private double obstaculos;
	private char matrix[];
	private Coche car;
	
	public Matrix()
	{
		this.m = 0;
		this.n = 0;
		this.obstaculos = 0;
		this.matrix = null;
		this.car = new Coche();
		fillMatrix('#');
		setCarPos();
	}
	public Matrix(int n, int m, double obstaculos, int xc, int yc)
	{
		this.m = m;
		this.n = n;
		this.obstaculos = (m*n*(obstaculos/100));
		this.matrix = new char[m*n];
		this.car = new Coche(xc, yc);
		fillMatrix('#');
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
	public void setM(int m)
	{
		this.m = m;
	}
	public void setN(int n)
	{
		this.n = n;
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
		return i*getN()+j;
	}
	public void fillMatrix(char x)
	{
		for(int i = 0; i < matrix.length; i++)
		{
			this.matrix[i] = x;
		}
	}
	public void setCarPos()
	{
		this.matrix[pos(car.getxC(),car.getyC())] = '·';
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
}
