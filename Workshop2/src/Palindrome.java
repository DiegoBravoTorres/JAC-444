
/** Workshop 2 
*   Diego Bravo Torres
*  Student Number: 138350202
*  JAC 444 - Winter 2022
*/


public class Palindrome {
	
	//Word fields
	private Stack word;
	private Stack reversedWord;
	
	//One argument (String) constructor
	public Palindrome(String word){
		
		//Defining general length
		int length = word.length();
	   
		// Constructing word field
		this.word = new Stack(word);
       
		// Constructing the reversed word field
		this.reversedWord = new Stack(length);
		for(int i = length ; i != 0; i--) {
			reversedWord.push(word.charAt(i-1));
       }
       
	}
	
	// Method that defines if the word is an actual Palindrome
	public boolean isPalindrome() {
		
		int numOfEqualChars = 0;
		final int LENGTH = word.getLength();
		
		// Loop through the each character 
		for(int i = 0; i < LENGTH; i++) {

			// Keep popping each character and compare each other at the same index
			if( word.pop() == reversedWord.pop()) {
				
				// Keep comparing the number of matches
				numOfEqualChars ++;
				};
       }
	
		// Return true if the number of matching characters is the same of the length of the word
		return numOfEqualChars  == LENGTH;
		
	}
	
	

	public static void main(String[] args) {
		
		// Creating new instance of Palindrome
		Palindrome argument = new Palindrome(args[0]);
		
		
		// Print reversed word field
		System.out.print("Your reversed argument looks like this: ");
		argument.reversedWord.printStack();
		System.out.print('\n');
		
		// Print if the argument is a palindrome or not
		if(argument.isPalindrome()) {
			System.out.print("The word "+ args[0]+" is a Palindrome");
	
		}else{
			System.out.print("The word "+ args[0]+" is NOT a Palindrome");
		};
		

	}
	
	
}
