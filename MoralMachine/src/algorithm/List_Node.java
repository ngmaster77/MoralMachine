package algorithm;

public class List_Node { 


	  private Node info; 
	  private List_Node next;


	  
	  public List_Node() { 
	    next = null;
	  }

	  public List_Node(Node nodo, List_Node n) {
	    info = nodo;
	    setNext(n);
	  }
	  
	  
	  public void setNext(List_Node n) { 
	    next = n;
	  }

	  public List_Node getNext() {
	    return next;
	  }

	  public void setInfo(Node i) { 
	    info = i;
	  }
	  
	  public Node getInfo() { 
	    return info;
	  }
}
