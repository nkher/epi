package Strings;

import java.util.ArrayList;

public class Q7_8 {
	
	public static ArrayList<String> getAllValidIPs(String s) {
		ArrayList<String> result = new ArrayList<String>();
		
		for (int i=1; i<4 && i<s.length(); ++i) {
			String first = s.substring(0, i);
			if (isValidPart(first)) {
				
				for (int j=1; (i+j) < s.length() && j<4; ++j) {
					String second = s.substring(i, j);
					if (isValidPart(second)) {
						
						for (int k=1; (i+j+k) < s.length() && k<4; ++k) {
							String third = s.substring(i+j, k);
							String fourth = s.substring(i + j + k);
							if (isValidPart(third) && isValidPart(fourth)) {
								result.add(first + "." + second + "." + third + "." + fourth);
							}
						}
					}
				}
			}
		}
		return result;
	}
	
	public static boolean isValidPart(String s) {
		if (s.length() > 3) {
			return false;
		}
		
		if (s.charAt(0) == '0' && s.length() > 1) {
			return false;
		}
		
		int val = stoi(s);
		return val <= 255 && val >= 0;
	}
	
	public static int stoi(String s) {
		boolean isPositive = true;
		if (s.charAt(0) == '-') {
			isPositive = !isPositive;
		}
		
		int num = 0;
		for (int i=0;i<s.length();i++) {
			num = (num * 10) + (s.charAt(i) - '0');
		}
		
		if (!isPositive) {
			num = -num;
		}
		return num;
	}
	
	public static void main(String[] args) {
		
		System.out.println(getAllValidIPs("19216811").toString());
	}

}
