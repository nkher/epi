package GreedyAlgorithmsAndInvariants;

public class Q18_6 {

	// TC = O(n)
	// we are taking a string array instead of a stream
	public static String majorityElement(String a[]) {
		
		String candidate=null, buf;
		int count = 0;
		for (int i=0; i<a.length; i++) {
			
			buf = a[i];
			if (count == 0) {
				candidate = buf;
				count = 1; // make the count as 1
			}
			else if (candidate.equals(buf)) {
				count++;
			}
			else {
				count--;
			}
		}
		return candidate;
	}
	
	public static void main(String args[]) {
		
		String arr[] = {"messi", "ronaldo", "ronaldo", "messi", "xavi", "iniesta", "iniesta", "messi", "neymar", "ronaldo", "messi", "suarez", "benzema",
						"messi", "bale", "messi", "messi", "messi", "bale", "messi", "messi"};
		
		System.out.println(majorityElement(arr));
	}
}
