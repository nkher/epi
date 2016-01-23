package DynamicProgramming;

import java.util.HashSet;

public class Q17_7 {

	// TC = O(n * sum) SC = O(sum)
	public static int minimizeDifference(int a[]) {
		
		int sum = 0;
		for (int i : a) { sum+=i; }
		
		HashSet<Integer> isOK = new HashSet<Integer>();
		isOK.add(0);
		
		for (int item : a) {
			for (int v=sum/2; v >= item; v--) {
				if (isOK.contains(v - item)) {
					isOK.add(v);
				}
			}
		}
		
		for (int i=sum/2; i>0; i--) {
			if (isOK.contains(i)) {
				return (sum - i) - i;
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		
		int a[] = {3, 4, 2, 2, 3, 5};
		
		System.out.println("Minimum difference after split : " + minimizeDifference(a));
	}

}
