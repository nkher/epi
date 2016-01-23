package Strings;

public class Q7_1 {
	
	public static String itoa(int n) { // -12345
		
		StringBuilder sb = new StringBuilder();
		boolean neg = false;
		if (n < 0) {
			n = n * -1;
			neg = true;
		}
		
		int rem;
		while (n > 0) {
			rem = n % 10;
			sb.append(rem);
			n = n /10;
		}
				
		// reverse String
		String str = sb.reverse().toString();
		
		if (neg) {
			str = "-" + str;
		}

		return str;
	}
	
	public static int stoi(String s) { // 12345
		
		boolean neg = false;
		if (s.charAt(0) == '-') {
			neg = false;
			s = s.substring(1);
		}
		
		int num = 0;
		for (char c : s.toCharArray()) {
			
			int n = (int)(c - '0');
			num = (num * 10) + n;
		}
		
		if (neg) {
			num = num * -1;
		}
		
		return num;
	}
	
	public static void main(String[] args) {
		
		System.out.println(itoa(-23456));
		System.out.println(itoa(-12345));
		
		System.out.println(itoa(45));
		
		System.out.println(stoi("12345") + 89);
	}
	

}
