package HonorsClass;

import java.util.Arrays;

public class Q22_4 {

	
	/* Time = O(n) and Space = O(n) */
	public static int maxProductButOne(int a[]) {
		
		int n = a.length;
		int L[] = new int[n];
		int R[] = new int[n];
		
		L[0] = 1;
		for (int i=1; i<n; i++) {
			L[i] = a[i-1] * L[i-1];
		}
		
		R[n-1] = 1;
		for (int i=n-2; i>=0; i--) {
			R[i] = a[i+1] * R[i+1];
		}
				
		int maxProd = Integer.MIN_VALUE;
		for (int i=0; i<n; i++) {
			maxProd = Math.max(maxProd, (L[i] * R[i]) );
		}
		
		return maxProd;
	}
	
	/* Method 2  - Time = O(n) and space  = O(1) */
	public static int maxProdButOneEff(int a[]) {
		
		int smallestPosIdx = -1, smallestNegIdx = -1, biggestNegIdx = -1, negCount = 0;
		int n = a.length;
		
		for (int i=0; i<n; i++) {
			
			if (a[i] < 0) {
				negCount++;
				if (smallestNegIdx == -1 || a[i] < smallestNegIdx) {
					smallestNegIdx = i;
				}
				if (biggestNegIdx == -1 || a[i] > biggestNegIdx) {
					biggestNegIdx = i;
				}
			}
			else {
				if (smallestPosIdx == -1 || a[i] < a[smallestPosIdx]) {
					smallestPosIdx = i;
				}
			}
		}
				
		int skipidx = -1;
		if ((negCount & 1) == 1) {
			skipidx = biggestNegIdx;
		}
		else { // odd negative counts
			skipidx = smallestPosIdx != -1 ? smallestPosIdx : smallestNegIdx;
		}
				
		int prod = 1;
		for (int i=0; i<n; i++) {
			if (i != skipidx) {
				prod *= a[i];
			}
		}
		
		return prod;
	}
	
	public static void main(String[] args) {
		
		int a[] = {3, 2, 5, 4};
		System.out.println(maxProdButOneEff(a));
		
		int b[] = {3, 2, 9, -1, -8};
		System.out.println(maxProdButOneEff(b));
	}

}
