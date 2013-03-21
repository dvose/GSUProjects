
public class CSCQueue<E> {
	private int size;
	private Node<E> front;
	private Node<E> back;

	public CSCQueue() {
		this.front = null;
		this.back  = null;
	}//end constructor
	
	
	/*
	 * places element in the back of the Queue
	 * Preconditions: Input is element, type E.
	 * Postconditions: the queue has one more element added. size++
	 */
	public void enqueue(E element){
		Node<E> newNode = new Node<E>(element);
		if(size == 0){
			front = newNode;
			back = front;
			//System.out.println("Enqueue: " + back.getElement());//debug
			size++;
		}//end if
		else{
		newNode.next = back;
		back = newNode;
		//System.out.println("Enqueue: "+back.getElement());//debug
		size++;
		}//end else
	}//end enqueue;
	
	/*
	 * remove the front node of the queue and return it
	 * Preconditions: queue m8st not be empty
	 * Postconditions: Returns the element that was dequeued from the queue. Removes the front
	 * 	element from the queue. size--
	 */
	public E dequeue(){
		E returnElement = front.getElement();
		Node<E> temp = back;
		//sets temp equal to the next element in the queue that's after the front
		for(int i = 0; i < size-2; i++){
			temp = temp.next;
		}//end for
		front = temp;
		size--;
		return returnElement;
	}//end dequeue
	
	/*
	 * Look at the front of the queue and return it, without removing
	 * Preconditions: the queue is not empty
	 * Postconditions: returns the front of the queue. Does not change the properties of the queue
	 */
	public E peek(){
		//System.out.println("Peek at Queue: " + front.getElement());//debug
		return front.getElement();
	}//end peek
	
	/*
	 * returns the size of the queue
	 * Preconditions: none
	 * Postconditions: returns the size of the queue, if the queue is empty, returns 0. 
	 * 	Does not change the properties of the queue.
	 */
	
	public int size(){
		return size; 
	}//end size
	/*
	 * Debug method that prints the queue
	 * Preconditions: the queue can not my empty
	 * Postconditions: prints to console the elements in the queue 
	 */
	/*public void printQueue(){
		Node<E> temp = back;
		System.out.print("Queue: " + back.getElement());
		for(int i = 1; i < size-1; i++){
			temp = temp.next;
			System.out.print(temp);
		}
		System.out.print("\n");
	}//end printQueue *///debug
}