package Heaps;

import java.util.PriorityQueue;

public class Q11_1 {
	
	public static int[] mergeSortedArrays(int sortedArrays[][]) {
		
		PriorityQueue<ArrayContainer> minHeap = new PriorityQueue<ArrayContainer>();
		int total = 0;
		
		// adding the arrays to the heap
		for (int i=0;i<sortedArrays.length;i++) {
			minHeap.add(new ArrayContainer(sortedArrays[i], 0));
			total = total + sortedArrays[i].length;
		}
		
		int writeInd = 0;
		int result[] = new int[total];
		
		// while the min heap is not empty
		while (!minHeap.isEmpty()) {
			ArrayContainer ac = minHeap.poll();
			result[writeInd++] = ac.arr[ac.index];
			
			// incrementing the index
			if (ac.index < ac.arr.length - 1) {
				minHeap.add(new ArrayContainer(ac.arr, ac.index+1));
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		int sortedArrays[][] = { {3,5,7},
							     {0,6},
								 {0,6,28}};

		int result[] = mergeSortedArrays(sortedArrays);
		for (int i=0;i<result.length;i++) {
			System.out.print(result[i] + " ");
		}
	}

}

class ArrayContainer implements Comparable<ArrayContainer> {
	
	int []arr;
	int index;
	
	public ArrayContainer(int arr[], int index) {
		this.arr = arr;
		this.index = index;
	}

	public int compareTo(ArrayContainer o) {
		if (this.arr[this.index] > o.arr[o.index]) {
			return 1;
		}
		else if (this.arr[this.index] < o.arr[o.index]) {
			return -1;
		}
		else {
			return 0;
		}
	}
}