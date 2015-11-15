package Arrays;

import java.util.Arrays;

public class Q6_2 {
	
	/* Function to increment a big integer */
	
	public static int[] increment(int bigInteger[]) {
		int n = bigInteger.length;
		bigInteger[n-1] = bigInteger[n-1] + 1; // add 1 to the last digit
		
		for (int i=n-1;i>0 && bigInteger[i] == 10; i--) {
			bigInteger[i] = 0;
			++bigInteger[i-1];
		}
		
		int bigIntegerToReturn[]; // this is if 1 is added to 999, number of digits increase
		if (bigInteger[0] == 10) {
			// make a new array
			bigIntegerToReturn = new int[n+1];
			for (int i=bigIntegerToReturn.length-1;i>0;i--) {
				bigIntegerToReturn[i] = bigInteger[i-1];
			}
			bigIntegerToReturn[1] = 0;
			bigIntegerToReturn[0] = 1;
			
			return bigIntegerToReturn;
		}
		return bigInteger;
	}
	
	public static void main(String[] args) {
		
		int bigInteger[] = {8,9,9,9};
		System.out.println(Arrays.toString(increment(bigInteger)));
	}

}
