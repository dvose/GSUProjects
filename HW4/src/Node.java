/**
 * 
 * @author: Andrew Rosen
 *  
 */
public class Node<E> {
	private E element;
	public Node<E> next;
	
	
	//Constructor
	public Node(E element){
		this.element = element;
	} 
	
	
	public E getElement() {
		return element;
	}


	public void setElement(E element) {
		this.element = element;
	}


	//Returns a string representation of element
	public String toString(){
		return element.toString();	
	}
	
	//Nodes are equal if their elements are equal
	public boolean equals(Node<E> n){
		return element.equals(n.getElement());
	}

}