package LinkedLists;

import Library.LinkedListNode;

public class Q8_10 {
	
	public static LinkedListNode cyclicRightShift(LinkedListNode head, int k) {
		
		if (head == null) return null;
		if (k < 1) return head;
		
		int length = lengthList(head);
		
		int m = length - k;
		LinkedListNode newEnd = head, newHead, currLast;
				
		// get the newEnd
		while (m > 1) {
			newEnd = newEnd.next;
			m--;
		}
		
		// get the newHead
		newHead = newEnd.next;
		
		// get the currLast
		currLast = newEnd;
		while (currLast.next != null) {
			currLast = currLast.next;
		}
		
		// set the pointers
		currLast.next = head;
		newEnd.next = null;
		
		return newHead;
	}
	
	public static int lengthList(LinkedListNode h) {
		if (h == null) return 0;
		int k = 0;
		while (h != null) {
			h = h.next;
			k++;
		}
		return k;
	}

	public static void main(String[] args) {
		
		LinkedListNode head = new LinkedListNode(1, null, null);
		LinkedListNode n1 = new LinkedListNode(1, null, null);
		LinkedListNode n2 = new LinkedListNode(2, null, null);
		LinkedListNode n3 = new LinkedListNode(3, null, null);
		LinkedListNode n4 = new LinkedListNode(3, null, null);
		LinkedListNode n5 = new LinkedListNode(3, null, null);
		LinkedListNode n6 = new LinkedListNode(4, null, null);
		LinkedListNode n7 = new LinkedListNode(5, null, null);
		LinkedListNode n8 = new LinkedListNode(5, null, null);
		
		head.setNext(n1);
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(n7);
		n7.setNext(n8);

		System.out.println(head.printForward());
		
		head = cyclicRightShift(head, 3);
				
		System.out.println(head.printForward());
	}

}
