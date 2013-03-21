/*
 * Name: Dustin Vose
 * CSC3410 - Fall 2012
 * DateDue: 10-09-12  
 * Assignment:  HW3
 * File:  	test.java
 * 
 * Purpose: 
 * 			Checks to see if the various methods in CSCLinkedList are working properly. 
 * 			test.java creates a sample linked list prints the following for each method:
 * 				the precondition of the linked list before the method is called 
 * 				the name of the method and the parameters being used
 * 				the return value of the method
 * 				the postcondition of the linked list after the method ran
 *   
 * Solution, algorithms and data structures:   
 *          All Solutions and algorithms are handled within the CSCLinkedList class. 
 *          Data Structures used: linked lists, arrays
 * Major classes: 
 * 			Node.java is used to create the Nodes of the list, 
 * 			CSCLinkedLis.java is used to create the linked list data structure.  
 * 
 * Use, I/O expected:  
 * 			Inputs: The user is not prompted to enter input in the console. To change input, the user 
 * 			must enter different parameters in the test.java class
 * 			
 * 			Outputs: prints the following to console for each method in the CSCLinkedList class:
 * 				the precondition of the linked list before the method is called 
 * 				the name of the method and the parameters being used
 * 				the return value of the method
 * 				the postcondition of the linked list after the method ran 
 */
import java.util.Arrays;
public class test {

	public static void main(String[] args) {
		CSCLinkedList<String> linkedList = new CSCLinkedList<String>();
		linkedList.printList();
		System.out.println("isEmpty(): " + linkedList.isEmpty());
		
		//add test
		System.out.println("\nAdd Test:");
		linkedList.printList();
		System.out.print("add(0, 'element 0'): " + linkedList.add(0, "element 0") + "\n"); 
		linkedList.printList();
		System.out.print("\nadd(1, 'element 1'): " + linkedList.add(1, "element 1") + "\n");
		linkedList.printList();
		System.out.print("\nadd(2, 'element 2'): " + linkedList.add(2, "element 2") + "\n"); 
		linkedList.printList();
		System.out.print("\nadd(1, 'new element 1'): " + linkedList.add(1, "new element 1") + "\n"); 
		linkedList.printList(); 
		System.out.println();
		System.out.print("add(9000, 'OVER 9000!!!!'): " + linkedList.add(9000, "OVER 9000!!!") + "\n");
		
		//printList test
		System.out.print("\nprintList(): ");
		linkedList.printList();
		
		//find test
		System.out.println("\nfind(3): " +linkedList.find(3));
		
		//toArray test
		System.out.println("toArray(): " + Arrays.toString(linkedList.toArray()));
		
		//contains test
		System.out.println("contains('element 1'): " + linkedList.contains("element 1"));
		
		System.out.println("\nRemove Test:");
		System.out.println("remove(0): " + linkedList.remove(0));
		linkedList.printList();
		System.out.println("\nremove(9000): " + linkedList.remove(9000));
		
		//set test
		System.out.println("\nSet test: ");
		CSCLinkedList<Integer> linkedListSet = new CSCLinkedList<Integer>(true); //set = true in constructor
		linkedListSet.printList();
		System.out.println("add(0,1): " + linkedListSet.add(0,1));
		linkedListSet.printList();
		System.out.println("\nadd(1,2): " + linkedListSet.add(1,2));
		linkedListSet.printList();
		System.out.println("\nadd(2,1): " + linkedListSet.add(2,1));
		linkedListSet.printList();
		System.out.println("\nadd(2,3): " + linkedListSet.add(2,3));
		linkedListSet.printList();
		
	}
	
}
