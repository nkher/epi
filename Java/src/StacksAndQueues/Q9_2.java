package StacksAndQueues;

import java.util.Stack;

public class Q9_2 {

	public static int evaluateRPN(String s) {
		
		char[] str = s.toCharArray();
		Stack<Integer> stack = new Stack<Integer>();
		for (int i=0;i<str.length;i++) {
			char token = s.charAt(i);
			
			if (token == '+' || token == '-' || token == '*' || token == '-') {
				
				int x = stack.pop();
				int y = stack.pop();
				
				switch (token) {
				case '+':
					stack.push(x + y);
					break;
					
				case '-':
					stack.push(x - y);
					break;
					
				case '*':
					stack.push(x * y);
					break;
					
				case '/':
					stack.push(x / y);
					break;

				default:
					break;
				}
			}
			else
				stack.push((int)(token - '0'));
		}
		
		return stack.pop();
	}
	
	public static int stoi(String s) {
		
		boolean neg = false;
		if (s.charAt(0) == '-') {
			neg = true;
			s = s.substring(1);
		}
		int num = 0;
		
		for (char c : s.toCharArray()) {
			
			int n = (int)c - '0';
			num = (num * 10) + n;
		}
		
		if (neg) {
			num = num * (-1);
		}
		
		return num;
	}
	
	public static void main(String[] args) {
		
		String s = "34+2*1+";
		System.out.println(evaluateRPN(s));
	}

}
