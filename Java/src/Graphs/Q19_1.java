package Graphs;

public class Q19_1 {
	
	// TC = O(N)
	public static int getCeleb(boolean F[][], int numberOfPeople) {
		// We will start from F[0][1]
		int i=0, j=1;
		while (j < numberOfPeople) {
			
			// means i knows j therefore i cannot be celebrity and for all 
			// j_dash < j, j_dash is not a celebrity as F[i][j_dash] must be false
			if (F[i][j]) {   
				i = j++; // move to F[j][j+1]
			} else { // means i does not know j therefore i is still a candidate and j is not.
				j++; // move to F[i][j+1]
			}
		}
		return i;
	}
	
	public static void main(String args[]) {
		
		boolean F[][] = { {true, true, true, true},
						  {false, true, false, false},
						  {false, true, true, false},
						  {true, true, true, true} };
		
		System.out.println("Celebrity is Person at index : " + getCeleb(F, 4));
	}
}
