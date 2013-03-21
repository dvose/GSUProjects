import java.util.*;
public class Driver {
	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		String s = getInput();
		cleanString(s);
		System.out.println("User Input (cleaned): " + s); //debug
	}//end main method
	public static String getInput(){
		String userInput = scan.nextLine();
		return userInput;
	}//end getInput method
	public static void cleanString(String s){
		s.toLowerCase();
	}//end cleanString method
}//end Driver class
