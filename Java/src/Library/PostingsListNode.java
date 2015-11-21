package Library;

public class PostingsListNode {
	
	public int data;
	public PostingsListNode next;
	public PostingsListNode jump;
	
	public PostingsListNode() {}
	
	public PostingsListNode(int data, PostingsListNode next, PostingsListNode jump) {
		this.data = data;
		this.next = next;
		this.jump = jump;
	}
}
