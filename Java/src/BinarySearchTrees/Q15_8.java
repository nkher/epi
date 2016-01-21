package BinarySearchTrees;

import java.util.ArrayList;
import java.util.HashSet;

public class Q15_8 {
	
	// TC = O(N)
	// Start with i = 0 and j = 0
	// idea is that the next smallest number would be the sum of the current smallest number plus either or (1 or SQRT(2))
	// keep on adding 1 from ith index and SQRT(2) from jth index to the curent smallest number 
	
	public static ArrayList<ABSqrt2> generateFirstKABSqrt2(int k) {
		
		ArrayList<ABSqrt2> result = new ArrayList<ABSqrt2>();
		result.add(new ABSqrt2(0, 0));
		int i = 0, j = 0;
		
		for (int n=0;n<k;n++) {
			
			ABSqrt2 resultiplus1 = new ABSqrt2(result.get(i).a + 1, result.get(i).b);
			ABSqrt2 resultjplusSqrt2 = new ABSqrt2(result.get(j).a, result.get(j).b + 1);
			
			if (resultiplus1.val < resultjplusSqrt2.val) {
				result.add(resultiplus1);
				i++;
			}
			else if (resultiplus1.val > resultjplusSqrt2.val) {
				result.add(resultjplusSqrt2);
				j++;
			}
			else {
				i++;
				j++;
				result.add(resultiplus1);
			}
		}
		return result;
	}
	
//	// TC = O(kLogK)
//	public static ArrayList<ABSqrt2> generateFirstKABSqrt2Second(int k) {
//		
//		HashSet<ABSqrt2> set = new HashSet<ABSqrt2>();
//		ArrayList<ABSqrt2> result = new ArrayList<ABSqrt2>();
//		result.add(new ABSqrt2(0, 0));
//		
//		while (result.size() < 0) {
//			
//		}
//	}
	
	public static void main(String[] args) {
		
		ArrayList<ABSqrt2> result = generateFirstKABSqrt2(5);
		
		for (ABSqrt2 ans : result) {
			System.out.println(ans.val);
		}
	}
}

class ABSqrt2 {
	int a, b;
	double val;
	
	public ABSqrt2(int a, int b) {
		this.a = a;
		this.b = b;
		val = a + (b * Math.sqrt(2));
	}
}
