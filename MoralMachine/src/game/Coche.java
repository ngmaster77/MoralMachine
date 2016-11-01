package game;


public class Coche
{
	private int xC;
	private int yC;
	private int nPasajeros;
	
	
	public Coche()
	{
		this.xC = 0;
		this.yC = 0;
		this.nPasajeros = 0;
	
	}
	
	public Coche(int x, int y)
	{
		this.xC = x;
		this.yC = y;
		this.nPasajeros = 0;
	}
	
	public int getxC()
	{
		return xC;
	}
	
	public int getyC()
	{
		return yC;
	}
	
	public int getnPasajeros()
	{
		return nPasajeros;
	}
	
	public void setxC(int x)
	{
		this.xC = x;
	}
	
	public void setyC(int y)
	{
		this.yC = y;
	}
	
	public void setnPasajeros(int nPasajeros)
	{
		this.nPasajeros = nPasajeros;
	}
	
	public void moveForward()
	{
		setxC(getxC()-1);
	}
	
	public void moveBack()
	{
		setxC(getxC()+1);
	}
	
	public void moveRight()
	{
		setyC(getyC()+1);
	}
	
	public void moveLeft()
	{
		setyC(getyC()-1);
	}
	
	
}