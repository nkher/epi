package BinaryTrees;

import java.util.LinkedList;

import Library.TreeNode;

public class Q10_12 {
	
	// T.C is O(n) and space complexity would be O(1) because the question states that you must return a linked list
	// But the number of nodes at a level are (2^h) where h is the height of the tree.
	
	public static LinkedList<Integer> connectLeaves(TreeNode node) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		return connectLeavesHelper(node, linkedList);
	}
	
	public static LinkedList<Integer> connectLeavesHelper(TreeNode node, LinkedList<Integer> linkedList) {
				
		if (node == null) return linkedList;
		
		if (node.left == null && node.right == null) {
			linkedList.add(node.data);
			return linkedList;
		}
		
		linkedList = connectLeavesHelper(node.left, linkedList);
		linkedList = connectLeavesHelper(node.right, linkedList);
		
		return linkedList;
	}

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(50);
		root.insertInOrder(25);
		root.insertInOrder(24);
		root.insertInOrder(30);
		root.insertInOrder(77);
		root.insertInOrder(59);
		root.insertInOrder(80);
		root.insertInOrder(63);
		root.insertInOrder(43);
		root.insertInOrder(4);
		
		root.print();
		
		LinkedList<Integer> linkedList = connectLeaves(root);
		
		System.out.println("Your linked list is : " + linkedList.toString());
	}
}
