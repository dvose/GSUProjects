/**
 * 
 * @author: Andrew Rosen
 *  
 */
public class Node<E> {
	private E element;
	public Node<E> next;
	public Node<E> prev;
	
	//Constructor
	public Node()
	{
		element = null;
	}	
	public Node(E element){
		this.element = element;
	} 
	public E getElement() {
		return element;
	}
	public void setElement(E element) {
		this.element = element;
	}
	public void setNext(Node<E> n){
		this.next = n;
	}
	public E getNext(){
		return next.getElement();
	}
	public void setPrev(Node<E> n) {
		this.prev = n;
	}
	public E getPrev(){
		return prev.getElement();
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