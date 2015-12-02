package LinkedLists;

import Library.LinkedListNode;

public class Q2 {
	
	LinkedListNode head;
	
	public Q2 (LinkedListNode lln) {
		this.head = lln;
	}
	
	// 1->5->10->40
	public void reverseRec(LinkedListNode p) {
		
		if (p.next == null) { // this is the last item
			head = p;
			return;
		}
		reverseRec(p.next);
		LinkedListNode temp = p.next;
		temp.next = p;
		p.next = null;		
	}
	
	public void reverseIter(LinkedListNode p) {
		
		LinkedListNode curr = p, prev = null;
		while (curr != null) {
			LinkedListNode next = curr.next; // store the next
			curr.next = prev; // reverse the pointers
			prev = curr;			 
			curr =  next;
		}
		
		head = prev;
	}
	
	public static void main(String[] args) {
		
		LinkedListNode h1 = new LinkedListNode(1,null, null);
		LinkedListNode n2 = new LinkedListNode(5, null, null);
		LinkedListNode n3 = new LinkedListNode(10, null, null);
		LinkedListNode n4 = new LinkedListNode(40, null, null);
		
		h1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		
		Q2 obj = new Q2(h1);
		
		System.out.println(obj.head.printForward());
		
		obj.reverseRec(obj.head);
		// obj.reverseIter(obj.head);
		
		System.out.println(obj.head.printForward());
		
	}

}
