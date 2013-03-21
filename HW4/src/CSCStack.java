public class CSCStack<E> {
	private int size;
	private Node<E> top;

	public CSCStack() {
		this.top =null;
	}//end constructor
	
	/*
	 * places element on the top of the stack
	 * Preconditions: element is inputed. Type E.
	 * Postconditions: the stack has one more element added. size++
	 */
	public void push(E element){
		Node<E> newNode = new Node<E>(element);
		newNode.next = top;
		top = newNode;	
		//System.out.println("Push at Stack: " + top.getElement());//debug
		size++;
	}//end push
	
	/*
	 * remove the top node and return its contents
	 * Preconditions: 
	 * Postconditions: Returns the element that was popped from the stack. Removes the top
	 * 	element from the queue. The new top is top.next. size--
	 */
	public E pop(){
		E returnElement = top.getElement();
		top = top.next;
		return returnElement;
	}//end pop
	
	/*
	 * Look at the top element of the Stack and return it, without removing
	 * Preconditions: none
	 * Postconditions: returns the top of the stack. 
	 * 	Does not change the properties of the stack.
	 */
	public E peek(){
		//System.out.println("Peek at Stack: " + top.getElement());//debug
		return top.getElement();
	}//end peek
	
	/* returns the size of the stack
	 * Preconditions: none
	 * Postconditions: returns the top of the stack, if the stack is empty, returns 0. 
	 * 	Does not change the properties of the stack.
	 */
	public int size(){
		return size;  
	}//end size
	

}//end CSCStack