package LinkedLists;

import Library.LinkedListNode;


public class Q8_9 {
	
	public static LinkedListNode removeDupsSortedList(LinkedListNode head) {
		
		if (head == null) return null;
		
		LinkedListNode temp = head, prev = head;
		temp = temp.next;
		
		while (temp != null) {
			
			if (prev.data == temp.data) {
				temp = temp.next;
				prev.next = temp;
				continue;
			}
			prev = temp;
			temp = temp.next;
		}
		
		return head;
	}
	
	public static void main(String args[]) {
		
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
		
		head = removeDupsSortedList(head);
		
		System.out.println(head.printForward());
	}
}
