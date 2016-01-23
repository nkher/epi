	package Strings;

import java.util.ArrayList;

public class Q7_5 {
	
	public static final String NumTelDig[] = {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
	
	public ArrayList<String> phoneCombinations(String phoneNo) {
		char[] partialComb = new char[phoneNo.length()];
		ArrayList<String> combinations = new ArrayList<String>();
		phoneCombinations(phoneNo, 0, partialComb, combinations);
		return combinations;
	}
	
	private ArrayList<String> phoneCombinations(String phoneNo, int dig, char[] partialCombination, ArrayList<String> combinations) {
		if (dig == phoneNo.length()) {
			// All digit has been processed and one of the combinations have been made therefore add to array list
			combinations.add(new String(partialCombination));
		} 
		else {
			// iterate over all the characters for that digit
			int currNum = phoneNo.charAt(dig) - '0'; // very important step
			String chars = NumTelDig[currNum];
			for (char c : chars.toCharArray()) {
				partialCombination[dig] = c;
				// once you place the char at that position you would recurse
				phoneCombinations(phoneNo, dig+1, partialCombination, combinations);
			}
		}
		return combinations;
	}
	
	public static void main(String[] args) {
		String phoneNo = "4326696";
		Q7_5 obj = new Q7_5();
		ArrayList<String> combinations = obj.phoneCombinations(phoneNo);
		
		for (String s : combinations) {
			System.out.println(s);
		}
	}
}
