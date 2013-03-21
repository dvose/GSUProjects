import java.util.*;


public class Ticket {
		/**
		 * UserInput Method:
		 * 
		 *  Used to Scan for user input integer.
		 *  Returns the quantity of lottery tickets
		 */
		public int UserInput(){
			int num = 0;
			System.out.println("How many tickets would you like to purchase?");
			Scanner s = new Scanner(System.in);
			/*
			 * Scans user input and catches any mismatch exceptions.
			 * If exceptions are caught, the user is prompted to enter a different input.
			 */
			boolean wrong;
			do{
				try{
					num = s.nextInt();
					if(num < 0){
						System.out.println("\nERROR: " + num + " must be a positve number \nPlease try again: ");
						wrong = true;
					}//end else statement
					else if( num > 46){
						System.out.println("You can only purchase a maximum of 46 tickets \nPlease try again:");
						wrong = true;
					}
					else{
						wrong = false;
					}
				}catch(Exception e){
					System.out.println("\nERROR: " + s.nextLine() + " is not an integer \nPlease try again:" );
					wrong = true;;
					}//end catch
				}while(wrong);
			return num;
		}//end UserInput method
		
		/**
		 * CreateTickets Method:
		 * 
		 * Used to create randomly generated lottery tickets.
		 * Creates num amount of lottery tickets where num is the integer inputed by the user in the UserInput method.
		 */
		public void CreateTickets(int amountPurchased) {
			ArrayList<Integer> group2 = new ArrayList<Integer>();
			int ranNum;
			Random randomNumber = new Random();

			/*
			 *Creates the group2 (last number of the lottery tickets) 
			 */
			for(int i = 0; i<= amountPurchased-1; i++){
				ranNum = randomNumber.nextInt(47);
				while(ranNum == 0){
					ranNum = randomNumber.nextInt(47);
				}
				/*
				 * Checks for repeating integers before assigning the random number
				 */
				while(group2.contains(ranNum)){
					ranNum = randomNumber.nextInt(47);
				}
				group2.add(ranNum);
			}
			Collections.sort(group2);
			
			/*
			 * Creates the amount of tickets that are purchased
			 */
			for(int i = 0; i < amountPurchased; ++i) {
				//initializes a new array
				int[] singleTicket = new int[5];
				/*
				 * Creates the random numbers inside the ticket
				 */
				for(int j = 0; j<5; j++){
					ranNum = randomNumber.nextInt(56);
					/*
					 * Checks for repeating numbers inside the ticket 
					 */
					for(int x = 0; x<5; x++){
						while(singleTicket[x] == ranNum){
							ranNum = randomNumber.nextInt(56);
						}//end if statement
					}//end for loop
					
					//assigns the random number as an element of the array 
					singleTicket[j] = ranNum;
				}//end for loop
				
				/*
				 * Sorts the integers from lowest to highest
				 */
					Arrays.sort(singleTicket);
				
				/*
				 * Prints out a single ticket
				 */
				for(int k = 0; k<singleTicket.length; k++){
					if(k == 0){
						System.out.print("[");
					}//end if
					if(k == 5){
						System.out.print(singleTicket[k]);
					}//end if
					else{
						System.out.print(singleTicket[k] + " ");
					}//end else
					if(k == singleTicket.length - 1){
						System.out.print("| ");
					}//end if
				}//end for loop
				/*
				 * Prints out the last number of the lottery ticket
				 */
				Collections.shuffle(group2);
				System.out.print(group2.get(0) + "] \n");
				group2.remove(0);
			}//end for loop
		}//end CreateTickets method
}//end Ticket class