package BinaryTrees;


import Library.RightSibTreeNode;
import Library.TreeNode;

public class Q10_13 {
	
	// TC = O(n)
	// Constructing the right sibling tree
	public static void consRightSiblingTree(RightSibTreeNode root) {
		
		RightSibTreeNode leftStart = root;
		while (leftStart != null) {
			populateNextField(leftStart);
			leftStart = leftStart.left;
		}
	}
	
	public static void populateNextField(RightSibTreeNode node) {
		
		RightSibTreeNode iter = node;
		while (iter != null && iter.left != null) { // finish this level's children
			
			iter.left.next = iter.right; // setting the left child next
			
			 // for setting the right child we first check if current node's next is available or not, who's left child would become the
			// next for the current ones right
			if (iter.next != null) {
				iter.right.next = iter.next.left;
			}
			
			iter = iter.next;
		}
		
	}
	
	public static void inorder(RightSibTreeNode node) {
		if (node != null) {
			inorder(node.left);
			System.out.println(node.data);
			inorder(node.right);
		}
	}
	
	public static void main(String[] args) {
		
		TreeNode root1 = new TreeNode(50);
		root1.insertInOrder(100);
		root1.insertInOrder(25);
		root1.insertInOrder(10);
		root1.insertInOrder(40);
		root1.insertInOrder(60);
		root1.insertInOrder(150);
		
		root1.print();
		
		RightSibTreeNode root = new RightSibTreeNode(50);
		RightSibTreeNode n1 = new RightSibTreeNode(100);
		RightSibTreeNode n2 = new RightSibTreeNode(25);
		RightSibTreeNode n3 = new RightSibTreeNode(10);
		RightSibTreeNode n4 = new RightSibTreeNode(40);
		RightSibTreeNode n5 = new RightSibTreeNode(60);
		RightSibTreeNode n6 = new RightSibTreeNode(150);
		
		root.left = n2;
		root.right = n1;
		n1.right = n6;
		n1.left = n5;
		n2.left = n3;
		n2.right = n4;
		
		inorder(root);
		
		consRightSiblingTree(root);
		
		System.out.println(root.left.data + " next is " + root.left.next.data);
		
		System.out.println(root.left.left.data + " next is " + root.left.left.next.data);
		
		System.out.println(root.left.right.data + " next is " + root.left.right.next.data);
		
		System.out.println(root.right.left.data + " next is " + root.right.left.next.data);
		
		System.out.println("Good Job !!!");
	}

}
