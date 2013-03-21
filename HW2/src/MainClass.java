/*
 * CSC3410 - Fall 2012
 * DateDue: September 22, 6AM
 * Assignment: Assignment 2
 * File:  	Permutation.java
 * 
 * Purpose: 
 * 			Generates the permutations of a string given by the user.
 * 			Creates an instance of the Permuter class which uses recursion to generate the 
 * 				permutations of the string given.
 * 			Once the permutations are created, they are stored in an ArrayList of strings and outputs 
 * 				the elements of the ArrayLists to the console as well as a text file named "Permutations.txt". 
 * 			After the program outputs the permutations, the user is prompted to answer if they want to generate
 * 				a permutation of another string. Any answer besides "yes" or "y" will end the program.
 * 
 * Solution, algorithms and data structures:   
 *          Scanners are used to receive String input from the console in the getInput method. 
 *          ArrayLists are used to store the permutations in an organized manner. 
 *          Logic was laid out to make sure that the user did not cause a possible StackOverFlow Exception by
 *          	restricting the maximum length of a string input to the final integer MAXLENGTH. 
 * 			
 *          
 * Major classes: 
 * 			Permutation - Main Class; holds an instance of the Permuter Class.
 * 			Permuter - holds no instances of other classes.   
 * 
 * Use, I/O expected:
 * 				  
 *
 */
import java.io.*;
import java.util.*;
public class MainClass{
  private static Scanner scan;
public static void main(String args[]) {
	  String answer = "yes";
	  final int MAXLENGTH = 7;
	  while(answer.equals("yes") || answer.equals("y")){
		  Permuter permuter1 = new Permuter();
		  System.out.print("String to Permutate: ");
		  String userInput = cleanString(getInput());
		  if (userInput.length() >= MAXLENGTH){
			  System.out.println("To avoid a possible StackOverFlow, please restrict the size of the string less than " + MAXLENGTH);
			  continue;//prompts the user to enter in a different string 
		  }//end if
		  //System.out.println(userInput);//debug
		  ArrayList<String> permutation = permuter1.perm(userInput);
		  printList(permutation);
		  toTextFile(permutation);
		  System.out.println("\nWould you like to permutate another string?");
		  answer = cleanString(getInput());
	  }//end while
  }//end method
  
  public static String getInput(){
		scan = new Scanner(System.in);
		String userInput = scan.nextLine();
		return userInput;
  }//end method
  
  /*
   * The cleanString string method uses functions from the JAVA String class to trim the whitespace between the string     
   * and to assure that all strings are uniform lowercase.
   */
  public static String cleanString(String s){
  		return s.toLowerCase().trim();
	}//end method
  
  public static void printList(ArrayList<String> s){
	  for(int i = 0; i < s.size(); i++){
		  System.out.println(s.get(i));
	  }//end for
  }//end method
  
  public static void toTextFile(ArrayList<String> s){
	  try{
		  PrintWriter output = new PrintWriter(
				  new FileWriter("Permutations.txt"));
		  for(int i = 0; i < s.size(); i++){
			  output.println(s.get(i));
		  }//end for
		  output.close();
	  }//end try
	  catch(IOException e){
		  System.out.println(e);
		  System.exit(1);
	  }
  }//end method
}//end class
