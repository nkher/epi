package Strings;

public class Q7_6 {
	
	// TC is a function of the length of the terms
	// Each successive calls has at most twice as many digits as the previous number
	// Therefor a simple bound would be O(n * 2^n)
	public static String lookAndSay(int n) {
		String s = "1";
		for (int i=1;i<n;i++) {
			s = nextNumberString(s);
		}
		return s;
	}
	
	public static String nextNumberString(String s) {
		StringBuilder ret = new StringBuilder();
		for (int i=0;i<s.length();i++) {
			int count = 1;
			while ((i+1 < s.length()) && s.charAt(i) == s.charAt(i+1)) { // the (i+1) check has to come in the first
				i++;
				count++;
			}
			// here we form the string
			ret.append(count); // append the count
			ret.append(s.charAt(i)); // and then what count it is
		}
		return ret.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(lookAndSay(5));
	}

}
