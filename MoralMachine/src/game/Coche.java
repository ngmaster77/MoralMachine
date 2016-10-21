package game;

public class Coche
{
	private int xC;
	private int yC;
	
	public Coche()
	{
		this.xC = 0;
		this.yC = 0;
	}
	public Coche(int x, int y)
	{
		this.xC = x;
		this.yC = y;
	}
	public int getxC()
	{
		return xC;
	}
	public int getyC()
	{
		return yC;
	}
	public void setxC(int x)
	{
		this.xC = x;
	}
	public void setyC(int y)
	{
		this.yC = y;
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