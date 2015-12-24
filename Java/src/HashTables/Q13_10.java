package HashTables;

import java.util.HashMap;

public class Q13_10 {
	
	// TC = O(n)
	public static int longestUniqueSubArray(String A[]) {
		
		HashMap<String, Integer> mostRecentOcc = new HashMap<String, Integer>();
		int result = 0, longestDupFreeSubArrStart = 0;
		
		for (int i=0; i<A.length; i++) {
			if (mostRecentOcc.containsKey(A[i])) {
				int prevOccInd = mostRecentOcc.get(A[i]);
				result = Math.max(result, i - longestDupFreeSubArrStart);
				longestDupFreeSubArrStart = prevOccInd + 1;
			}
			mostRecentOcc.put(A[i], i);
		}
		
		return result;
	}

	public static void main(String[] args) {
		
		String A[] = {"f", "s", "f", "e", "t", "w", "e", "n", "w", "e"};
		
		String B[] = {"n", "a", "m", "m", "e", "s", "h", "k", "i", "k"};
		
		System.out.println(longestUniqueSubArray(A));
		
		System.out.println(longestUniqueSubArray(B));
	}

}
