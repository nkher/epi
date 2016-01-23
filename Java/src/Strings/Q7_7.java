package Strings;

import java.util.HashMap;

public class Q7_7 {
	
	public static int romanToInteger(String s) {
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		int n = s.length();
		int sum = map.get(s.charAt(n - 1));
		
		for (int i=n-2;i>=0;i--) {
			
			if (map.get(s.charAt(i)) < map.get(s.charAt(i+1))) {
				sum -= map.get(s.charAt(i));
			}
			else {
				sum += map.get(s.charAt(i));
			}
		}
		
		return sum;
	}
	
	public static void main(String []args) {
		
		System.out.println(romanToInteger("LIX"));
		System.out.println(romanToInteger("IC"));
	}
}
