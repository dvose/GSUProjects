/*
 * Name: Dustin Vose
 * CSC3410 - Fall 2012
 * DateDue: 10-09-12  
 * Assignment:  HW3
 * File:  	CSCLinkedList.java
 * 
 * Purpose: Creates a doubly circular Linked List data structure using references to create links between Nodes.
 * The purpose of this assignment is to understand how linked list are generated and how to write methods
 * that creates interactions between references.   
 * 		
 * 
 * Solution, algorithms and data structures:   
 * 			Date Structures: Linked List, Node, Array
 * 
 *          Nodes were generated using the Node class in the Node.java file. Nodes act as containers of
 *          the elements inside the linked list. 
 *          
 *          As a result of the linked list being circular, it is hard to determine the head of
 *          the list. To resolve this problem, a special node, dummyNode, is created to keep 
 *          track of the head of the linked list. In this class, dummyNode.next refers to the
 *          head of the list.
 * 			
 *          To create links between the Nodes, specials nodes next and prev were created in the Node class.
 *          These Nodes reference the next or prev Node on the linked list. They are also used
 *          heavily when adding and removing elements from the linked list. 
 *          
 *          To add an element, the special case of the adding to the head was handled in a seperate
 *          method, addHead, to help with readability.
 *          
 *          EXTRA CREDIT: 
 *          	To create a set, the user must enter the boolean value true in the constructor's parameter.
 *          	If set == true, the add method calls the contains method to check if the element
 *          	being added to the list is already in the list. If it is, the add method returns false.
 *          	This prevents repetition from occurring.
  
 * Major classes:  Node.java is used to create the Nodes of the list, 
 * test.java is used to test the various methods of the linked list.  
 * 
 * Use, I/O expected:  
 * 			Inputs: The user is not prompted to enter input in the console. To change input, the user 
 * 			must enter different parameters in the test.java class
 * 			
 * 			Outputs: printList prints the linked list's elements to console in the appropriate order
 */
public class CSCLinkedList<E>{
	private Node<E> dummyNode = new Node<E>();//dummyNode
	private int length;
	boolean set; // checks if the linked list is a set or not. true for a set, false for not a set
	
	// PLACE CONSTRUCTOR HERE
	public CSCLinkedList(){
		length = 0;
		set = false; //not a set by default
	}//end constructor
	
	//EXTRA CREDIT 
	public CSCLinkedList(boolean i){
		length = 0;
		set = i; //checks if the linked list is a set
	}
	// Adds an element to the list at index 
	// QUESTION:  What is the point of returning a boolean when adding a nodes
	// ANSWER: If you don't return a boolean, a nullpointer exception could occur
	// Preconditions: E element needs to be given in the parameters. 
	//
	// Postconditions: Creates a new Node containing the given element and adds the Node
	// to the linked list at a given index
	
	// addHead method deals with the special case of adding to the head of the linked list
	private boolean addHead(E element){
		Node<E> newNode = new Node<E>(element);
		if(this.isEmpty()){
			dummyNode.next = newNode;
			newNode.next = newNode;
			newNode.prev = newNode;
			length++;
			return true;
		}//end if
		Node<E> oldHead = dummyNode.next;		
		// Setting up the new head!
		newNode.next = oldHead;
		newNode.prev = find(length - 1);
		//System.out.println("New node's next: " + newNode.next);//debug
		//System.out.println("New node's previous: " + newNode.prev);//debug
		oldHead.prev = newNode;
		if (oldHead.next == oldHead) {
			// oldHead IS the end of the list
			oldHead.next = newNode;
		}//end if
		dummyNode.next = newNode;
		length++;
		return true;
	}//end addHead

	//add method adds to the linked list at a given index
	public boolean add(int index, E element){
			//calls addHead if index == 0
			//EXTRA CREDIT if the linked list is a set, checks for repetition
			if(set){
				//checks if the list already contains element
				if(this.contains(element)){
					return false;
				}//end if
			}//end if
			if(index == 0){
				return this.addHead(element); 
			}//end if
			//checks if index is between 0 and the last Node in the linked list
			else if(index > 0 && index <= this.size()){
				Node<E> newNode = new Node<E>(element);
				Node<E> before = find(index-1);
				Node<E> after = before.next;
				newNode.next = after;
				newNode.prev = before;
				after.prev = newNode;
				before.next = newNode;
				length++;
				return true;
			}//end elseif
		else{
			//if the index is out of bounds, returns false
			return false;
		}
	}

	// removes the node at index and returns the contents of the node
	// Preconditions: index = the index of the Node that will be removed, needs to be within
	// the 0 and the last Node in the linked list. If not, remove will return null
	//
	// Postconditions: returns the Node that was removed from the list called removed.
	public E remove(int index){
		if(index >= 0 && index < this.size()){
			if(index == 0){
				Node<E> after = find(index + 1);
				Node<E> removed = after.prev;
				dummyNode.next = after;
				after.prev = removed.prev;
				length --;
				return removed.getElement();
			}//end if
			else {
				Node<E> before = find(index-1);
				Node<E> removed = before.next;
				removed.next.prev = before;			
				before.next = removed.next;
				length --;
				return removed.getElement();
			}//end else
		}//end if
		else
			return null;	
	}//end remove

	// returns, without removing, the element from the node at index
	public E get(int index){
		Node<E> curr = find(index);
		return curr.getElement();
	}//end get
	
	// returns, without removing, the NODE at index
	public Node<E> find(int index){
		Node<E> curr = dummyNode.next;
		for(int i = 0; i < index; i++){
				curr = curr.next;
		}//end for
		return curr;
	}//end find
	
	// returns whether or not the list contains element in its contents
	// Preconditions: Linked List cannot be empty ie contains at least 1 Node
	// Postconditions: If E element is in the linked list, match == 1 which will return true.
	public boolean contains(E element){
		if(this.size() == 0){
			return false;
		}
		else{
			Node<E> curr = dummyNode.next;
			int match = 0;
			if(curr.getElement() == element){
				match = 1;
			}//end if
			else{
				for(int i = 0; i < this.size(); i++){
					curr = curr.next;
					//System.out.println("curr: " + curr.getElement());//debug
					if(curr.getElement() == element){
						match = 1;
					}//end if
				}//end for
			}//end else
			if(match == 1){
				return true;
			}//end if
			else{
				return false;
			}//end else
		}//end else
	}//end contains

	// returns whether or not the list is empty
	// Preconditions: CSCLinkedList instance needs to be created. 
	//
	// Postconditions: returns boolean false if length == 0 else returns true.
	//
	public boolean isEmpty(){
		if(length == 0){
			return true;
		}//end if
		else{
			return false;
		}//end else
	}//end isEmpty
	
	// returns the number of elements in the list
	public int size(){
		return length;
	}//end size

	// returns an array containing the contents of the list (NOT THE NODES, THE ELEMENTS)
	// QUESTION:  Without changing the method's signature, test what occurs when you return an array
	// of the type E[] rather than Object[].  What happens and why?
	// 
	// ANSWER: The following exception is thrown, "Cannot create a generic array of E"
	// This occurs because you can not create an array of generics
	// Preconditions: Linked List should not be empty 
	//
	// Postconditions: array[] is created with the elements of the Nodes in each index
	public Object[] toArray(){  //this line is the method signature
		Node<E> curr = dummyNode.next;
		Object[] array = new Object[this.size()];
		for(int i=0; i < this.size(); i++){
			array[i] = curr.getElement();
			curr = curr.next;
		}
		return array;
	}
	
	// Prints the contents of the list.  
	// Preconditions: printList is not dependent on the amount of Nodes in the list.
	//
	// Postconditions: The elements of the Nodes in the linked list will be printed to console.
	// If the linked list is empty, "This list is empty" should print to console. curr = last node in the list
	
	public void printList(){
		if(this.isEmpty()){
			System.out.println("The list is empty");
		}//end if
		else{
			Node<E> curr = dummyNode.next;
			for(int i = 0; i < this.size(); i++){
				if(i==0){
					System.out.print(curr);
				}
				else{
					System.out.print(", " + curr);
				}
				curr = curr.next;
			}//end for
		}//end else
	}//end printList
	
	// QUESTION:  What is the simplest way to change this method so it writes the nodes in reverse order?
	// (right now it's printing the contents of the list from index 0 to n-1, how do you get it to go the other way?)
	// ANSWER: change curr.next to curr.prev
	// 
	// QUESTION:  Does using != below work in this context?  Why?
	// ANSWER: Yes, it checks to see if the curr pointer is not the same as the head.
	public void printList(Node<E> curr){
		//Precondition: curr references head, ie the dummy node, for the initial call
		//otherwise curr.next != dummyNode.next
		//Postcondition: curr.next==dummyNode.next
		if(curr.prev!=dummyNode.next){
			//Displays the contents of the node next node, then recursively prints the rest of the list
			System.out.println(curr.prev);
			printList(curr.prev);
		}//end if
	}//end printList
}//end CSCLinkeList
