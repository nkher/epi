package HashTables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Q13_14 {
	
	// Pair of pages with highest affinity
	public static StringPair highestAffinityPair(File file) throws IOException {
		
		// web pages to a user map
		HashMap<String, HashSet<String>> pageUsersMap = new HashMap<String, HashSet<String>>();
		// maintains all the unique webpages for iteration
		ArrayList<String> webpages = new ArrayList<String>();
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = "";
		HashSet<String> users;
		while ( (line = br.readLine()) != null ) {
			String a[] = line.split(",");
			
			// add the page if not present
			if (!pageUsersMap.containsKey(a[0])) {
				pageUsersMap.put(a[0], new HashSet<String>());
				webpages.add(a[0]);
			}
			// add the user
			users = pageUsersMap.get(a[0]);
			users.add(a[1]);
			pageUsersMap.put(a[0], users);
		}
		
		StringPair result = new StringPair("", "");
		
		int maxCount = 0;
		
		// compare all pairs of pages to users maps
		for (int i=0;i<webpages.size();i++) {
			for (int j=i+1; j<webpages.size(); j++) {
				
				int count = getIntersectionCount(pageUsersMap.get(webpages.get(i)), pageUsersMap.get(webpages.get(j)));
				
				if (count > maxCount) {
					maxCount = count;
					result.reset(webpages.get(i), webpages.get(j));
				}
			}
		}
		return result;
	}
	
	public static int getIntersectionCount(HashSet<String> set1, HashSet<String> set2) {
		
		ArrayList<String> users1 = new ArrayList<String>();
		for (String user : set1) {
			users1.add(user);
		}
		
		int count = 0;
		for (String user : users1) {
			if (set2.contains(user)) {
				count++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		
		
		File file = new File("hashtables//Q13_14");
		System.out.println(highestAffinityPair(file).toString());
	}

}

class StringPair {
	String x, y;
	
	public StringPair(String x, String y) {
		this.x = x;
		this.y = y;
	}
	
	public void reset(String x, String y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "[ " + x + ", " + y + " ]";
  	}
}
