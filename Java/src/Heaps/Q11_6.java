package Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Q11_6 {

	
	// TC = O(NlogN) SC = worst case is O(N)
	public static ArrayList<Integer> getKLargestElementsFromMaxHeap(int[] maxHeapArr, int k) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		PriorityQueue<HeapObject> maxHeap = new PriorityQueue<HeapObject>(Collections.reverseOrder());
		
		// the first element would always be the largest
		maxHeap.add(new HeapObject(0, maxHeapArr[0]));
		
		for (int i=0;i<k;i++) {
			
			int topIndex = maxHeap.peek().index; // get the index
			list.add(maxHeapArr[topIndex]); // add it to the result
			
			maxHeap.remove();	// remove that element from the heap
						
			int leftInd = (2 * topIndex + 1);
			if (leftInd < maxHeapArr.length) {
				maxHeap.add(new HeapObject(leftInd, maxHeapArr[leftInd]));
			}
			
			int rightInd = (2 * topIndex + 2);
			if (rightInd < maxHeapArr.length) {
				maxHeap.add(new HeapObject(rightInd, maxHeapArr[rightInd]));
			}
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		
		int maxHeapArr[] = {561, 314, 401, 28, 156, 359, 271, 11, 3}; 
		
		ArrayList<Integer> result = getKLargestElementsFromMaxHeap(maxHeapArr, 3);
		
		System.out.println("Top three largest elements in the heap are : " + result.toString());
	}

}

class HeapObject implements Comparable<HeapObject> {
	int index;
	int data;
	
	public HeapObject(int index, int data) {
		this.index = index;
		this.data = data;
	}

	public int compareTo(HeapObject o) {
		if (this.data > o.data) return 1;
		else if (this.data < o.data) return -1;
		else return 0;
	}
}
