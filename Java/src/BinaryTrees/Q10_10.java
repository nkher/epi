package BinaryTrees;

import java.util.ArrayList;
import java.util.HashMap;

import Library.TreeNode;

public class Q10_10 {
	
	// Time complexity is O(n) and space complexity is O(n) using the hashmap
	public static TreeNode formBinaryTreeFromPreInOrder(ArrayList<Integer> preorder_arr, ArrayList<Integer> inorder_arr) {
		
		HashMap<Integer, Integer> inorder_map = new HashMap<Integer, Integer>(); // element to its index
		for (int i=0; i<inorder_arr.size(); i++) {
			inorder_map.put(inorder_arr.get(i), i); 
		}
		return formBinaryTreeFromPreInOrderHelper(preorder_arr, 0, preorder_arr.size(), inorder_map, 0, inorder_arr.size());
	}
	
	public static TreeNode formBinaryTreeFromPreInOrderHelper(ArrayList<Integer> preorder_arr, int preorder_start, int preorder_end,
			HashMap<Integer, Integer> inorder_map, int inorder_start, int inorder_end) {
		
		if (preorder_end <= preorder_start || inorder_end <= inorder_start) {
			return null;
		}
		
		int root_inorder_index = inorder_map.get(preorder_arr.get(preorder_start)); // get the root of the tree
		int left_subtree_size = root_inorder_index - inorder_start;
		
		TreeNode root = new TreeNode(preorder_arr.get(preorder_start)); // make a node 
				
		// assign the left of the subtree
		root.left = formBinaryTreeFromPreInOrderHelper(preorder_arr, preorder_start+1, preorder_start+1+left_subtree_size, 
																inorder_map, inorder_start, root_inorder_index);
		
		// assign the right of the subtree
		root.right = formBinaryTreeFromPreInOrderHelper(preorder_arr, preorder_start+1+left_subtree_size, preorder_end, 
																	inorder_map, root_inorder_index+1, inorder_end);
		
		return root;
	}
	
	public static void inorder(TreeNode node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
		}
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
		
		//root.print();
		
		//inorder(root);
		
		int a[] = {0, 1, 2, 3, 4, 5, 6, 7, 8};
		ArrayList<Integer> inorder_arr = new ArrayList<Integer>();
		for (int i=0;i<a.length;i++) {
			inorder_arr.add(a[i]);
		}
		
		System.out.println();
		//preorder(root);
		
		int b[] = {4, 2, 1, 0, 3, 6, 5, 7, 8};
		ArrayList<Integer> preorder_arr = new ArrayList<Integer>();
		for (int i=0;i<b.length;i++) {
			preorder_arr.add(b[i]);
		}
		
		TreeNode new_root = formBinaryTreeFromPreInOrder(preorder_arr, inorder_arr);
		
		inorder(new_root);
		
		System.out.println();
		
		preorder(new_root);
		
		System.out.println();
		
		new_root.print();
	}

}
