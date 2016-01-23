package BinaryTrees;

import Library.TreeNode;

public class Q10_5 {
	
	// sum the root to leaf paths in a binary tree containing 0 and 1s
	// root to leaf is 1 number in binary form with MSB as root
	// TC = O(n) and SC = (n)
	public static int sumRootToLeaf(TreeNode root) {
		return sumRootToLeafHelper(root, 0);
	}
	
	public static int sumRootToLeafHelper(TreeNode node, int sum) {
		
		if (node == null) return 0;
		
		sum = (sum *2) + node.data;
		if (node.left == null && node.right == null) { // Leaf
			System.out.println("Sum is : " + sum);
			return sum;
		}
		
		return sumRootToLeafHelper(node.left, sum) + sumRootToLeafHelper(node.right, sum);
	}
	
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.setLeftChild(new TreeNode(0));
		root.setRightChild(new TreeNode(1));
		root.left.setLeftChild(new TreeNode(0));
		root.left.setRightChild(new TreeNode(1));
		root.left.left.setLeftChild(new TreeNode(0));
		root.left.left.setRightChild(new TreeNode(1));
		root.left.right.setRightChild(new TreeNode(1));
		root.left.right.right.setLeftChild(new TreeNode(0));
		root.right.setLeftChild(new TreeNode(0));
		root.right.left.setRightChild(new TreeNode(0));
		root.right.left.right.setRightChild(new TreeNode(0));
		root.right.left.right.setLeftChild(new TreeNode(1));
		root.right.left.right.left.setRightChild(new TreeNode(1));
		root.right.setRightChild(new TreeNode(0));
		root.right.right.setRightChild(new TreeNode(0));
		
		root.print();
		
		System.out.println(sumRootToLeaf(root));
		
		
		System.out.println("\n\n\n");
		System.out.println(Integer.parseInt("1000", 2));
		System.out.println(Integer.parseInt("1001", 2));
		System.out.println(Integer.parseInt("10110", 2));
		System.out.println(Integer.parseInt("110011", 2));
		System.out.println(Integer.parseInt("11000", 2));
		System.out.println(Integer.parseInt("1100", 2));
	}

}
