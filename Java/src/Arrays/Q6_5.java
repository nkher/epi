package Arrays;

import java.util.Arrays;

public class Q6_5 {
	
	// Program to delete a key from an array
	// Hint is to delete all duplicates in one go rather than deleting one in one iteration
	
	// The brute force approach yields O(n^2)
	// The below approach is TC = O(n)
	public static int[] deleteKey(int key, int array[]) {
		int index = 0;
		for (int i=0;i<array.length;i++) {
			if (array[i] != key) {
				array[index++] = array[i];
			}
		}
		while (index < array.length) 
			array[index++] = -1;
		return array;
	}
	
	
	public static void main(String[] args) {
		
		int array[] = {3,3,5,6,89,34,3,76,8,0,2};
		System.out.println(Arrays.toString(deleteKey(3, array)));
	}

}
