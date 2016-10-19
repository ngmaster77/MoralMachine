package game;

public class Coche {
	
	private int x;
	private int y;
	private int pasajeros;
	
	public Coche(){
		this.x = 0;
		this.y = 0;
		pasajeros = 0;
	}
	
	public Coche(int x,int y,int pasajeros){
		this.x = x;
		this.y = y;
		this.pasajeros = pasajeros;
	}
	
	public int get_x(){
		return this.x;
	}
	
	public int get_y(){
		return this.y;
	}
	
	public int get_pasajeros(){
		return this.pasajeros;
	}
	
	public void set_x(int x){
		this.x = x;
	}
	
	public void set_y(int y){
		this.y = y;
	}
	
	public void set_pasajeros(int pasajeros){
		this.pasajeros = pasajeros;
	}
	
}
