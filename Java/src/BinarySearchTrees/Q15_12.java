package BinarySearchTrees;

import Library.TreeNode;

public class Q15_12 {
	
	// Worst case time complexity is O(h)
	public static boolean pairIncludesAncestorAndDescendant(TreeNode AorD0, TreeNode AorD1, TreeNode middle) {
		
		TreeNode search0 = AorD0, search1 = AorD1;
		while (search0 != AorD1 && search0 != middle && search1 != AorD0 && search1 != middle) {
			
			if (search0 != null) {
				search0 = search0.data > middle.data ? search0.left : search0.right;
			}
			
			if (search1 != null) {
				search1 = search1.data > middle.data ? search1.left : search1.right;
			}
		}
		
		// check if we have reached an error condition somewhere which concludes that there is no
		// 3 node relation between the given nodes
		if ( (search0 != middle && search1 != middle) || search0 == AorD1 || search1 == AorD0 ) {
			search0 = AorD1;
			search1 = AorD0;
			return false;
		}
		
		// if we have reached here means one of the nodes has reached the middle
		// check which one has reached and traverse from middle till the other ancestor or descendant
		return search0 == middle ? searchTarget(middle, AorD1) : searchTarget(middle, AorD0);
	}
	
	public static boolean searchTarget(TreeNode start, TreeNode target) {
					
		while (start != null && start != target) {
			start = start.data < target.data ? start.right : start.left;
		}
		
		return start == target;
	}

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(19);
		root.insertInOrder(7);
		root.insertInOrder(43);
		root.insertInOrder(3);
		root.insertInOrder(11);
		root.insertInOrder(23);
		root.insertInOrder(47);
		root.insertInOrder(2);
		root.insertInOrder(5);
		root.insertInOrder(17);
		root.insertInOrder(37);
		root.insertInOrder(53);
		root.insertInOrder(13);
		root.insertInOrder(29);
		root.insertInOrder(41);
		root.insertInOrder(31);
		
		System.out.println(pairIncludesAncestorAndDescendant(root, root.right.left, root.right));
		
		
		System.out.println(pairIncludesAncestorAndDescendant(root, root.right.left.right, root.right.left));
	}

}
