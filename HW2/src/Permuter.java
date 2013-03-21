/* Name: Dustin Vose
 * CSC3410 - Fall 2012
 * DateDue: September 22, 6AM
 * Assignment: Assignment 2
 * File:  	Permuter.java (main method in Permutation.java)
 * 
 * Purpose: 
 * 			Generates the permutations of a string.
 * 			Uses a recursion approach to generate permutations. 
 * 
 * Solution, algorithms and data structures:   
 * 	The permutations are generated  individually by recursing the method perm with every character in the given string
 * 	To check if a single instance of permutation is done, an if statement is used:	
 * 		If remainder.lengeth() <= 1:  
 * 			If true, the program will go up one level of recursion, if it is at the final level of recursion, then the 
 * 				permutations were generated successfully. 
 * 			If false, the for loop will trigger and the program will go down one level in recursion
 *  To recurse through every character in string, a for loop is needed. This for loop removes the character in the string
 *  	at location i form the remainder string and adds it to the done string.
 *          
 * Use, I/O expected:
 *			Input(s): String value that will be permuted
 *			Output(s): An ArrayList<String> that contains all the permutations of the give String  
 */
import java.util.*;
public class Permuter {
	private ArrayList<String> permutations;
	/*Perm(String s):
	 *		Purpose: Splits up the first level of recursion to avoid confusion. Returns all the permutations in an 
	 *			ArrayList<String> permutations.
	 *		
	 *		Precondition: The user input, String s, needs to be generated
	 *		Postcondition: The Permutations are generated and stored in ArrayList<String> permutations.
	 */
	public ArrayList<String> perm(String s){
		this.permutations = new ArrayList<String>();
		perm(s, " ");//calls perm(String remainder, String done), done is initially empty 
		return this.permutations;//returns the permutations
	}//end perm
	
	/*Perm(String remainder, String done):
	 * 		Purpose: To use recursion to generate the permutations of a String
	 * 		
	 * 		Precondition: String remainder must be generated and done must contain some value 
	 * 		Postcondition: One instance of permutation is generated
	 */
	private void perm(String remainder, String done){
		/* If statement checks if one instance of the permutation is complete. 
		 * 		If true, the program will go up one level of recursion
		 * 		If false, the for loop will trigger and the program will go down one level in recursion
		 */
		if(remainder.length()<= 1)
			permutations.add(done+remainder); //adds one line of permutation to the ArrayList permutations
		else
			/* for loop iterates for every element in the remainder string.
			 * 		This logic will store the character at i in the string remainder and remove it from the 
			 * 			next recursive value of remainder by assigning newString in the perm remainder argument.
			 * 		The character at i in the string remainder will then be added to the done argument. 
			 * 		For every iteration in the for loop, recursion goes down one level until the remainder length is <= 1.
			 */
			for(int i = 0; i < remainder.length(); i++){
				String newString = remainder.substring(0, i) + remainder.substring(i+1);
				//System.out.println("newString: " +newString);//debug
				//System.out.println("Remainder: " +remainder);//debug
				//System.out.println("Done: "+done);//debug
				char remainderAti = remainder.charAt(i);
				//System.out.println("Character at remainder i: " +remainderAti);//debug

				 /*Recursion occurs. remainder = newString, done = done + remainderAti */
				perm(newString, done + remainderAti);
		}//end for
	}//end perm 
}//end Permuter class

