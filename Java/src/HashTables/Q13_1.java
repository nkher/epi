package HashTables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Q13_1 {
		
	/* Find group of anagrams from the given list - O(n * mlogm)*/
	public static ArrayList<ArrayList<String>> findAnagramGroups(ArrayList<String> list) {
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<String> anagramGroup;
		for (String s : list) {
			
			String sorted_S = sort(s);
			if (map.containsKey(sorted_S)) {
				anagramGroup = map.get(sorted_S);
			} else {
				anagramGroup = new ArrayList<String>();
			}
			anagramGroup.add(s);
			map.put(sorted_S, anagramGroup);
		}
		
		for (String s : map.keySet()) {
			if (map.get(s).size() >= 2)
				result.add(map.get(s));
				
		}
		return result;
	}
	
	public static boolean areEqual(String s, String b) {
		s = sort(s); 
		b = sort(b);
		if (s.compareTo(b) == 0) return true;
		return false;
	}
	
	public static String sort(String s) {
		char[] s_arr = s.toCharArray();
		Arrays.sort(s_arr);
		return new String(s_arr);
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("debitcard");
		list.add("silent");
		list.add("elvis");
		list.add("badcredit");
		list.add("lives");
		list.add("freedom");
		list.add("listen");
		list.add("levis");
		
		ArrayList<ArrayList<String>> result = findAnagramGroups(list);
		
		for (ArrayList<String> r : result) {
			System.out.println(r.toString() + " \n");
		}
	}
}
