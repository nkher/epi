package HashTables;

import java.util.HashMap;

public class Q13_7 {

	public static int findNearestRepetition(String para[]) {
		
		HashMap<String, Integer> latestOccurence = new HashMap<String, Integer>();
		int closestDistance = Integer.MAX_VALUE;
		for (int i=0;i<para.length;i++) {			
			if (latestOccurence.containsKey(para[i])) {
				int prevOccInd = latestOccurence.get(para[i]);
				closestDistance = Math.min(closestDistance, i - prevOccInd);
			}
			latestOccurence.put(para[i], i);
		}
		
		return closestDistance;
	}
	
	public static void main(String[] args) {
		
		String para[] = {"All", "work", "and", "no", "play", "makes", "for", "no", "work", "no", "fun", "and", "no", "results"};
		
		System.out.println(findNearestRepetition(para));
	}

}
