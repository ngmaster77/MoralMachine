package game;

public class Persona {

	private int x;
	private int y;
	private int id;
	
	public Persona(){
		this.x = 0;
		this.y = 0;
		this.id = 4;
	}
	
	public Persona(int x,int y){
		this.x = x;
		this.y = y;
		this.id = 4;
	}
	public Persona(int x,int y, int id){
		this.x = x;
		this.y = y;
		this.id = id;
	}
	public Persona(int id){
		this.x = 0;
		this.y = 0;
		this.id = id;
	}
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public int getId(){
		return this.id;
	}	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	public void setId(int id){
		this.id = id;
	}
	public void printInfo()
	{
		//System.out.println("x:" + getX() + " y: " + getY());
	}
}
