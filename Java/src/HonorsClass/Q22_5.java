package HonorsClass;

import Library.PairOfInts;

public class Q22_5 {
	
	public static PairOfInts longestContiguousSubArray(int a[]) {
		PairOfInts result = new PairOfInts(0, 0);
		int maxLength = 1;
		int i = 0;
		while (i < a.length - maxLength) {
			
			boolean canSkip = false;
			
			// Checking if skippable
			for (int j=i+maxLength; j>i; j--) {
				if (a[j-1] > a[j]) {
					i = j;
					canSkip = true;
					break;
				}
			}
						
			// Now depending on whether we can skip or not we check start checking
			if (!canSkip) {
				i = i + maxLength;
				while (i < a.length && a[i-1] < a[i]) {
					i++;
					maxLength++;
				}
				result.setPair(i - maxLength, i - 1);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		int a[] = {2, 11, 3, 5, 13, 7, 19, 17, 23};
		
		System.out.println(longestContiguousSubArray(a).toString());
	}

}
