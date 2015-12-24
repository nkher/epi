package HashTables;

import java.util.ArrayList;
import java.util.HashMap;

public class Q13_13 {
	
	// m -> number of words and, n -> length of each word
	// N -> size of the sentence
	// For any fixed i, to check if there is a concatenation takes  O(nm) time
	// There fore overall time complexity is O(N * n * m)
	public static ArrayList<Integer> findAllSubstrings(String sentence, ArrayList<String> words) {
		HashMap<String, Integer> dict = new HashMap<String, Integer>();
		for (String s : words) {
			if (!dict.containsKey(s)) {
				dict.put(s, 1);
			}
			else
				dict.put(s, dict.get(s) + 1);
		}
		
		int unitSize = words.get(0).length();
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for (int i=0; (i+unitSize * words.size()) <= sentence.length() ;i++) {
			if (matchAllWordsInDict(sentence, dict, i, words.size(), unitSize)) {
				result.add(i);
			}
		}
		
		return result;
	}
	
	public static boolean matchAllWordsInDict(String sentence, HashMap<String, Integer> dict, int start, int numWords, int unitSize) {
		
		HashMap<String, Integer> currDict = new HashMap<String, Integer>();
		for (int i=0; i<numWords; i++) {
			String currWord = sentence.substring((i*unitSize + start), (i*unitSize + start) + unitSize);
			if (!dict.containsKey(currWord)) {
				return false;
			}
			else {
				if (!currDict.containsKey(currWord)) {
					currDict.put(currWord, 1);
				}
				else
					currDict.put(currWord, currDict.get(currWord) + 1);
			}
			
			// make an error check
			if (currDict.get(currWord) > dict.get(currWord)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		String sentence = "amanaplanacanal";
		
		 ArrayList<String> words = new ArrayList<String>();
		 words.add("can");
		 words.add("apl");
		 words.add("ana");
		
		for (int i : findAllSubstrings(sentence, words)) {
			System.out.println("At index " + i + " the substring is : " + sentence.substring(i, (i + (words.size() * words.get(0).length()))));
		}
	}

}
