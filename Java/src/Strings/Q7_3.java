package Strings;

public class Q7_3 {
	
	public static boolean testPalindromicity(String s) {
		
		int start = 0, end = s.length() - 1;
		while (start < end) {
			if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
				return false;
			}
			start++;
			end--;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		System.out.println(testPalindromicity("nitiN"));

		System.out.println(testPalindromicity("Able was I ere I saw Elba"));
		
		System.out.println(testPalindromicity("Ray a Ray"));
		
		System.out.println((int) 'c' + " "  + (int)'C');
		System.out.println((int) 'a' + " "  + (int)'A');

		System.out.println((int) 'z' + " "  + (int)'Z');

	}

}
