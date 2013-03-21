/* Updated 11/2
 * 
 * RULES
 * A node is either red or black.
 * A node is red by default.
 * The left and right children are null by default. 
 * Null Children are considered black nodes
 * It may help you to make a Sentinel nodes (like the dummy nodes in assignment 3) to act as the null children.
 * 
 * 
 * I've included some other very useful functions for you.
 * This class is fully programmed and ready to go; you don't have to change anything
 * 
 * 
 */
public class Node<E extends Comparable<? super E>> {
	private E element;
	private Node<E> left;
	private Node<E> right;
	private Node<E> parent;
	public boolean isRed;
	
	
	// Constructs a node
	// All nodes start red
	public Node(E element) {
		super();
		this.element = element;
		isRed = true;
	}
	public Node(){
		super();
		this.element = null;
		isRed = false;
	}
	
	/*
	 * COLOR METHODS
	 * These methods are to check the color of the node and change it
	 */
	
	
	public boolean isBlack(){
		return !isRed();
	}
	
	public boolean isRed() {
		return isRed;
	}
	
	
	public void setRed(){
		isRed=true;
	}
	
	public void setBlack(){
		isRed=false;
	}
	
	
	/*
	 * HELPER METHODS
	 */
	
	public Node<E> getSibling() {
		if(this.parent != null) {
			if(this.parent.getLeft()==this) { //== because we are checking for same object, for once
				return parent.getRight();
			} else {
				return parent.getLeft();
			}
		} else {
			return null;
		}
		
	}
	
	public Node<E> getGrandparent(){
		if(this.parent != null){
			return parent.getParent();
		} else {
			return null;
		}
	}
	
	
	// Gets my uncle
	// IF no grandparent, return null
	// If my parent is my grandparent's left child, return right
	// Otherwise return left
	/* gets u, the uncle
	 * 
	 *      g
	 *     / \
	 *    p   u
	 *   /
	 *  this
	 */
	public Node<E> getUncle() {
		Node<E> grandpa = this.getGrandparent();
		if(grandpa == null){
			return null;
		} else {
			return parent.getSibling();
		}
		
		
	}
	
	
	public boolean isLeaf(){
		return (left == null && right == null);
	}
	
	public boolean hasLeft() {
		return left != null;
	}
	public boolean hasRight() {
		return right != null;
	}
	
	
	
	//GETTERS AND SETTERS
	//UNINTERESTING, BUT USEFUL
	public Node<E> getLeft() {
		return left;
	}
	
	public void setLeft(Node<E> left) {
		this.left = left;
	}
	
	public Node<E> getRight() {
		return right;
	}
	
	public void setRight(Node<E> right) {
		this.right = right;
	}
	
	public Node<E> getParent() {
		return parent;
	}
	
	public void setParent(Node<E> parent) {
		this.parent = parent;
	}
	
	public void setElement(E e){
		element = e;
	}
	public E getElement() {
		return element;
	}


}