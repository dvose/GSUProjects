/**
 * Name: Dustin Vose
 * Class: CSC 3410
 * Instructor: Andrew Rosen
 * Date: September 1st, 2012
 * 
 * Purpose of Program: 
 * The user is asked how many lottery tickets he/she wishes to buy. The program then generates arrays based on the number the user inputs.
 * The first 5 elements of the arrays are randomly generated from 1 - 56 and are sorted from lowest to highest.
 * The 6th element of the arrays are randomly generated from 1 - 46.
 */

import java.util.*; 

public class MegaMillion{
	/**
	 * main Method
	 */
	public static void main(String[] args) {
		String answer = "yes";
		/*
		 * Program continues to run until the user breaks the while loop by setting answer = no or n
		 */
		while(answer.equals("yes") || answer.equals("y")){
			Ticket tick = new Ticket();
			int amount = tick.UserInput();
			tick.CreateTickets(amount);
			
			System.out.println("\nWant to buy more tickets?");
			/*
			 * Scans user input for yes or no. If any other input is received, the user is prompted again
			 */
			boolean noInput = true;
			while(noInput){
				Scanner s = new Scanner(System.in);
				answer = s.nextLine().toLowerCase();
				if(answer.equals("yes") || answer.equals("no") || answer.equals("y") || answer.equals("n")){
					noInput = false;
				}//end if statement
				else{
					System.out.println("Please answer yes(y) or no(n):");
					noInput = true;
				}//end else statement
			}//end embedded while loop
		}//end while loop		
	}//end main method
}//end MegaMillion class

