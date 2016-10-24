package algorithm;

public class Node { 

	
	private int id_x;
	private int id_y;
	private int f;
	private int g;
	private int h;
	
	private Node father;  
	private boolean obstacle;
	  

	
	public Node() { 
		
		
	    id_x = 0;
	    id_y = 0;
	    f = 0;
	    g = 0;
	    h = 0;
	}
	
	public Node(int x, int y, boolean s) { 
		
		
		set_id_x(x);
	    set_id_y(y); 
	    obstacle = s; 
	    f = 0;
	    g = 0;
	    h = 0;
	}

	
	
	public void set_id_x(int x) {
		id_x = x;
	}
	
	public void set_id_y(int y) {
		id_y = y;
	}
	
	public void set_f(int f_) {
	    f = f_;
	}
	
	public void set_g(int g_) {
	    g = g_;
	}
	
	public void set_h(int h_) {
	    h = h_;
	}
	
	public void set_father(Node pad) {
	    father = pad;
	}
	
	public void set_obstacle(boolean obs) {
	    obstacle = obs;
	}

	public int get_id_x() {
		return id_x;
	}

	public int get_id_y() {
	    return id_y;
	}

	public int get_f() {
	    return f;
	}

	public int get_g() {
	    return g;
	}

	public int get_h() {
	    return h;
	}

	public Node get_father() {
	    return father;
	}

    public boolean get_obstacle() {
	    return obstacle;
	}

	public void calculate_f() { 
	    f = g + h;
	}

	
}
