package Heaps;

public class Q11_7 {
	
	public Heap createAndBuildHeap(Heap heap, int size) {
		
		// Start from bottom most and rightmost internal mode and heapify all
	    // internal modes in bottom up way
		for (int i= (heap.size/2-2);i>=0;--i) 
			heapify(heap, i);
		
		return heap;
	}
	
	// higher the time stamp value means it is more recent
	public void heapify(Heap heap, int index) {
		int left = (2*index) + 1;
		int right = (2*index) + 2;
		int latest = index; // This marks the most recent entry in the Array
		
		if (left < heap.size && heap.arr[left].timestamp > heap.arr[latest].timestamp)
			latest = left;
		
		if (right < heap.size && heap.arr[right].timestamp > heap.arr[latest].timestamp)
			latest = right;
		
		if (latest != index) {
			// swap
			HeapNode temp = heap.arr[latest];
			heap.arr[latest] = heap.arr[index];
			heap.arr[index] = temp;
			heapify(heap, latest);
		}
	}
	
	public int pop(Heap heap) {
		HeapNode root = heap.arr[0];
		heap.arr[0] = heap.arr[heap.size-1];
		heap.size--;
		heapify(heap, 0);
		return root.data;
	}
	
	public int peek(Heap heap) {
		return heap.arr[0].data;
	}
	
	public static void main(String args[]) {
		Q11_7 stack = new Q11_7();
		
		int size = 5;
		int arr[] = {3,5,1,4,7};
		Heap heap = new Heap(size);
		
		long ts = 10;
		for (int j=0;j<5;j++) {
			System.out.println("Adding : " + arr[j] + ", ts is : " + (ts+j));
			heap.arr[j] = new HeapNode(arr[j], ts + j);
		}
		
		stack.createAndBuildHeap(heap, size);
		
		System.out.println("Heap created sucessfully !!");
		
		System.out.println(stack.peek(heap));
		
		System.out.println(stack.pop(heap));
		System.out.println(stack.pop(heap));
		System.out.println(stack.pop(heap));
	}
	
}

class Heap {
	HeapNode arr[];
	int size;
		
	public Heap(int size) {
		arr = new HeapNode[size];
		this.size = size;
	}
	
	public void setHeapArray(HeapNode arr[]) {
		this.arr = arr;
	}
}

class HeapNode {
	int data;
	long timestamp;
	
	public HeapNode(int data, long timestamp) {
		this.data = data;
		this.timestamp = timestamp;
	}
}
