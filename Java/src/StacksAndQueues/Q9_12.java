package StacksAndQueues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Q9_12<T extends Comparable<T>> {
	
	private Queue<T> queue;
	private Deque<T> deque;
	
	public Q9_12() {
		queue = new LinkedList<T>();
		deque = new LinkedList<T>();
	}
	
	public void enqueue(T v) {
		queue.add(v);
		insertDeque(v);
	}
	
	// Handling this logic is the key here
	// When you try to put in a dequeue, you first compare the 
	// incoming elements to the tail of the dequeue
	// Until the element at the tail is smaller keep removing it once you find a greater 
	// element let it be there and insert the new incoming element
	private void insertDeque(T v) {
		if (deque.isEmpty()) {
			deque.add(v);
		}
		else {
			// Basically remove from tail till the last element is smaller than the incoming		
			while (!deque.isEmpty() && (v.compareTo(deque.getLast()) == 1)) {
				deque.removeLast();
			}
			deque.add(v);
		}
	}
	
	
	public void dequeue() {
		T front = queue.remove();
		if (deque.peek().equals(front)) {
			deque.remove();
		}
	}
	
	public T max() {
		return deque.peek();
	}
	
	public String toString() {
		return queue.toString();
	}
	
	public String dequeToString() { // this ideally must not be there
		return deque.toString();
	}
	
	public T peek() {
		return queue.peek();
	}	
	
	public static void main(String[] args) {
		
		Q9_12<Integer> queueWithMax = new Q9_12<Integer>();
		queueWithMax.enqueue(3);
		queueWithMax.enqueue(1);
		queueWithMax.enqueue(3);
		queueWithMax.enqueue(2);
		queueWithMax.enqueue(0);
		
		// Elements in the queue
		System.out.println(queueWithMax.toString());
		
		System.out.println(queueWithMax.dequeToString());
		
		System.out.println(queueWithMax.toString());
		System.out.println("Max is : " + queueWithMax.max());
		
		queueWithMax.enqueue(1);
		System.out.println(queueWithMax.toString());
		System.out.println("Max is : " + queueWithMax.max());
		
		queueWithMax.dequeue();
		System.out.println(queueWithMax.toString());
		System.out.println("Max is : " + queueWithMax.max());
		
		queueWithMax.dequeue();
		System.out.println(queueWithMax.toString());
		System.out.println("Max is : " + queueWithMax.max());
		
		queueWithMax.enqueue(2);
		System.out.println(queueWithMax.toString());
		System.out.println("Max is : " + queueWithMax.max());

		queueWithMax.enqueue(4);
		System.out.println(queueWithMax.toString());
		System.out.println("Max is : " + queueWithMax.max());
		
		queueWithMax.dequeue();
		System.out.println(queueWithMax.toString());
		System.out.println("Max is : " + queueWithMax.max());
		
		queueWithMax.enqueue(4);
		System.out.println(queueWithMax.toString());
		System.out.println("Max is : " + queueWithMax.max());
	}
}
