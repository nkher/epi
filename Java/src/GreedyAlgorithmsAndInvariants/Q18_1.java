package GreedyAlgorithmsAndInvariants;

import java.util.PriorityQueue;

public class Q18_1 {
	
	// based on the idea that more common letters in the message require less chars to represent them hence 
	// and vice versa
	
	// Example - Mississippi River = 17 chars * 8 bits each = 136 bits ... can we do better ?
	// Solution
	/* 
	 * get the counts for each char -
	 * 
	 * Sort in descending and write counts
	 * I5, S4, P2, R2, M1, V1, E1 space1
	 * 
	 * find the two nodes with the lowest counts and add them together
	 * 
	 * say E and space, then M and V, then P and R and so on 
	 * */
	
	
	// TC = O(NlogN)
	
	public static MinHeapNode buildHuffmanTree(char data[], int freq[], int size) {
		
		MinHeapNode left, right, top;
		
		// Step 1 : Create a min heap of capacity equal to the size. 
		PriorityQueue<MinHeapNode> minHeap = new PriorityQueue<MinHeapNode>(size);
		
		// Step 2 : Build the heap
		for (int i=0; i<data.length; i++) {
			minHeap.add(new MinHeapNode(data[i], freq[i]));
		}
		
		// Step 3 : Extract until the size is one
		while (minHeap.size() != 1) {
			
			left = minHeap.remove();
			right = minHeap.remove();
			
			// Step 3:  Create a new internal node with frequency equal to the
	        // sum of the two nodes frequencies. Make the two extracted node as
	        // left and right children of this new node. Add this node to the min heap
	        // '$' is a special value for internal nodes, not used
			top = new MinHeapNode('$', left.freq + right.freq);
			top.left = left;
			top.right = right;
			minHeap.add(top);
		}
		
		// Step 4 : The remaining node is the root node and the tree is complete.
		return minHeap.remove();
	}
	
	public static void printCodes(MinHeapNode root, int arr[], int top) {
		
		// Assign 0 to left edge and recurse
		if (root.left != null) {
			arr[top] = 0;
			printCodes(root.left, arr, top+1);
		}
		
		// Assign 1 to right edge and recur
		if(root.right != null) {
			arr[top] = 1;
			printCodes(root.right, arr, top+1);
		}
		
		// If this is a leaf node, then it contains one of the input
	    // characters, print the character and its code from arr[]
		if (root.left == null && root.right == null) {
			System.out.print(root.data + " -> ");
			printArr(arr, top);
		}
		
	}
	
	public static void printArr(int a[], int n) {
		for (int i=0; i<n; i++) {
			System.out.print(a[i]);
		}
		System.out.println("\n");
	}
	
	public static void HuffmanCodes(char data[], int freq[], int size) {
		
		// construct huffman tree
		MinHeapNode root = buildHuffmanTree(data, freq, size);
		
		 // Print Huffman codes using the Huffman tree built above
		int arr[] = new int [100];
		int top = 0;
		printCodes(root, arr, top);
	}
	
	
	public static void main(String[] args) {
		
		char data[] = {'a', 'b', 'c', 'd', 'e', 'f'};
		int freq[] = {5, 9, 12, 13, 16, 45};
		HuffmanCodes(data, freq, data.length);
	}

}

class MinHeapNode implements Comparable<MinHeapNode> {
	
	public char data;
	public int freq;
	public MinHeapNode left, right;
	
	public MinHeapNode() {}
	
	public MinHeapNode(char data, int freq) {
		this.data = data;
		this.freq = freq;
	}
	
	
	public int compareTo(MinHeapNode o) {
		if (this.freq > o.freq) return 1;
		else if (this.freq < o.freq) return -1;
		return 0;
	}
}
