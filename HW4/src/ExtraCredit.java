public class ExtraCredit {
	public static void main(String[] args) {
		CSCStack<Character> stack = new CSCStack<Character>();
		CSCQueue<Character> queue = new CSCQueue<Character>();
		boolean palindrome = false;
		String productString = null;
		for(int i = 999; i>99; i--){
			if(palindrome){
				break;
			}//end if
			for(int j = 999; j>99; j--) {
				if(palindrome){
					break;
				}//end if
				System.out.println("i: "+i);
				System.out.println("j: "+j);
				Integer product = i * j;
				System.out.println("product: " +product);
				productString = product.toString();
				for(int k = 0; k<productString.length(); k++){
					stack.push(productString.charAt(k));
					queue.enqueue(productString.charAt(k));
				}//end for
				for(int k = 0; k< productString.length(); k++){
					char stackPeek = stack.peek();
					char queuePeek = queue.peek();
					if(stackPeek == queuePeek){
						stack.pop();
						queue.dequeue();
						palindrome = true;
					}//end if
					else{
						palindrome = false;
						break;
					}//end else
				}//end for
				if(palindrome){
					break;
				}//end if
			}//end for
		}//end for
		System.out.println("Palindrome: " + productString);
	}//end main
}//end ExtraCredit
