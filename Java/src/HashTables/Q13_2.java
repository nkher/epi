package HashTables;

import java.util.HashMap;

public class Q13_2 {
	
	// TC : O(n) and space complexity : O(c) -> c is number of unique chars
	public static boolean checkPalindrome(String s) {
		int len = s.length();
		if (len < 3) return true;
		int max_allowed_unique, num_unique_chars;
		
		if ( (s.length()&1) == 1 ) { max_allowed_unique = len/2 + 1; } // odd case
		else max_allowed_unique = len/2; // even case
				
		HashMap<Character, Integer> characterCounts = new HashMap<Character, Integer>();
		for (Character c : s.toCharArray()) {
			if (characterCounts.containsKey(c)) {
				characterCounts.put(c, (characterCounts.get(c) + 1) );
			} else {
				characterCounts.put(c, 1);
			}
		}
		
		// Now checking against the number of unique characters
		num_unique_chars = characterCounts.size();
		if (num_unique_chars > max_allowed_unique) return false;
		
		int odd_counts = 0;
		for (Character c : characterCounts.keySet()) {
			if ( (characterCounts.get(c) & 1) == 1)
				odd_counts++;
		}
		
		if ( (len & 1) == 0 && odd_counts > 0 ) return false; // even case, no odd_count allowed
		
		if ( (len & 1) == 1 && odd_counts > 1 ) return false; // odd case, only 1 odd_count allowed
		
		return true;
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(checkPalindrome("aabbffee"));
	}

}
