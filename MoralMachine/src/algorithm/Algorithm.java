package algorithm;
import game.Matrix;

public class Algorithm { 


	
	private List list_open; 
	private List list_close;
	private List list_final;
	private Matrix dashboard;

	private int origin_x; 
	private int origin_y; 
	private int destiny_x;  
	private int destiny_y; 
	
	private boolean fin; 
	private int value_g; 



	public Algorithm(Matrix game_board) {

		
		list_open = new List();
		list_close = new List();
		list_final = new List();
		dashboard = game_board; 

		for (int i = 0; i < dashboard.getM(); i++) {
			for (int j = 0; j < dashboard.getN(); j++) {
				if(dashboard.getValue(i,j) == 1) { 
					origin_x = i; 
					origin_y = j; 
				}
				if(dashboard.getValue(i,j) == 6) { 
					destiny_x = i; 
					destiny_y = j;
				}	
			}
		}
		value_g = 0; 
		fin = false; 
	}

	public void try_node(int i, int j, boolean direction, Node father) { 
		if(fin == false) { // CONDICIÓN: Si no se ha llegado al final.
			if(dashboard.getValue(i,j) == 1) { 
				fin = true;
				return;
			}
			if((dashboard.getValue(i,j) == 3) || (dashboard.getValue(i,j) == 2)) { 
				return;
			}

			Node node = new Node(i,j,false); 

			if(list_close.find(node)) { 
				return;
			}
			
			node.set_father(father);

			
	
			int i_manhattan = 0; 
			int j_manhattan = 0; 
			
			if(i > destiny_x) { 
				i_manhattan = i - destiny_x;
			}
			else {
				i_manhattan = destiny_x - i;
			}
			if(j > destiny_y) { 
				j_manhattan= j - destiny_y;
			}
			else {
				j_manhattan= destiny_y - j;
			}
			
			node.set_h((i_manhattan + j_manhattan)*10); 

			
			if(direction == false) { 
				node.set_g(value_g + 10);
			}
			else {
				node.set_g(value_g + 14);
			}
			
			
			node.calculate_f();

			
			if(list_open.find(node) == true) { 
				boolean found = false; 
				List_Node node_actual = list_open.first;
			  	while (found != true) { 
			  		if(node_actual.getInfo().equal(node)) {
			  			found = true;
			  		}
			  		else {
			  			node_actual = node_actual.getNext();
			  		}
		  		}
		  		
		  		if(node_actual.getInfo().get_g() > node.get_g()) {
		  			node_actual.getInfo().set_g(node.get_g());
		  			node_actual.getInfo().set_father(father);
		  			node_actual.getInfo().calculate_f();
		  		}
			} 
			else { 
				list_open.insert(node);
			}
		}
	}

	public List beggining() { 

		Node origin = new Node(origin_x,origin_y,false);
		Node intermediate = null;
		list_open.insert(origin);

		while(fin != true) { 
			
			if(list_open.empty() == true) { 
				fin = true;
				return null;
			}
			intermediate = list_open.extract();
			list_close.insert(intermediate);
			value_g = intermediate.get_g();
			
			
			int i = intermediate.get_id_x();
			int j = intermediate.get_id_y();
			
			
			if((i != 0) && (j != 0) && (i != dashboard.getM() - 1) && (j != dashboard.getN() - 1)) { 
				try_node(i,j+1,false,intermediate); 
				try_node(i+1,j,false,intermediate); 
				try_node(i,j-1,false,intermediate);
				try_node(i-1,j,false,intermediate); 
			}
			else if(i == 0) { 
				if(j == 0) { 
					try_node(i+1,j,false,intermediate); 
					try_node(i,j+1,false,intermediate); 
				}
				else if(j == dashboard.getN() - 1) {
					try_node(i,j-1,false,intermediate); 
					try_node(i+1,j,false,intermediate); 
					
				}
				else{ 
					try_node(i+1,j,false,intermediate); 
					try_node(i,j-1,false,intermediate);
					try_node(i,j+1,false,intermediate); 
				}
			}
			else if(i == dashboard.getM() - 1) { 
				if(j == 0) { 
					try_node(i,j+1,false,intermediate); 
					try_node(i-1,j,false,intermediate);
				}
				else if(j == dashboard.getN() - 1) { 
					try_node(i,j-1,false,intermediate);
					try_node(i-1,j,true,intermediate); 
					try_node(i-1,j-1,true,intermediate);
				}
				else{
					try_node(i,j+1,false,intermediate); 
					try_node(i,j-1,false,intermediate);
					try_node(i-1,j,false,intermediate); 
			
				}
			}
			else if(j == 0) { 
				try_node(i-1,j,false,intermediate); 
				try_node(i+1,j,false,intermediate); 
				try_node(i,j+1,false,intermediate); 

			}
			else if(j == dashboard.getM() - 1) { 
				try_node(i,j-1,false,intermediate); 
				try_node(i+1,j,false,intermediate); 
				try_node(i-1,j,false,intermediate); 
			}

			list_open.order(); 
		}

		while(intermediate.get_father() != null) { 
			list_final.insert(intermediate);
			intermediate = intermediate.get_father();
		}
		return list_final;
	}
	


	public int getOrigin_x() {
		return origin_x;
	}

	public void setOrigin_x(int origin_x) {
		this.origin_x = origin_x;
	}

	public int getOrigin_y() {
		return origin_y;
	}

	public void setOrigin_y(int origin_y) {
		this.origin_y = origin_y;
	}

	public int getDestiny_x() {
		return destiny_x;
	}

	public void setDestiny_x(int destiny_x) {
		this.destiny_x = destiny_x;
	}

	public int getDestiny_y() {
		return destiny_y;
	}

	public void setDestiny_y(int destiny_y) {
		this.destiny_y = destiny_y;
	}
}