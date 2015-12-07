package HashTables;

import java.util.HashSet;
import java.util.Set;

import Library.TreeNode;


public class Q13_5 {

	// This method is for close ancestors and for trees having parent pointers
	// TC = O(a + b) and SC = O(a + b)
	public static TreeNode LCAOptimized(TreeNode a, TreeNode b) {
		
		Set<TreeNode> hashset = new HashSet<TreeNode>();
		TreeNode iterA = a, iterB = b;
		
		while (iterA != null || iterB != null) {
			
			if (iterA != null) {
				if (hashset.add(iterA) == false) {
					return iterA;
				}
				iterA = iterA.parent;
			}
			
			if (iterB != null) {
				if (hashset.add(iterB) == false) {
					return iterB;
				}
				iterB = iterB.parent;
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(50);
		root.insertInOrder(23);
		root.insertInOrder(78);
		root.insertInOrder(55);
		root.insertInOrder(29);
		root.insertInOrder(39);
		root.insertInOrder(13);
		root.insertInOrder(2);
		root.insertInOrder(10);
		root.insertInOrder(155);
		root.insertInOrder(45);
		root.insertInOrder(62);
		root.insertInOrder(59);
		root.insertInOrder(80);
		
		root.print();
		
		System.out.println(root.right.left.right.left.data);
		System.out.println(root.right.right.left.data);
		
		System.out.println(LCAOptimized(root.right.left.right.left, root.right.right.left).data);
	}

}
