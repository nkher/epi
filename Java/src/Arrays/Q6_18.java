package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Q6_18 {
	
	// Time complexity is O(N^2)
	
	// Print a 2D n by n array in spiral manner
	public static ArrayList<Integer> printSpiral(int[][] array) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int offset=0;offset<Math.ceil(0.5 * array.length);offset++) {
			list = printSpiralHelper(array, list, offset);
		}
		return list;
	}
	
	public static ArrayList<Integer> printSpiralHelper(int[][] array, ArrayList<Integer> list, int offset) {
		
		if (offset == array.length - offset - 1) {
			// Odd dimension array
			list.add(array[offset][offset]);
			return list;
		}
		
		// row left to right
		for (int i=offset; i<array.length - offset - 1; i++) {
			list.add(array[offset][i]);
		}
		// last col top to bottom
		for (int i=offset; i<array.length - offset - 1; i++) {
			list.add(array[i][array.length - offset - 1]);
		}
		// last row right to left
		for (int i=array.length - offset - 1; i>offset; i--) {
			list.add(array[array.length - offset - 1][i]);
		}
		// last col bottom to top
		for (int i=array.length - offset - 1; i>offset; i--) {
			list.add(array[i][offset]);
		}
		
		return list;
	}
	
	public static void main(String args[]) {
		
		int array[][] =   { {1, 2, 3, 4, 5},
							{16,17,18,19,6},
							{15,24,25,20,7},
							{14,23,22,21,8},
							{13,12,11,10,9}};
		
		System.out.println(Arrays.toString(printSpiral(array).toArray()));
	}
}
