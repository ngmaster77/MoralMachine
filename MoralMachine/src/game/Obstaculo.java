package game;

public class Obstaculo {

	private int x;
	private int y;
	
	public Obstaculo(){
		this.x = 0;
		this.y = 0;
	}
	
	public Obstaculo(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public int get_x(){
		return this.x;
	}
	
	public int get_y(){
		return this.y;
	}
	
	public void set_x(int x){
		this.x = x;
	}
	
	public void set_y(int y){
		this.y = y;
	}
	public void printInfo()
	{
		//System.out.println("x:" + get_x() + " y: " + get_y());
	}
}
