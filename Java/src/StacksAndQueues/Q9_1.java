package StacksAndQueues;

public class Q9_1 extends Stack {
		
	Stack s2; // This separate stack will maintain the max element
	
	public Q9_1(int capacity) {
		super(capacity);
		s2 = new Stack(capacity);
	}

	public void push(int data) throws Exception {
		if (data > max()) {
			s2.push(data);
		}
		super.push(data);
	}
	
	public int max() throws Exception {
		if (s2.isEmpty()) {
			return Integer.MIN_VALUE;
		}
		return s2.peek();
	}
	
	public int pop() throws Exception {
		int value = super.pop();
		if (value == max()) {
			s2.pop();
		}
		return value;
	}
	
	public static void main(String[] args) throws Exception {
		
		// Test the created stack
		Stack stack = new Stack(5);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(50);
		stack.push(40);
		
		stack.print();
				
		// Creating a max stack
		Q9_1 maxStack = new Q9_1(7);
		maxStack.push(50);
		
		System.out.println("\nMax is : " + maxStack.max());
		
		maxStack.push(1);
		
		System.out.println("\nMax is : " + maxStack.max());
		
		maxStack.push(34);
		
		System.out.println("\nMax is : " + maxStack.max());
		
		maxStack.push(78);
		
		System.out.println("\nMax is : " + maxStack.max());
		
		maxStack.push(67);
		
		System.out.println("\nMax is : " + maxStack.max());
		
		maxStack.push(90);
		
		System.out.println("\nMax is : " + maxStack.max());
		
		maxStack.push(17);
		
		System.out.println("\nMax is : " + maxStack.max());
		
		maxStack.print();
	}
}

class Stack {
	
	private int size = 0;
	private int capacity;
	private int top = -1;
	private int stack[];
	
	public Stack(int capacity) {
		this.capacity = capacity;
		stack = new int[capacity];
	}
	
	public void push(int data) throws Exception {
		if (isFull()) {
			System.out.println("\nInsert unsuccessfull. Sorry stack is full. Cannot insert more elements.");
			return;
		}
		stack[++top] = data;
	}
	
	public int pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Pop() unsuccessfull. Stack is empty.");
		}
		return stack[top--];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == capacity-1;
	}
	
	public int peek() throws Exception {
		if (isEmpty()) {
			throw new Exception("Peek() unsuccessfull. Stack is empty.");
		}
		return stack[top];
	}
	
	public int capacity() {
		return capacity;
	}
	
	public int size() {
		return size;
	}
	
	public void print() {
		if (isEmpty()) {
			System.out.println("Sorry stack is empty.");
			return;
		}
		System.out.print("\nStack Elements : [ ");
		for (int i=0;i<=top;i++) {
			System.out.print(stack[i] + " ");
		}
		System.out.print("]\n");
	}
}
