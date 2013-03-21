/*
 * CSC3410 - Fall 2012
 * DateDue: 10/20  
 * Assignment:  HW4
 * File:  	PalindromeDetector.java
 * 
 * Purpose: 
 * 			The purpose of this program is to test if a word is a palindrome (a word that is spelled the same forward and backwards).
 * 			The other purpose of this project is to correctly implement the stack and queue data structures to solve this problem.
 * Solution, algorithms and data structures:   
 *          Scanners are used to get user input.
 *          Stacks and Queues are used to check if a word is a palindrome.
 * 			A stack is used to store the palindromes found.
 * 
 *      	A palindrome is a word that is spelled the same forwards and backwards. To check if a word is a palindrome,
 *      	the program first splits the string up into characters and stored each character in a stack and a queue. By comparing
 *      	the peeks of the stack and the queue, the program is essientaly comparing the first character of the word
 *      	to the last character. If they are initally the same, the program then pops the top of the stack and dequeues
 *      	the front of the queue until either the stack peek and queue peek and not the same or if the stack and queue are
 *      	empty. If the latter is the case, the word is a palindrome. 
 * 
 * 			To store the palindromes found by the program, a stack is used. This data structure is particularly good in 
 * 			this case because the instructor specifically wanted the palindromes to be printed out in the reverse order
 * 			they were found. To print, the program prints the peek of the stack, pops the stack, and then prints the new 
 * 			peek until the stack is empty.
 * 	
 * Major classes:  
 * 			CSCStack is used to create the stack instance
 * 			CSCQueue is used to create the queue instance  
 * 
 * How to use, I/O expected:  
 * 			When the program launches, it first prompts the user to enter a string to check if it is a palindrome.
 * 			Once the string is entered in, the program uses the logic stated above to check if it's a palindrome.
 * 			If the string is a palindrome, the program outputs The word is a palindrome! 
 * 			If the string is not a palindrome, the program outputs The word is not a palindrome!
 * 			The program will then prompt the user to enter in another string.
 * 			If the user enters quit, the program will terminate.
 * 			Before termination, the progam will print out the palindromes found in reverse order. 
 * 
 */


import java.util.*; //used for Scanner to get user input 
public class PalindromeDetector {
	private static Scanner s;
	
	public static void main(String[] args) {
		boolean run = true;
		CSCStack<String> palindromes = new CSCStack<String>();//used to store palindromes found
		while(run){
			CSCStack<Character> stack = new CSCStack<Character>();
			CSCQueue<Character> queue = new CSCQueue<Character>();
			s = new Scanner(System.in);
			System.out.println("Please enter a word you want to check (quit to terminate): ");
			String userInput = s.nextLine();
			
			//if quit, terminates program
			if(userInput.equals("quit")){
				run = false;
				break;
			}//end if
			boolean Palindrome = false;
			
			//for loop breaks the userinput into characters and adds them to the stack and queue
			for(int i = 0; i < userInput.length(); i++){
				stack.push(userInput.charAt(i));
				queue.enqueue(userInput.charAt(i));
			}//end for
			//queue.printQueue();//debug
			
			/*
			 * In this for loop, the program checks if the peeks of the stack and queue are the same
			 * If they are, the program pops the stack and dequeues the queue until either the stack
			 * and queue are empty or the peeks of the stack and queue are not equal. Finally,
			 * if palindrome is true, the program prints out "This word is a palindrome!"and then
			 * adds it to the palindromes stack
			 */
			for(int i = 0; i< userInput.length(); i++){
				char stackPeek = stack.peek();
				char queuePeek = queue.peek();
				if(stackPeek == queuePeek){
					stack.pop();
					queue.dequeue();
					Palindrome = true;
				}//end if
				else{
					Palindrome = false;
					break;
				}//end else
			}//end for
		
			if(Palindrome){
				System.out.println("The word is a Palindrome!");
				palindromes.push(userInput);
			}//end if
			else{
				System.out.println("The word is not a Palindrome!");
			}//end else
		}//end while
		//after the user enters quit, the program prints out the list of palindromes found
		System.out.println(palindromes.size()+" Palindromes found: ");
		for(int i = 0; i < palindromes.size(); i++){
			System.out.println(palindromes.peek());
			palindromes.pop();
		}//end for
	}//end main
}//end PalindromeDetector
