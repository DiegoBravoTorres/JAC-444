
/** Workshop 2 
*   Diego Bravo Torres
*  Student Number: 138350202
*  JAC 444 - Winter 2022
*/

public class Stack {
	
	// Field Member
	private char[] characters ;
	
	// One argument constructor using String as argument
	public Stack(String word) {
		
		this.characters =  new char [word.length()];
		for (int i =0; i < word.length() ; i++) {
			this.characters[i] =  word.charAt(i);
		}
		
	}
	
	// One argument constructor using integer as argument to define the size
		public Stack(int size) {			
			this.characters =  new char [size];
			
		}
	
	// Print method for Stack
	public void printStack() {
		System.out.print(this.characters);
		
	}
	
	
	// Method to get the length of the array
	public int getLength() {
		return characters.length;
		
	}
	
	// Method to push a new char into the array
	public void push(char newChar) {
		
		// Length of the current array
		final int LENGTH = this.characters.length;
		
		//Temporary array to store all new chars
		char[] newWord = new char[ LENGTH +1];
		
		//Copy all chars into temporary array
		for (int i=0; i< LENGTH; i++) {
			newWord[i] = characters[i];	
		}
		
		//Add new char at the end of new array
		newWord[LENGTH]= newChar;
		
		// Assign temporary array to our field
		characters =  newWord;
		
	}	
	
	public char pop() {
		
		// Length of the current array
		final int LENGTH = this.characters.length;
		
		//Temporary array to store all new chars
		char[] newWord = new char[LENGTH-1];
		
		// Char variable to be returned to client code
		char returnChar = this.characters[LENGTH-1];
		
		//Copy all chars into temporary array, except last char
		for (int i=0; i< LENGTH-1; i++) {
			newWord[i] = characters[i];
			
		}
		
		// Assign temporary array to our field
		characters =  newWord;
		
		return returnChar;
		
	}
		
	

}
