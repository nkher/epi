package BinaryTrees;

import Library.TreeNode;

public class Q10_6 {
		
	// Root to leaf path with specified sum
	public static boolean hasPathWithSum(TreeNode root, int sum) {
		int partialSum = 0;
		return hasPathWithSumHelper(root, sum, partialSum);
	}
	
	public static boolean hasPathWithSumHelper(TreeNode root, int sum, int partialSum) {
		
		if (root == null) {
			return false;
		}
		
		partialSum += root.data;
		
		if (root.left == null && root.right == null) { // check if leaf
			if (partialSum == sum) return true;
			else return false;
		}
		
		// non leaf
		return hasPathWithSumHelper(root.left, sum, partialSum) || hasPathWithSumHelper(root.right, sum, partialSum);
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(50);
		root.insertInOrder(25);
		root.insertInOrder(75);
		root.insertInOrder(100);
		root.insertInOrder(55);
		root.insertInOrder(45);
		root.insertInOrder(5);
		root.insertInOrder(35);
		
		root.print();
		
		System.out.println(hasPathWithSum(root, 80));
		
		System.out.println(hasPathWithSum(root, 155));
		
		System.out.println(hasPathWithSum(root, 225));
		
		System.out.println(hasPathWithSum(root, 180));
		
		System.out.println(hasPathWithSum(root, 185));
	}

}
