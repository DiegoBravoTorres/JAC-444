
/** Workshop 1 
*   Diego Bravo Torres
*  Student Number: 138350202
*  JAC 444 - Winter 2022
*/



public class Workshop1 {

	public static void main(String[] args) {
				
		final int numOfRows =8;
		
		for(int iteratorY =0 ; iteratorY < numOfRows; iteratorY++) {
			
			// This will limit the number of numbers that need to be printed
			int startIndex = numOfRows - iteratorY;
			int endIndex = numOfRows +iteratorY;
			
			int val =0;
			int returnPoint = 0;
			
			for(int iteratorX =0 ; iteratorX <= numOfRows * 2; iteratorX++) {
			
				
				if(iteratorX >= startIndex && iteratorX <= endIndex) {
					
					double result =0.0;
					
					
					// These two ifs where added to keep the proper format
					if(val<=3) {
						System.out.print(" ");	
					}
					if(val<=6) {
						System.out.print(" ");	
					}
					
					// This logic will calculate the number to be printed
					if(returnPoint ==0) {
						
						result = Math.pow(2, val++);
						
						if(val == iteratorY) {
							returnPoint =1;
						}
						
					}else {
						
						result = Math.pow(2, val--);
						
					}
					
					// After calculated the final result will be printed
					System.out.print(' ');	
					System.out.print(((int)result));
						
				}else {
					System.out.print("    ");
					
				}
				
			}
			
			System.out.print('\n');
		
		}
	
	}

}
