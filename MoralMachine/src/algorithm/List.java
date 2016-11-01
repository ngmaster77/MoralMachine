package algorithm;

public class List { 


	public List_Node first; 

	 
	  public List() { 

	    first = null; 
	  }

	  public void insert(Node node) { 

	  	List_Node nuevo = new List_Node(node, first); 
	    first = nuevo; 
	  }

	  public Node extract() { 
	    Node out = null;

	    if (empty() == false) { 
	      out = first.getInfo(); 
	      first = first.getNext(); 
	    }
	    
	    return out; 
	  }

	  public boolean empty() { 
	    if (first == null) {
	      return true;
	    }
	    else {
	      return false; 
	    }
	  }

	  public int lenght() {

	    int contador = 0; 
	    List_Node nodoauxiliarity = first; 
	    while(nodoauxiliarity != null) { 
	    	contador++;
	      nodoauxiliarity = nodoauxiliarity.getNext(); 
	    }

	    return contador; 
	  }

	  public void order() { 
		  
	  	List_Node actual;
	  	List_Node next; 
	  	Node auxiliarity; 
	  	actual = first; 

	  	while(actual != null) { 
	  		next = actual.getNext(); 
	  		while(next != null) { 
	  			if(actual.getInfo().get_f() > next.getInfo().get_f()) { 
	  				auxiliarity = actual.getInfo(); 
	  				actual.setInfo(next.getInfo()); 
	  				next.setInfo(auxiliarity); 
	  			}
	  		next = next.getNext(); 
	  		}
	  		actual = actual.getNext(); 
	  	}
	  }

	  public boolean find(Node nodo){ 

	  	List_Node node_actual = first; 

	  	while (node_actual != null){ 
	  		if(node_actual.getInfo().equal(nodo)) { 
	  			return true; 
	  		}
	  		else {
	  			node_actual= node_actual.getNext(); 
	  		}
	  	}
	  	return false; 
	  }
}
