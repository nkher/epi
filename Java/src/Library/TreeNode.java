	package Library;

public class TreeNode {
	
	public int data;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;
	public int size = 0;
	
	public TreeNode(int data) {
		this.data = data;
		size = 1;
	}

	public void setLeftChild(TreeNode left) {
		this.left = left;
		if(left != null)
			left.parent = this;
	}
	
	public void setRightChild(TreeNode right) {
		this.right = right;
		if(right != null)
			right.parent = this;
	}
	
	public void insertInOrder(int d) {
		if(d <= data) {
			if(left == null) {
				setLeftChild(new TreeNode(d));
			}
			else {
				left.insertInOrder(d);
			}
		}
		else {
			if(right == null) {
				setRightChild(new TreeNode(d));
			}
			else {
				right.insertInOrder(d);
			}
		}
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isBST() {
		if(left != null) {
			if(data < left.data || !left.isBST()) {
				return false;
			}
		}
		if (right != null) {
			if(data >= right.data || !right.isBST()) {
				return false;
			}
		}
		return true;
	}
	
	public int height() {
		int leftHeight = left != null ? left.height() : 0; 
		int rightHeight = right != null ? right.height() : 0; 
		return 1 + Math.max(leftHeight, rightHeight);
	}
	
	public TreeNode find(int d) {
		if(data == d)
			return this;
		else if (d <= data) {
			return left != null ? left.find(d) : null;
		}
		else if (d > data) {
			return right != null ? right.find(d) : null;
		}
		return null;
	}
	
	
	// This will work provided the array is sorted
	private static TreeNode createMinimalBST(int a[], int start, int end) {
		if(end < start)
			return null;
		int mid = (start + end)/2;
		TreeNode n = new TreeNode(a[mid]);
		n.setLeftChild(createMinimalBST(a, start, mid-1));
		n.setRightChild(createMinimalBST(a, mid+1, end));
		return n;
	}
	
	public static TreeNode createMinimalBST(int a[]) {
		return createMinimalBST(a, 0, a.length-1);
	}
	
	public void print() {
		BTreePrinter.printNode(this);
	}
}




