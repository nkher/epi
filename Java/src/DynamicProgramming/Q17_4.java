package DynamicProgramming;

public class Q17_4 {

	// TC = O(mn) and SC = O(min(m,n))
	public static int maximizeFishing(int array[][]) {
		
		int n = array.length;
		int m = array[0].length;
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				array[i][j] += Math.max( (i < 1 ? 0 : array[i-1][j]), 
										 (j < 1 ? 0 : array[i][j-1])); 
			}
		}
		return array[n-1][m-1];
	}
	
	public static void main(String[] args) {
		
		int array[][] = { {1, 6, 30},
						  {7, 14, 59},
						  {90, 87, 9}};
		
		System.out.println("Maximum value fishing path is : " + maximizeFishing(array));
		
		System.out.println(Math.sqrt(125348));
	}

}
