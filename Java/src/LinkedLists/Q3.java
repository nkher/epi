package LinkedLists;

import Library.LinkedListNode;

public class Q3 {
	
	LinkedListNode head;
	
	public Q3(LinkedListNode lln) {
		this.head = lln;
	}
	
	// 1->5->10->40->50
	public void reverseSubList(LinkedListNode p, int s, int f)  {
		
		LinkedListNode beforeStart = p;
		int i = 1;
		while (i < s-1) {
			beforeStart = beforeStart.next;
			i++;
		}
		
		LinkedListNode curr = beforeStart.next, prev = null;
		LinkedListNode next = curr.next;
		i = s;
		while (i <= f) {
			next = curr.next; // 10
			curr.next = prev;
			prev = curr;
			curr = next;
			i++;
		}
		
		// fix the pointers
		// next will have the node which is after 'f'
		// next = 50, beforeStart = 1, prev = 40
		
		beforeStart.next.next = next; //  5 -> 50
		beforeStart.next = prev; // 1 -> 40
	}
	
// 40->10->5->null
	
	public static void main(String[] args) {
		
		LinkedListNode h1 = new LinkedListNode(1, null, null);
		LinkedListNode n2 = new LinkedListNode(5, null, null);
		LinkedListNode n3 = new LinkedListNode(10, null, null);
		LinkedListNode n4 = new LinkedListNode(40, null, null);
		LinkedListNode n5 = new LinkedListNode(50, null, null);
		
		h1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		
		Q3 obj = new Q3(h1);
		
		System.out.println(obj.head.printForward());
		
		obj.reverseSubList(obj.head, 4, 5);
		
		System.out.println(obj.head.printForward());
	}

}
