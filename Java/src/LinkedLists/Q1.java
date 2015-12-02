package LinkedLists;

import Library.LinkedListNode;

public class Q1 {

	public static LinkedListNode mergeSortedLists(LinkedListNode h1, LinkedListNode h2) {
		
		LinkedListNode head = null, iter = null;
		while (h1 != null && h2 != null) {
						
			if (h1.data <= h2.data) {
				if (head == null) {
					head = h1;
					iter = head;
				}
				else {
					iter.next = h1;
					iter = iter.next;
				}
				h1 = h1.next;
			}
			else {
				if (head == null) {
					head = h2;
					iter = head;
				}
				else {
					iter.next = h2;
					iter = iter.next;
				}
				h2 = h2.next;
			}
		}
		
		iter.next = null;
		return head;
	}
	
	
	public static void main(String[] args) {
		
		LinkedListNode h1 = new LinkedListNode(1,null, null);
		LinkedListNode n2 = new LinkedListNode(5, null, null);
		LinkedListNode n3 = new LinkedListNode(10, null, null);
		
		h1.setNext(n2);
		n2.setNext(n3);
		
		LinkedListNode h2 = new LinkedListNode(2, null, null);
		LinkedListNode n4 = new LinkedListNode(4, null, null);
		LinkedListNode n5 = new LinkedListNode(15, null, null);
		
		h2.setNext(n4);
		n4.setNext(n5);
		
		System.out.println(h1.printForward());
		System.out.println(h2.printForward());
		
		LinkedListNode mergedHead = mergeSortedLists(h1, h2);
		System.out.println(mergedHead.printForward());
	}

}
