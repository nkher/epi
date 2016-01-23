package BinaryTrees;

import java.util.ArrayList;

import Library.TreeNode;

public class Q10_11 {
		
	public static IntWrapper index = new IntWrapper(0);
	
	public static TreeNode reconstructTreeFromPreorder(ArrayList<Integer> preorder_arr) {
		return reconstructTreeFromPreorderHelper(preorder_arr, index);
	}
	
	public static TreeNode reconstructTreeFromPreorderHelper(ArrayList<Integer> preorder_arr, IntWrapper index) {
		
		if (index.get() >= preorder_arr.size()) return null;
		
		Integer val = preorder_arr.get(index.get()); // get the value
		
		// increment the value and this should persist throughout the function as for preorder 
		// we first traverse the left half and then right half and we dont want the index value to change
		index.increment();
		
		if (val == null) {
			return null;
		}
		
		TreeNode root = new TreeNode(val);
		
		root.left = reconstructTreeFromPreorderHelper(preorder_arr, index);
		root.right = reconstructTreeFromPreorderHelper(preorder_arr, index);
		
		return root;
	}
	
	public static void preorder(TreeNode node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preorder(node.left);			
			preorder(node.right);
		}
	}

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(4);
		root.insertInOrder(2);
		root.insertInOrder(6);
		root.insertInOrder(1);
		root.insertInOrder(3);
		root.insertInOrder(5);
		root.insertInOrder(7);
		root.insertInOrder(8);
		root.insertInOrder(0);
		
		root.print();
		preorder(root);
		
		ArrayList<Integer> preorder_arr = new ArrayList<Integer>();
		preorder_arr.add(4);
		preorder_arr.add(2);
		preorder_arr.add(1);
		preorder_arr.add(0);
		preorder_arr.add(null);
		preorder_arr.add(null);
		preorder_arr.add(null);
		preorder_arr.add(3);
		preorder_arr.add(null);
		preorder_arr.add(null);
		preorder_arr.add(6);
		preorder_arr.add(5);
		preorder_arr.add(null);
		preorder_arr.add(null);
		preorder_arr.add(7);
		preorder_arr.add(null);
		preorder_arr.add(8);
		preorder_arr.add(null);
		preorder_arr.add(null);
		
		TreeNode new_root = reconstructTreeFromPreorder(preorder_arr);
		System.out.println("New Tree ");
		
		new_root.print();
	}
}

class IntWrapper {
	
	int i;
	
	public IntWrapper(int i) {
		this.i = i;
	}
	
	public void increment() {
		this.i++;
	}
	
	public int get() {
		return this.i;
	}
}
