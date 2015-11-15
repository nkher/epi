package Arrays;

import java.util.Arrays;

public class Q6_3 {
	
	public static String multiplyStrings(String num1, String num2) {
		
		boolean isPositive = true;
		// check if the number is positive or negative
		if (num1.charAt(0) == '-') {
			isPositive = !isPositive;
			num1 = num1.substring(1);
		}
		if (num2.charAt(0) == '-') {
			isPositive = !isPositive;
			num2 = num2.substring(1);
		}
		
		char n1[] = num1.toCharArray();
		char n2[] = num2.toCharArray();
		int l1 = n1.length, l2 = n2.length;
		
		int[] result = new int[l1 + l2];
		
		// Reverse both the numbers
		n1 = reverseArray(n1);
		n2 = reverseArray(n2);
				
		
		// Core logic for multiplication
		for (int i=0;i<l1;i++) {
			
			for (int j=0;j<l2;j++) {				
				result[i+j] += (n1[i] - '0') * (n2[j] - '0');
				result[i+j+1] += result[i+j] / 10;
				result[i+j] %= 10;
			}
		}
		// Core logic for multiplication ends
		
		System.out.println(Arrays.toString(result));

		
		// Convert the string in reverse order, skip the first 0s and keeps one zero if all are zeros
		int i = l1 + l2 - 1;
		while (result[i] == 0 && i != 0) {
			--i;
		}
		
		StringBuffer sb = new StringBuffer();
		if (!isPositive && result[i] != 0) {
			sb.append("-");
		}
		
		while (i >= 0) {
			sb.append(result[i--]);
		}
		
		return sb.toString();
		
	}
	
	public static char[] reverseArray(char[] number) {
		int start = 0, end = number.length-1;
		while (start <= end) {
			char temp = number[start];
			number[start] = number[end];
			number[end] = temp;
			end--;
			start++;
		}
		return number;
	}
	
	public static void main(String[] args) {	
		System.out.println(multiplyStrings("12", "11"));
	}
}
